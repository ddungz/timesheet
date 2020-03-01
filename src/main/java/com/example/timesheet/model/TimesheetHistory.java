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

import lombok.Data;

@Entity
@Table(name = "tbl_t_timesheet_histories")
@Data
public class TimesheetHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "timesheet_id")
	private Long timesheetId;
	
	@Column(name = "latest_timesheet_approval_id")
	private Long latestTimesheetApprovalId;

	@Column(name = "project_id")
	private Long projectId;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "day_type")
	private String dayType;
	
	@Column(name = "work_type")
	private String workType;
	
	@Column(name = "is_overnight_work")
	private Boolean isOvernightWork;
	
	@Column(name = "is_night_shift")
	private Boolean isNightShift;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "note")
	private String note;
	
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
