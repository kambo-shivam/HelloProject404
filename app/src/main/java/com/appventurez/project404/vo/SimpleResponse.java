package com.appventurez.project404.vo;

public class SimpleResponse<T> extends CommonChildResponse {

    T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
