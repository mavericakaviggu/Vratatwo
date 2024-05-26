package com.thinkconstructive.vratatwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {
	
	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException (CloudVendorNotFoundException cloudVendorNotFoundException)
	{
		
		
		CloudVendorException cloudVendorException = new CloudVendorException(
				cloudVendorNotFoundException.getMessage(),
				cloudVendorNotFoundException.getCause(),
				HttpStatus.NOT_FOUND //to show the error message in payload

				); 
		return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);//Here httpstatus is used to show error message in API call.
	}

}
