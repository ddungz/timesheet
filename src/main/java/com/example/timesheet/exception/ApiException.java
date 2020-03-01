package com.example.timesheet.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	private HttpStatus status;

	public ApiException(String message) {
		this.message = message;
	}

	public ApiException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public ApiException(Throwable cause, String message) {
		super(cause);
		this.message = message;
	}

	public ApiException(Throwable cause, String message, HttpStatus status) {
		super(cause);
		this.message = message;
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Map<String, Object> toResponse() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", this.message);
		if (this.status != null) {
			map.put("status", Integer.valueOf(this.status.value()));
		}

		return map;
	}
}
