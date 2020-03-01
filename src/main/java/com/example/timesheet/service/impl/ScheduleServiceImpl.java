package com.example.timesheet.service.impl;

import com.example.timesheet.model.Schedule;
import com.example.timesheet.repository.ScheduleRepository;
import com.example.timesheet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;


    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Optional<Schedule> findByUserId(Long userId) {
        return scheduleRepository.findByUserId(userId);
    }

    @Override
    public Optional<Schedule> findByUserIdAndMonth(Long userId, String month) {
        return scheduleRepository.findByUserIdAndMonth(userId, month);
    }
}
