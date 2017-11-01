package com.example.yc.mvpdemo.contract;

import com.example.yc.mvpdemo.bean.LoginResponseBean;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.contract
 * 契约类,定义登录用到的一些接口方法
 */

public class LoginContract {

    public interface LoginView {
        String getUserName();

        String getPwd();

        void loginSuccess(LoginResponseBean str);

        void loginFail(String failMsg);
    }


    public interface LoginPresenter {
        /**
         * 登录 业务逻辑
         *
         * @param name 姓名
         * @param pwd  密码
         */
        void clickLogin(String name, String pwd);
    }
}
