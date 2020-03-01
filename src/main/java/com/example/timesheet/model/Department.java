package com.example.timesheet.model;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_t_departments", uniqueConstraints = {
		@UniqueConstraint(columnNames = "code")
})
@Data
@ToString(exclude = {"groups"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"groups"}, callSuper = true)
public class Department extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private List<Group> groups;
}
