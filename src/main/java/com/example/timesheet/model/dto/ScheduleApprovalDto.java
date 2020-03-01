package com.example.timesheet.model.dto;

import com.example.timesheet.model.ScheduleApproval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleApprovalDto {
    private String approvalStatus;
    private String approvalLevel;
    private String approvedBy;
    private String approvedAt;
    private int differences;
    private int missedLogs;
    private int leaves;

    public static ScheduleApprovalDto build(ScheduleApproval scheduleApproval) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(scheduleApproval, ScheduleApprovalDto.class);
    }
}
