package com.example.timesheet.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_t_groups", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})
@Data
@ToString(exclude = {"department"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"department"}, callSuper = true)
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "department"})
public class Group extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
}
