package com.example.timesheet.model.dto;

import com.example.timesheet.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private String code;
    private String name;
//    private List<GroupDto> groups;

    public static DepartmentDto build(Department department) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(department, DepartmentDto.class);
    }
}
