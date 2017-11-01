package com.example.yc.mvpdemo.base;

/**
 * Created by YuChao
 * 抽取的一个基类的bean,直接在泛型中传data就行
 */

public class BaseHttpResult<T> {
    
    private int status;
    private String message;
    private T data;

    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        
        return "BaseHttpResult{" 
                + "status=" + status 
                + ", message='" + message + '\'' 
                + ", data=" + data +
                '}';
    }
}
