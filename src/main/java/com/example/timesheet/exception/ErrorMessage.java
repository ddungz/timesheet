package com.example.timesheet.exception;

import org.springframework.http.HttpStatus;

import com.example.timesheet.util.Constants;

public enum ErrorMessage {

    INVALID_ACCOUNT(Constants.MSG_INVALID_ACCOUNT, HttpStatus.BAD_REQUEST);

    private String message;

    private HttpStatus status;

    ErrorMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ErrorMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }

    public void throwError() {
        throw new ApiException(message, status);
    }
}	