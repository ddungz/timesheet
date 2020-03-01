package com.example.timesheet.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_t_schedule_approvals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"schedule"}, callSuper = true)
public class ScheduleApproval extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "schedule_id")
	private Long scheduleId;

	@Column(name = "approval_status")
	private String approvalStatus;
	
	@Column(name = "approval_level")
	private String approvalLevel;
	
	@Column(name = "approved_by")
	private String approvedBy;
	
	@Column(name = "approved_at")
	private Date approvedAt;

	@Column(name = "total_deviation")
	private Integer totalDeviation;
	
	@Column(name = "total_missed_log")
	private Integer totalMissedLog;
	
	@Column(name = "total_leave")
	private Integer totalLeave;

	@Column(name = "total_correction_payment")
	private Integer totalCorrectionPayment;

	@Column(name = "total_correction_holiday")
	private Integer totalCorrectionHoliday;

	@Column(name = "total_correction_other")
	private Integer totalCorrectionOther;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "schedule_id", insertable = false, updatable = false, nullable = false)
	private Schedule schedule;
}
