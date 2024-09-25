package com.springboot.springboot.exception;

public class AadharNotFoundException extends RuntimeException {
	
    private String message;
	
	public String getMessage() {
        return message;
    }


    public AadharNotFoundException(String message) {
        this.message = message;
    }

    
    }



