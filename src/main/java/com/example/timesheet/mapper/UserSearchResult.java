package com.example.timesheet.mapper;

import com.example.timesheet.model.Role;
import com.example.timesheet.model.User;

import java.util.List;

public class UserSearchResult {

    private Long id;

    private User user;

    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
