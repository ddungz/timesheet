package com.example.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.model.Timesheet;
import com.example.timesheet.repository.TimesheetRepository;
import com.example.timesheet.service.TimesheetService;

@Service
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	
	@Override
	public List<Timesheet> getAllTimesheets() {
		return null;
	}
	
	@Override
	public List<Timesheet> search() {
		return timesheetRepository.findAll();
	}
	
}
