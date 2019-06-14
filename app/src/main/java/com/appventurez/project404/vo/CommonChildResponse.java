package com.appventurez.project404.vo;

public class CommonChildResponse {

    private String errorCode;
    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String code) {
        this.errorCode = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
