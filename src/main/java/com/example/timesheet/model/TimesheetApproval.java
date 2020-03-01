package com.example.timesheet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tbl_t_timesheet_approvals")
@Data
@AllArgsConstructor
public class TimesheetApproval implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "timesheet_history_id")
	private Long timesheetHistoryId;
	
	@Column(name = "approval_level")
	private String approvalLevel;
	
	@Column(name = "approved_by")
	private String approvedBy;
	
	@Column(name = "approved_at")
	private Date approvedAt;
	
	@Column(name = "corrected_project_id")
	private Long correctedProjectId;
	
	@Column(name = "corrected_day_type")
	private String correctedDayType;
	
	@Column(name = "corrected_work_type")
	private String correctedWorkType;
	
	@Column(name = "corrected_is_overnight_work")
	private Boolean correctedIsOvernightWork;
	
	@Column(name = "corrected_is_night_shift")
	private Boolean correctedIsNightShift;
	
	@Column(name = "corrected_start_time")
	private String correctedStartTime;
	
	@Column(name = "corrected_end_time")
	private String correctedEndTime;
	
	@Column(name = "corrected_duration")
	private String correctedDuration;
	
	@Column(name = "corrected_with_note")
	private String correctedWithNote;
	
	@Column(name = "start_time_error_type")
	private String startTimeErrorType;
	
	@Column(name = "end_time_error_type")
	private String endTimeErrorType;
	
	@JsonIgnore
	@Column(name = "created_at")
	private Date createdAt;
	
	@JsonIgnore
	@Column(name = "created_by")
	private String createdBy;
	
	@JsonIgnore
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@JsonIgnore
	@Column(name = "updated_by")
	private String updatedBy;
	
	@JsonIgnore
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	@JsonIgnore
	@Column(name = "deleted_by")
	private String deletedBy;
}
