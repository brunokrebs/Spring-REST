package com.userapi.exception;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ErrorService simpleJSON;
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> exceptionHandler(Exception ex) {
		ApiError apiError = new ApiError("error occurred", ex.getLocalizedMessage());
		return new ResponseEntity<JSONObject>(simpleJSON.getErrorJSON(apiError), new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
