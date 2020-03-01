package com.example.timesheet.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.timesheet.model.response.ApiErrorResponse;

import java.net.URI;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(AccessDeniedException.class)
//	public ResponseEntity<ApiErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.UNAUTHORIZED)
//				.withError_code(HttpStatus.UNAUTHORIZED.name()).withMessage(ex.getLocalizedMessage())
//				.withDetail(ex.getMessage()).build();
//
//		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//	}
//
//	@ExceptionHandler(AuthenticationException.class)
//	public ResponseEntity<ApiErrorResponse> handleAuthenticationException(AuthenticationException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.UNAUTHORIZED)
//				.withError_code(HttpStatus.UNAUTHORIZED.name()).withMessage(ex.getLocalizedMessage())
//				.withDetail(ex.getMessage()).build();
//
//		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//	}
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ApiErrorResponse> handleInvalidException(MethodArgumentNotValidException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.BAD_REQUEST)
//				.withError_code(HttpStatus.BAD_REQUEST.name()).withMessage(ex.getLocalizedMessage())
//				.withDetail(ex.getMessage()).build();
//
//		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	public ResponseEntity<ApiErrorResponse> handleTypeMisMatchException(MethodArgumentTypeMismatchException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.BAD_REQUEST)
//				.withError_code(HttpStatus.BAD_REQUEST.name()).withMessage(ex.getLocalizedMessage())
//				.withDetail(ex.getMessage()).build();
//		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(MissingServletRequestParameterException.class)
//	public ResponseEntity<ApiErrorResponse> handleMissingRequestParameterException(MissingServletRequestParameterException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.BAD_REQUEST)
//				.withError_code(HttpStatus.BAD_REQUEST.name()).withMessage(ex.getLocalizedMessage())
//				.withDetail(ex.getMessage()).build();
//		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
//
	@ExceptionHandler(RequestValidationException.class)
	public ResponseEntity<ApiErrorResponse> handleBindingValidationException(RequestValidationException ex) {
        ApiErrorResponse response = ApiErrorResponse.ApiErrorResponseBuilder.instance()
                .withStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                .withCode(ex.getCode())
                .withMessage(ex.getMessage())
				.withDetails(ex.getDetails())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	// NOT WORKING
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity handleNoHandlerFoundException() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/404"));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}


//
//	@ExceptionHandler(ApiException.class)
//	public ResponseEntity<ApiErrorResponse> handleCustomApiException(ApiException ex) {
//		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(ex.getStatus())
//				.withError_code(ex.getStatus().name()).withMessage(ex.getLocalizedMessage()).withDetail(ex.getMessage())
//				.build();
//		HttpStatus stt = ex.getStatus();
//		return new ResponseEntity<>(response, ex.getStatus());
//	}
}
