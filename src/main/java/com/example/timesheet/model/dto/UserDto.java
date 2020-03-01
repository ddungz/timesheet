package com.example.timesheet.model.dto;

import com.example.timesheet.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String departmentCode;
    private String groupCode;
    private String excludedType;

    public static UserDto build(User user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto dto =  mapper.map(user, UserDto.class);
        return dto;
    }
}
