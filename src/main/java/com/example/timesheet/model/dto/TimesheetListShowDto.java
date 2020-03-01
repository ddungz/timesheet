package com.example.timesheet.model.dto;

import com.example.timesheet.model.Department;
import com.example.timesheet.model.Project;
import com.example.timesheet.model.Schedule;
import com.example.timesheet.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@Data
@AllArgsConstructor
public class TimesheetListShowDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private GroupDto group;

    private UserDto user;

    private ProjectDto project;

    private ScheduleDto schedule;

    public TimesheetListShowDto(User user, Schedule schedule) {
        this.user = UserDto.build(user);

        Optional<Project> projectOptional = user.getProjects().stream().filter(prj -> "02".equals(prj.getStatus())).findFirst();
        projectOptional.ifPresent(currentPrj -> {
            this.project = ProjectDto.build(currentPrj);
        });

        this.schedule = ScheduleDto.build(schedule);
//        Department group = user.getGroup();
//        this.group = GroupDto.build(group);
    }
}
