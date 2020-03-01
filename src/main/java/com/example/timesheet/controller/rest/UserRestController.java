package com.example.timesheet.controller.rest;

import com.example.timesheet.auth.jwt.JwtProvider;
import com.example.timesheet.service.impl.UserDetailsServiceImpl;
import com.example.timesheet.model.User;
import com.example.timesheet.model.request.UserSearchRequest;
import com.example.timesheet.model.response.ApiResponse;
import com.example.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;


    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public ApiResponse search(@RequestParam("user") UserSearchRequest searchRequest) {
        List<User> users = userService.search(searchRequest);
        return ApiResponse.ApiResponseBuilder.instance()
                .withStatus(200)
                .withSuccess(true)
                .withMessage(null)
                .withData(users)
                .build();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ApiResponse all(Model model) {
        List<User> users = userService.getAllUsers();
        return ApiResponse.ApiResponseBuilder.instance()
                .withStatus(200)
                .withMessage("OK")
                .withSuccess(true)
                .withData(users)
                .build();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ApiResponse get(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        return ApiResponse.ApiResponseBuilder.instance()
                .withStatus(200)
                .withMessage("OK")
                .withSuccess(true)
                .withData(user)
                .build();
    }

    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public ApiResponse update(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        return ApiResponse.ApiResponseBuilder.instance()
                .withStatus(200)
                .withMessage("OK")
                .withSuccess(true)
                .withData(user)
                .build();
    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
    public ApiResponse delete(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        return ApiResponse.ApiResponseBuilder.instance()
                .withStatus(200)
                .withMessage("OK")
                .withSuccess(true)
                .withData(user)
                .build();
    }



    // Test
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @RequestMapping(value = "/gentoken", method = RequestMethod.GET)
    public ApiResponse gentoken(Model model) {
        String username = "asahinaka";
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(userDetails);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String token = jwtProvider.generateJwtToken(auth);
        System.out.println("JWT = " + token);

        return ApiResponse.ApiResponseBuilder.instance()
                .withData(token)
                .build();
    }
}
