package com.example.timesheet.service.impl;

import com.example.timesheet.repository.ProjectRepository;
import com.example.timesheet.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

//    public Project findByCodeAndUsers(String code) {
//        return projectRepository.findByCodeAndUsers(code).get();
//    }
}
