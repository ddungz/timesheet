package com.example.timesheet.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class RequestValidationException extends RuntimeException {

    private HttpStatus status;

    private int code;

    private String message;

    private List<String> details;

    public RequestValidationException() {
        super();
    }

    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String message, List<String> details) {
        super(message);
        this.message = message;
        this.details = details;
    }

    public RequestValidationException(Throwable cause, List<String> details) {
        super(cause);
        this.details = details;
    }

    public RequestValidationException(String message, List<String> details, HttpStatus status, int code) {
        super(message);
        this.message = message;
        this.details = details;
        this.status = status;
        this.code = code;
    }
}
