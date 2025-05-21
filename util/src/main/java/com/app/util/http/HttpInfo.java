package com.app.util.http;

import org.springframework.http.HttpStatus;

import java.time.LocalTime;

public class HttpInfo {

    private final String message;
    private final String path;
    private final LocalTime localTime;
    private final HttpStatus httpStatus;


    public HttpInfo(String message , String path, HttpStatus httpStatus){
        this.message = message;
        this.path = path;
        this.httpStatus = httpStatus;
        this.localTime = LocalTime.now();
    }


    public String getMessage(){
        return this.message;
    }

    public String getPath(){
        return this.path;
    }

    public int getHttpStatus(){
        return this.httpStatus.value();
    }

    public LocalTime getLocalTime(){
        return this.localTime;
    }
}
