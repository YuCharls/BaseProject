package com.example.yc.mvpdemo.base;

/**
 * 基础业务 Bean 得到 对应错误码 和错误信息
 * Created by YuChao on 2017/6/8.
 */

public class BaseBean {

    public BodyBean body;
    public CommonBean common;

    public static class BodyBean {

        public int code;
        public String msg;
        public ResponseBean response;

        public static class ResponseBean {
        }
    }

    public static class CommonBean {
        public String token;
    }
}
