package com.example.timesheet.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.example.timesheet.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.timesheet.model.Department;
import com.example.timesheet.model.User;
import com.example.timesheet.service.DepartmentService;
import com.example.timesheet.service.UserService;

@Controller
@RequiredArgsConstructor
public class TimesheetController {

	private final ScheduleService scheduleService;

	private final UserService userService;

	private final DepartmentService departmentService;


	@GetMapping("/timesheets")
	public String timesheets(Model model) {
		List<String> months = Arrays.asList("2020/12", "2020/01", "2020/02");
		List<Department> departments = departmentService.findAll();

		model.addAttribute("months", months);
		model.addAttribute("departments", departments);
		model.addAttribute("timesheetsActive", true);
		return "pages/manager/timesheet/list";
	}
	
	@GetMapping("/timesheets/{user_id}")
	public String timesheetSingle(Model model, @PathVariable(value = "user_id") Long userId) {
		String ld = LocalDate.of(2020, Month.FEBRUARY, 07).format( DateTimeFormatter.ofPattern("dd(EEE)", Locale.JAPANESE));
		List<String> months = Arrays.asList("2020/12", "2020/01", "2020/02");

		User user = userService.getOne(userId);
        
		model.addAttribute("months", months);
		model.addAttribute("timesheetsSingleActive", true);
		return "pages/manager/timesheet/single";
	}
}
