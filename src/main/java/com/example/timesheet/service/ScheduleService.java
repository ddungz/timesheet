package com.example.timesheet.service;

import com.example.timesheet.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ScheduleService {
    Optional<Schedule> findById(Long id);

    Optional<Schedule> findByUserId(Long userId);

    Optional<Schedule> findByUserIdAndMonth(Long userId, String month);
}
