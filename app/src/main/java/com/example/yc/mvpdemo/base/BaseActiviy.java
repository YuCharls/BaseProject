package com.example.yc.mvpdemo.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.example.yc.mvpdemo.mvp.IView;
import com.example.yc.mvpdemo.utils.LogUtil;

/**
 * Created by YuChao
 */

public abstract class BaseActiviy<P extends BasePresenter> extends FragmentActivity implements
        IView, View.OnClickListener {

    protected View view;

    protected P mPresenter;

    //当前类名，打印使用
    private Class<? extends BaseActiviy> mClassName = this.getClass();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(mClassName + " ----------> oncreate");

        setContentView(getMyContentView());

        mPresenter = getLoadPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        initView();
        initListener();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i(mClassName + " ----------> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(mClassName + " ----------> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i(mClassName + " ----------> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i(mClassName + " ----------> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void getViewOnClick(int viewId);

    protected abstract P getLoadPresenter();

    /**
     * @return 显示的内容
     */
    public View getMyContentView() {

        view = View.inflate(this, getLayoutId(), null);

        return view;
    }

    /**
     * 点击的事件的统一的处理
     *
     * @param view 视图
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                getViewOnClick(view.getId());
                break;
        }

    }


    /**
     * 简化findView操作，无需每次都去强制转换
     *
     * @param id 简化findview 控件id
     * @return
     */
    protected <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }

    protected <T extends View> T getViewById(View v, int id) {
        return (T) v.findViewById(id);
    }

    /**
     * @param str 显示一个内容为str的toast
     */
    public void mToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param contentId 显示一个内容为contentId指定的toast
     */
    public void mToast(int contentId) {
        Toast.makeText(this, contentId, Toast.LENGTH_SHORT).show();
    }


    /**
     * @param str 日志的处理
     */
    public void LogE(String str) {
        LogUtil.e(getClass(), str);
    }

}

