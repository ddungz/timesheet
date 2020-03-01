package com.example.timesheet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "tbl_t_timesheets")
@Data
@ToString(exclude = {"schedule"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Timesheet extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "schedule_id")
	private Long scheduleId;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "work_type")
	private String workType;
	
	@Column(name = "holiday")
	private String holiday;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "logged_type")
	private String loggedType;
	
	@Column(name = "logged_start_time")
	private String loggedStartTime;
	
	@Column(name = "logged_end_time")
	private String loggedEndTime;
	
	@Column(name = "logged_connection_time")
	private String loggedConnectionTime;
	
	@Column(name = "deviated_start_time")
	private String deviatedStartTime;
	
	@Column(name = "deviated_end_time")
	private String deviatedEndTime;
	
	@Column(name = "evaluated_start_time")
	private String evaluatedStartTime;
	
	@Column(name = "evaluated_end_time")
	private String evaluatedEndTime;
	
	@Column(name = "corrected_start_time")
	private String correctedStartTime;
	
	@Column(name = "corrected_end_time")
	private String correctedEndTime;
	
	@Column(name = "corrected_duration")
	private String correctedDuration;
	
	@Column(name = "deviated_duration")
	private String deviatedDuration;
	
	@Column(name = "correction_note")
	private String correctionNote;
	
	@Column(name = "correction_payment")
	private String correctionPayment;
	
	@Column(name = "correction_holiday")
	private String correctionHoliday;
	
	@Column(name = "correction_other")
	private String correctionOther;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnore
	private Schedule schedule;
}
