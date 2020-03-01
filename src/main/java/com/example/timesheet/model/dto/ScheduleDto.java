package com.example.timesheet.model.dto;

import com.example.timesheet.model.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private String month;
    private String confirmedAt;
    private String approvedLevel;
//    private List<ScheduleApprovalDto> approvals;
//    private List<TimesheetDto> timesheets;

    public static ScheduleDto build(Schedule schedule) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(schedule, ScheduleDto.class);
    }
}
