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
@Table(name = "tbl_t_timesheet_leaves")
@Data
public class TimesheetLeave implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "timesheet_history_id")
	private Long timesheetHistoryId;

	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "work_on_rest_time")
	private Boolean workOnRestTime;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "corrected_start_time")
	private String correctedStartTime;
	
	@Column(name = "corrected_end_time")
	private String correctedEndTime;
	
	@Column(name = "corrected_work_on_rest_time")
	private Boolean correctedWorkOnRestTime;
	
	@Column(name = "corrected_duration")
	private String correctedDuration;
	
	@Column(name = "corrected_with_note")
	private String correctedWithNote;
	
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
