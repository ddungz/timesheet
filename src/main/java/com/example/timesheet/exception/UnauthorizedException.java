package com.example.timesheet.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RuntimeException {
    private String message;

    private HttpStatus status;

    public UnauthorizedException(String message) {
        this.message = message;
    }

    public UnauthorizedException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public UnauthorizedException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

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

}
