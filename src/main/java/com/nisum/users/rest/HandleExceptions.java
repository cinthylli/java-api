package com.nisum.users.rest;

import javax.persistence.PersistenceException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class HandleExceptions extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
		String bodyOfResponse = ex.getName() + " debe ser del tipo " + ex.getRequiredType().getName();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value =  {PersistenceException.class} )
	public ResponseEntity<Object> manejarPersistenceException(PersistenceException ex, WebRequest request){	
		String bodyOfResponse ="No ha sido posible guardar en base de datos.";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAll (Exception ex, WebRequest request){
		String bodyOfResponse ="Se ha generado una excepcion";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}	
}
