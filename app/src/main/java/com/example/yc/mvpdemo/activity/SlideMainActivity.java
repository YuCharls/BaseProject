package com.example.yc.mvpdemo.activity;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.base.BaseActiviy;
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
    private FrameLayout mContainer;


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
        //中心主Fragment页面
        mContainer = (FrameLayout) findViewById(R.id.content_frame);
    }

    @Override
    protected void initData() {
        mPresenter.showFragment(R.id.wdcy_item);
        switchBottomIcon(R.id.wdcy_item);
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
           
            //查运价
            case R.id.wddd_item:
                mPresenter.showFragment(viewId);
                switchBottomIcon(viewId);
                break;
            //发车
            case R.id.fkw_item:
                mPresenter.showFragment(viewId);
                switchBottomIcon(viewId);
                break;

            //看订单
            case R.id.wdzx_item:
                mPresenter.showFragment(viewId);
                switchBottomIcon(viewId);
                break;
            //空位
            case R.id.wdcy_item:
                mPresenter.showFragment(viewId);
                switchBottomIcon(viewId);
                break;
        
        }
    }

    @Override
    protected SlideMainPresenter getLoadPresenter() {

        SlideMainPresenter mSlideMainPresenter;
        mSlideMainPresenter = new SlideMainPresenter();
        return mSlideMainPresenter;
    }


    public void switchBottomIcon(int id) {
        switch (id) {
            //抢空位
            case R.id.wdcy_item:
                wdcy_item.setSelected(true);
                wddd_item.setSelected(false);
                fkw_item.setSelected(false);
                wdzx_item.setSelected(false);
                break;
            //查运价
            case R.id.wddd_item:
                wdcy_item.setSelected(false);
                wddd_item.setSelected(true);
                fkw_item.setSelected(false);
                wdzx_item.setSelected(false);
                break;
            //发车
            case R.id.fkw_item:
                wdcy_item.setSelected(false);
                wddd_item.setSelected(false);
                fkw_item.setSelected(true);
                wdzx_item.setSelected(false);
                break;
            //看订单
            case R.id.wdzx_item:
                wdcy_item.setSelected(false);
                wddd_item.setSelected(false);
                fkw_item.setSelected(false);
                wdzx_item.setSelected(true);
                break;

        }
    }
}
