package com.userapi.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private int httpCode;

	private HttpStatus httpStatus;

	private String errorMessage;

	private List<String> errors;

	public ErrorResponse(int httpCode, HttpStatus httpStatus, String errorMessage) {
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(int httpCode, HttpStatus httpStatus, String errorMessage, List<String> errors) {
		super();
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.errors = errors;
		this.httpCode = httpCode;
	}

	public ErrorResponse(int httpCode, HttpStatus httpStatus, String errorMessage, String errors) {
		super();
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.errors = Arrays.asList(errors);
		this.httpCode = httpCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

}
