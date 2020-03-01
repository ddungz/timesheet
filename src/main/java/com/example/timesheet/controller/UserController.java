package com.example.timesheet.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.timesheet.model.Department;
import com.example.timesheet.model.User;
import com.example.timesheet.service.DepartmentService;
import com.example.timesheet.service.UserService;
import com.example.timesheet.util.LocaleMessage;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private LocaleMessage message;


	@GetMapping("/users")
	public String users(Model model) {
		
		Locale cr = LocaleContextHolder.getLocale();
		String mymsg = message.get("Hello");
		
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<User> users = userService.getUserWithPagination(pageRequest);
		
		List<Department> departments = departmentService.findAll();
		
		model.addAttribute("departments", departments);
		model.addAttribute("usersActive", true);
		return "pages/manager/user/list";
	}
}
