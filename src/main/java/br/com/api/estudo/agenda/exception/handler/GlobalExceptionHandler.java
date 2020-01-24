package br.com.api.estudo.agenda.exception.handler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.api.estudo.agenda.exception.ResourceNotFoundException;
import br.com.api.estudo.agenda.exception.model.ResponseError;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public HttpEntity<ResponseError> handlerHttpRequestMethodNotFoundException(Exception ex) { 
		
		ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.value(), 
												HttpStatus.NOT_FOUND.name(),
												ex.getMessage());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class) 
	public HttpEntity<ResponseError> handlerHttpRequestMethodNotSupportedException(Exception ex) {
		ResponseError error = new ResponseError(HttpStatus.METHOD_NOT_ALLOWED.value(),
												HttpStatus.METHOD_NOT_ALLOWED.name(),
												ex.getMessage());
		return new ResponseEntity<ResponseError>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}

}
