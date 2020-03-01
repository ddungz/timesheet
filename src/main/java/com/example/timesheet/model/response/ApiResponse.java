package com.example.timesheet.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;

    private String message;

    private Boolean success;

    private T data;

    public ApiResponse(ApiResponseBuilder<T> builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.success = builder.success;
        this.data = builder.data;
    }

    public static class ApiResponseBuilder<T> {
        private Integer status;
        private String message;
        private Boolean success;
        private T data;

        private ApiResponseBuilder() {
        }

        public static ApiResponseBuilder instance() {
            return new ApiResponseBuilder();
        }

        public ApiResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public ApiResponseBuilder withSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder withData(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }
}
