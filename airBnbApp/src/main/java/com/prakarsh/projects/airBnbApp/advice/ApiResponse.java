package com.prakarsh.projects.airBnbApp.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private ApiError error;
    private LocalDateTime timeStamp;
    private T data;
    public  ApiResponse(){this.timeStamp = LocalDateTime.now();}
    public  ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error= error;
    }
}
