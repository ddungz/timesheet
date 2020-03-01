package com.example.timesheet.model.request;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class DepartmentSearchRequest {
    @Size(max = 6)
    private String code;

    @Size(max = 128)
    private String name;

    @Size(max = 128)
    private String parentCode;
    
    private static class DepartmentCriteriaBuilder {
    	private String code;
    	
    	private DepartmentCriteriaBuilder() {
    	}
    	
    	public static DepartmentCriteriaBuilder build() {
    		return new DepartmentCriteriaBuilder();
    	}
    	
    	public DepartmentCriteriaBuilder setCode(String code) {
    		this.code = code;
    		return this;
    	}
    }
}
