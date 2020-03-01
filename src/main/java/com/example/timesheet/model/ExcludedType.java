package com.example.timesheet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tbl_t_excluded_types")
@Data
public class ExcludedType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(min = 4, max = 4)
	private String type;
	
	@NotBlank
	@Size(max = 128)
	private String name;

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
