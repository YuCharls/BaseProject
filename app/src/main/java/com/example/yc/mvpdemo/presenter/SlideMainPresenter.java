package com.example.yc.mvpdemo.presenter;

import android.support.v4.app.FragmentTransaction;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.activity.SlideMainActivity;
import com.example.yc.mvpdemo.base.BasePresenter;
import com.example.yc.mvpdemo.contract.SlideMainContract;
import com.example.yc.mvpdemo.fragment.Fragment1;
import com.example.yc.mvpdemo.fragment.Fragment2;
import com.example.yc.mvpdemo.fragment.Fragment3;
import com.example.yc.mvpdemo.fragment.Fragment4;

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
