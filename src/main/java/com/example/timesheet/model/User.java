package com.example.timesheet.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "tbl_t_users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Data
@ToString(exclude = {"group", "projects", "schedules"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"group", "projects", "schedules"})
public class User extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 32)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @JsonIgnore
    private String password;

    private String firstname;

    private String lastname;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "excluded_type")
    private String excludedType;

    @Transient
    private String departmentName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_t_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            foreignKey = @ForeignKey(name = "none"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Group group;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Schedule> schedules;
}
