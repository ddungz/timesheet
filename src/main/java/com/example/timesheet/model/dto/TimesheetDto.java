package com.example.timesheet.model.dto;

import com.example.timesheet.model.Timesheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetDto {
    private Long scheduleId;
    private String day;
    private String workType;

    public static TimesheetDto build(Timesheet timesheet) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(timesheet, TimesheetDto.class);
    }
}
