package com.prakarsh.projects.airBnbApp.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message, long l) {
        super(message);
    }
}
