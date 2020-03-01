package com.example.timesheet.model.dto;

import com.example.timesheet.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

@Data
@AllArgsConstructor
public class TimesheetListUserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String departmentName;
    private String groupName;
    private String userFullName;
    private String userCode;
    private String month;
    private int deviatedTime;
    private int missedLogTime;
    private int leavedOutTime;
    private String selfConfirmation;
    private String managerConfirmation;
    private int correctionPaymentTime;
    private int correctionHolidayTime;
    private int correctionOtherTime;
    private String assistantConfirmation;
    private String generalConfirmation;

    TimesheetListUserDto(Department department) {
    }

    private DepartmentDto department;

    private class DepartmentDto {
        private Long id;
        private String code;
        private String name;
        private List<GroupDto> groups;
    }

    private class GroupDto {
        private Long id;
        private String code;
        private String name;
        private String parentCode;
    }
    
    private class ScheduleDto {
        
    }
}
