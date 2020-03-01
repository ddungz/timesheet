package com.example.timesheet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.timesheet.model.Department;

@Service
public interface DepartmentService {
	List<Department> findAll();
	
	List<Department> findByCode(String parentCode);

	List<Department> findByCodeAndParentCodeCustomQuery(String departmentCode, String groupCode);
}
