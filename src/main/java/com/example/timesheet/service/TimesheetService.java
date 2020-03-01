package com.example.timesheet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.timesheet.model.Timesheet;

@Service
public interface TimesheetService {
	List<Timesheet> getAllTimesheets();
	
	List<Timesheet> search();
}
