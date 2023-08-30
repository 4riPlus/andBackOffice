package com.sparta.andbackoffice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<RestApiException> IllegalArgumentExceptionHandler(IllegalArgumentException e) {
		log.info("GlobalExceptionHandler - IllegalArgumentExceptionHandler");
		RestApiException restApiException = new RestApiException(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(
				restApiException,
				HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<RestApiException> NullPointerExceptionHandler(NullPointerException e) {
		log.info("GlobalExceptionHandler - NullPointerExceptionHandler");
		RestApiException restApiException = new RestApiException(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(
				restApiException,
				HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler({UsernameNotFoundException.class})
	public ResponseEntity<RestApiException> UsernameNotFoundExceptionHandler(UsernameNotFoundException e) {
		log.info("GlobalExceptionHandler - UsernameNotFoundExceptionHandler");
		RestApiException restApiException = new RestApiException(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(
				restApiException,
				HttpStatus.BAD_REQUEST
		);
	}
}
