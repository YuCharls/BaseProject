package com.example.yc.mvpdemo.contract;

import com.example.yc.mvpdemo.bean.LoginResponseBean;

/**
 * Created by YuChao on 2017/6/11.
 */

public class Fragment1Contract {

    public interface Fragment1View {
        void successInfo(LoginResponseBean str);

        void failInfo(String str);
    }

    public interface Fragment1Presenter {

        void clickButton(String phone, String password);
    }

}
