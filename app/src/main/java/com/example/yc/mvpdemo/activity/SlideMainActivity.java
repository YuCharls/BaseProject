package com.example.yc.mvpdemo.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.base.BaseActiviy;
import com.example.yc.mvpdemo.fragment.Fragment1;
import com.example.yc.mvpdemo.fragment.Fragment2;
import com.example.yc.mvpdemo.fragment.Fragment3;
import com.example.yc.mvpdemo.fragment.Fragment4;
import com.example.yc.mvpdemo.mvp.IView;
import com.example.yc.mvpdemo.presenter.SlideMainPresenter;

/**
 * Created by YuChao on 2017/6/9.
 */

public class SlideMainActivity extends BaseActiviy<SlideMainPresenter> implements IView {


    private LinearLayout wdcy_item;
    private LinearLayout wddd_item;
    private LinearLayout fkw_item;
    private LinearLayout wdzx_item;


    private Fragment1 mainFragment1 = new Fragment1();
    private Fragment2 mainFragment2 = new Fragment2();
    private Fragment3 mainFragment3 = new Fragment3();
    private Fragment4 mainFragment4 = new Fragment4();
    private FragmentTransaction mFragmentTransaction;
    private Fragment fragment;


    @Override

    protected int getLayoutId() {
        return R.layout.activity_main_layout_above;
    }

    @Override
    protected void initView() {
        wdcy_item = (LinearLayout) findViewById(R.id.wdcy_item);
        wddd_item = (LinearLayout) findViewById(R.id.wddd_item);
        fkw_item = (LinearLayout) findViewById(R.id.fkw_item);
        wdzx_item = (LinearLayout) findViewById(R.id.wdzx_item);
    }

    @Override
    protected void initData() {
        fragment = mainFragment1;
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.content_frame, mainFragment1).commitAllowingStateLoss();
        switchBottomIcon(wddd_item);
    }

    @Override
    protected void initListener() {
        wdcy_item.setOnClickListener(this);
        wddd_item.setOnClickListener(this);
        fkw_item.setOnClickListener(this);
        wdzx_item.setOnClickListener(this);
        wddd_item.setSelected(true);
    }

    @Override
    protected void getViewOnClick(int viewId) {

        switch (viewId) {
            //底部菜栏 上面的按钮  展示当前点击条目 同时展示当前条目 是被点击

            //第一页面
            case R.id.wddd_item:
                cutFragment(fragment, mainFragment1);
                switchBottomIcon(wddd_item);
                break;
            //第二页面
            case R.id.fkw_item:
                cutFragment(fragment, mainFragment2);
                switchBottomIcon(fkw_item);
                break;

            //第三页面
            case R.id.wdzx_item:
                cutFragment(fragment, mainFragment3);
                switchBottomIcon(wdzx_item);
                break;
            //第四页面
            case R.id.wdcy_item:
                cutFragment(fragment, mainFragment4);
                switchBottomIcon(wdcy_item);
                break;

        }
    }

    @Override
    protected SlideMainPresenter getLoadPresenter() {
        SlideMainPresenter mSlideMainPresenter;
        mSlideMainPresenter = new SlideMainPresenter();
        return mSlideMainPresenter;
    }

    /**
     * 切换fragment
     *
     * @param f1 现在看见的 fragment
     * @param f2 切换变到的 fragment
     */
    public void cutFragment(Fragment f1, Fragment f2) {
        if (f2 != f1) {
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment = f2;
            if (!f2.isAdded()) {
                mFragmentTransaction.hide(f1).add(R.id.content_frame, f2).commitAllowingStateLoss();
            } else {
                mFragmentTransaction.hide(f1).show(f2).commitAllowingStateLoss();
            }
        }
    }

    /**
     * 切换 底部 按钮的 样式
     *
     * @param showView 显示的按钮样式
     */
    public void switchBottomIcon(View showView) {
        wdcy_item.setSelected(false);
        wddd_item.setSelected(false);
        fkw_item.setSelected(false);
        wdzx_item.setSelected(false);
        showView.setSelected(true);
    }
}
