package com.example.timesheet.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
public class ApiErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    private int code;

    private String message;

    private List<String> details;


    public static final class ApiErrorResponseBuilder {
        private HttpStatus status;
        private int code;
        private String message;
        private List<String> details;

        public ApiErrorResponseBuilder() {
        }

        public static ApiErrorResponseBuilder instance() {
            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder withCode(int code) {
            this.code = code;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder withDetails(List<String> details) {
            this.details = details;
            return this;
        }

        public ApiErrorResponse build() {
            ApiErrorResponse response = new ApiErrorResponse();
			response.status = this.status;
			response.code = this.code;
			response.message = this.message;
			response.details = this.details;
            return response;
        }
    }
}
