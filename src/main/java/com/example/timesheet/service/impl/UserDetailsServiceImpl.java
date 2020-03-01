package com.example.timesheet.service.impl;

import com.example.timesheet.auth.user.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.timesheet.exception.ApiException;
import com.example.timesheet.model.User;
import com.example.timesheet.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("USERNAME === " + username);
		User user = userRepository.findByUsername(username).orElseThrow(() ->
				new ApiException("Username " + username + " was not found", HttpStatus.BAD_REQUEST)
		);
		return UserPrincipal.build(user);
	}
}
