package com.example.timesheet.repository;

import com.example.timesheet.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findById(Long id);
    Optional<Schedule> findByUserId(Long userId);
    Optional<Schedule> findByUserIdAndMonth(Long id, String month);
}
