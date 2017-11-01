package com.example.yc.mvpdemo.contract;

import com.example.yc.mvpdemo.bean.LoginResponseBean;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.contract
 * 契约类,定义登录用到的一些接口方法
 */

public class SlideMainContract {

    public interface SlideMainView {
        String getUserName();

        String getPwd();

        void loginSuccess(LoginResponseBean str);

        void loginFail(String failMsg);
    }


    public interface SlideMainPresenter {

        void showFragment(int viewId);
    }
}
