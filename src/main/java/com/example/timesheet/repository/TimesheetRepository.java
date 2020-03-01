package com.example.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.timesheet.model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
	
}
