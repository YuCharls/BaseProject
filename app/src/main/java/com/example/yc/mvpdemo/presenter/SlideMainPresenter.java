package com.example.yc.mvpdemo.presenter;

import com.example.yc.mvpdemo.activity.SlideMainActivity;
import com.example.yc.mvpdemo.base.BasePresenter;
import com.example.yc.mvpdemo.contract.SlideMainContract;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.presenter
 */

public class SlideMainPresenter extends BasePresenter<SlideMainActivity> implements
        SlideMainContract.SlideMainPresenter {

    private static final String TAG = "SlideMainPresenter";


    private int mSelectedTab;

    @Override
    public void showFragment(int viewId) {
        
    }
}
