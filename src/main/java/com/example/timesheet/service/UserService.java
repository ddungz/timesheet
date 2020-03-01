package com.example.timesheet.service;

import java.util.List;
import java.util.Optional;

import com.example.timesheet.model.request.TimesheetListShowRequest;
import com.example.timesheet.model.request.UserSearchRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.timesheet.model.User;

public interface UserService {

    Optional<User> findById(Long id);

    ResponseEntity<?> getUserDetails(String authHeader);


    User getOne(Long id);

    User getUser(Long id);

    List<User> getAllUsers();
    
    Page<User> getUserWithPagination(Pageable page);

    List<User> search(UserSearchRequest searchRequest);

//    User findByIdAndSchedulesMonth(Long id, String month);
    User getUserWithScheduleByTargetMonth(Long id, String month);

    List<User> getUsersByTimesheetListShowRequestSpec(TimesheetListShowRequest showRequest);

    List<User> findByDepartmentAndScheduleDetails(String month, String departmentCode, String groupCode);
}
