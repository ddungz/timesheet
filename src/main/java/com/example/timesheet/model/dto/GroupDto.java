package com.example.timesheet.model.dto;

import com.example.timesheet.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private String code;
    private String name;
    private String parentCode;
    private DepartmentDto department;

    public static GroupDto build(Department group) {
        ModelMapper mapper = new ModelMapper();
//        mapper.addMappings(group.getDepartment(), DepartmentDto.class);
        return mapper.map(group, GroupDto.class);
    }
}
