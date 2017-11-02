package com.example.yc.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yc.mvpdemo.mvp.IView;
import com.example.yc.mvpdemo.utils.LogUtil;

/**
 * Created by YuChao
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment
        implements IView, View.OnClickListener {


    //贴附的activity
    protected Activity mActivity;

    protected View mRootView;

    protected View view;
    protected P mPresenter;

    //当前类名，打印使用
    private Class<? extends BaseFragment> mClassName = this.getClass();


    //配合ViewPager懒加载相关
    protected boolean isVisible;
    private boolean isPrepared;

    private boolean isFirst = true;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        LogUtil.i(mClassName + " ----------> onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(mClassName + " ----------> onCreate");

//        setContentView(getMyContentView());


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogUtil.i(mClassName + " ----------> onCreateView");
        if (null != mRootView) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(getFragmentLayoutId(), container, false);
            mPresenter = getLoadPresenter();
            if (mPresenter != null) {
                if (getActivity() != null) {
                    mPresenter.attachView(this);
                }
            }

            initView(mRootView);
            initListener();
            initData();
        }

        return mRootView;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.i(mClassName + " ----------> onActivityCreated");
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.i(mClassName + " ----------> onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i(mClassName + " ----------> onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.i(mClassName + " ----------> onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.i(mClassName + " ----------> onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.i(mClassName + " ----------> onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i(mClassName + " ----------> onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.i(mClassName + " ----------> onDetach");
    }

    //获取依附的Activity
    public Activity getMyActivity() {
        return mActivity;
    }

    public View getRootView() {
        return mRootView;
    }


    protected abstract int getFragmentLayoutId();

    protected abstract void initView(View rootView);

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void getViewOnClick(int viewId);

    protected abstract P getLoadPresenter();


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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        initData();
        isFirst = false;
    }

    //懒加载，界面不可见时执行
    protected void onInvisible() {

    }


    protected <T extends View> T getViewById(View v, int id) {
        return (T) v.findViewById(id);
    }

    /**
     * @param str 显示一个内容为str的toast
     */
    public void mToast(String str) {
        Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param contentId 显示一个内容为contentId指定的toast
     */
    public void mToast(int contentId) {
        Toast.makeText(mActivity, contentId, Toast.LENGTH_SHORT).show();
    }


}
