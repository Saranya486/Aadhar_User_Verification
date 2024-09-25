package com.springboot.springboot.exception;

public class AadharSaveFailedException extends RuntimeException{
	private String message;
	
	public String getMessage() {
        return message;
    }


    public AadharSaveFailedException(String message) {
        this.message = message;
    }

    
    }
