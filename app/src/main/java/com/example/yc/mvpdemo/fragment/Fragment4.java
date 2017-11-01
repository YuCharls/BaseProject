package com.example.yc.mvpdemo.fragment;

import android.app.Activity;
import android.view.View;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.base.BaseFragment;
import com.example.yc.mvpdemo.base.BasePresenter;

/**
 * Created by YuChao
 */

public class Fragment4 extends BaseFragment {

    public Fragment4(Activity thisActiviy) {
        super(thisActiviy);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment4;
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
