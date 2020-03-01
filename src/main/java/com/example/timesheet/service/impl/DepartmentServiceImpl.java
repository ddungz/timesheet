package com.example.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.model.Department;
import com.example.timesheet.repository.DepartmentRepository;
import com.example.timesheet.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;


	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Department> findByCode(String code) {
		return departmentRepository.findByCode(code);
	}

	@Override
	public List<Department> findByCodeAndParentCodeCustomQuery(String departmentCode, String groupCode) {
		return null;
	}
}
