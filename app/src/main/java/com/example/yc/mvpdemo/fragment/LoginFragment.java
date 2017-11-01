package com.example.yc.mvpdemo.fragment;

import android.app.Activity;
import android.view.View;

import com.example.yc.mvpdemo.base.BaseFragment;
import com.example.yc.mvpdemo.base.BasePresenter;

/**
 *  Created by YuChao
 */

public class LoginFragment extends BaseFragment {


    protected LoginFragment(Activity activity) {
        super(activity);
    }

    @Override
    protected int getFragmentLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void getViewOnClick(int viewId) {

    }

    @Override
    protected BasePresenter getLoadPresenter() {
        return null;
    }
}
