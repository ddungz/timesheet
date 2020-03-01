package com.example.timesheet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.timesheet.auth.jwt.JwtAuthEntryPoint;
import com.example.timesheet.auth.jwt.JwtAuthTokenFilter;
import com.example.timesheet.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtAuthEntryPoint jwtAuthEntryPoint;

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/templates/**", "/js/**", "/css/**", "img");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.authorizeRequests()
					.antMatchers("/resources/**").permitAll()
					.antMatchers("/login").permitAll()
					.antMatchers("/api/gentoken").permitAll() //test
					.anyRequest().authenticated()
					.and()

				// TODO replace by sso
				.formLogin()
					.loginPage("/login")
					.failureUrl("/login-error")
					.permitAll().and()

				.exceptionHandling()
					.authenticationEntryPoint(jwtAuthEntryPoint);

				// TODO uncomment
//					.and()
//				.sessionManagement()
////					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////					.and()
//				.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public JwtAuthTokenFilter jwtAuthenticationTokenFilter() {
		return new JwtAuthTokenFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
