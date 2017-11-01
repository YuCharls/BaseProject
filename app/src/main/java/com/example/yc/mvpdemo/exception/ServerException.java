package com.example.yc.mvpdemo.exception;

/**
 * Created by YuChao
 * com.example.yc.myapplication.exception
 * <p>
 * 自定义的服务器异常
 */

public class ServerException extends RuntimeException {
    public int code;
    public String message;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
