package com.example.timesheet.model.request;

import javax.validation.constraints.Size;

public class UserSearchRequest {
    @Size(min = 3, max = 60)
    private String username;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
