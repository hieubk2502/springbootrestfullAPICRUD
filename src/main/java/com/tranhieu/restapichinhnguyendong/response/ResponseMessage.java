package com.tranhieu.restapichinhnguyendong.response;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
    private String message;
    public ResponseMessage(){
    }
    public ResponseMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
