package com.example.timesheet.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetListShowRequest {
    
	@NotNull
    @NotBlank
    @Size(min = 3, max = 60)
//    @DateTimeFormat(pattern = "yyyy-MM")//for Date type
    private String month;

    private String departmentCode;
    
    private String groupCode;
}
