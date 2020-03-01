package com.example.timesheet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="tbl_t_roles")
@Data
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
//	@Getter(AccessLevel.NONE)
	@Enumerated(EnumType.STRING)
	private RoleName name;
	
//	private String name;
	
	private String category;
	
	@Column(name = "category_name")
	private String categoryName;
	
	private String title;
	
	@Column(name = "display_order")
	private Integer displayOrder;
	
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
	
	
//	public RoleName getName() {
//		return name;
//	}
//
//	public void setName(RoleName name) {
//		this.name = name;
//	}
	
	@Override
	public int hashCode() {
        return Objects.hash(this.name);
    }
	
	@Override
	public boolean equals(Object o) {
        if (o == this) { return true; }
        if (o == null || !(o instanceof Role) ) { return false; }
        return Objects.equals(this.name, ((Role) o).name);
    }
}
