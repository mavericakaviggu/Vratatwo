package com.thinkconstructive.vratatwo.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	public static ResponseEntity<Object> customResponse(String message, HttpStatus httpStatus, Object responseObject){
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("HttpStatus",  httpStatus);
		response.put("data", responseObject);
		return new ResponseEntity<>(response, httpStatus);
		
	}

}
