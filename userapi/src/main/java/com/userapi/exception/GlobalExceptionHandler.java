package com.userapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> exceptionHandler(Exception ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error occurred", ex.getLocalizedMessage());
		return new ResponseEntity<Object>(apiError, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
