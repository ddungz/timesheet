package com.example.timesheet.model.dto;

import com.example.timesheet.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String code;
    private String name;
    private String status;

    public static ProjectDto build(Project project) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(project, ProjectDto.class);
    }
}
