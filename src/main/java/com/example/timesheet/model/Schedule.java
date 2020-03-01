package com.example.timesheet.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tbl_t_schedules")
@Data
@ToString(exclude = {"user", "timesheets", "approvals"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"user", "timesheets", "approvals"}, callSuper = true)
public class Schedule extends AuditModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "confirmed_status")
	private Boolean confirmedStatus;
	
	@Column(name = "confirmed_at")
	private Date confirmedAt;
	
	@Column(name = "approved_level")
	private String approvedLevel;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
	private List<Timesheet> timesheets = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
	private List<ScheduleApproval> approvals = new ArrayList<>();
}
