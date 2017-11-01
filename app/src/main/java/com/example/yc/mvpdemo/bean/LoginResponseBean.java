package com.example.yc.mvpdemo.bean;

public class LoginResponseBean {
    public BodyBean body;
    public CommonBean common;

    public static class BodyBean {

        public int code;
        public String msg;
        public ResponseBean response;

        public static class ResponseBean {

            public int authState;
            public String city;
            public String company;
            public String desc;
            public String headerPath;
            public String idCard;
            public int idCardAuth;
            public String idCardPath;
            public String name;
            public String nickname;
            public String phone;
            public String province;
            public int status;
        }
    }

    public static class CommonBean {
        public String token;
    }
}
