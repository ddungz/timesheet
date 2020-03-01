package com.example.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.timesheet.repository.UserRepository;
import com.example.timesheet.service.impl.UserDetailsServiceImpl;

@Controller
public class RouteController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = ERROR_PATH)
	public String error() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
		    return "redirect:/login";
		}
		return "errors/404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@GetMapping("/")
	public String link() {
		return "redirect:/users";
	}
	
	@PostMapping("/change")
	@ResponseBody
	public String changeLanguage(@RequestParam("lang") String lang) {
		return "";
	}


	
	@GetMapping("approvals")
	public String approvalDetail() {
		return "approval/detail";
	}
}
