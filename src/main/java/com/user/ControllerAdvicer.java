package com.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvicer extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleConflict(Exception except, ServletWebRequest request) {
		String exceptName = except.getClass().getName();
		ResponseBody responseBody = new ResponseBody(exceptName, except.getMessage());
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		HttpHeaders httpHeaders = new HttpHeaders();
		return handleExceptionInternal(except,
				responseBody,
				httpHeaders,
				httpStatus,
				request);
	}
}
