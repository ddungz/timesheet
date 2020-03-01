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

//@DROPPED
//@Entity
//@Table(name = "tbl_t_schedule_corrections")
@Data
public class ScheduleCorrection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "schedule_approval_id")
	private Long scheduleApprovalId;
	
	@Column(name = "correction_type")
	private String correctionType;
	
	@Column(name = "total")
	private Integer total;

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
