package com.example.yc.mvpdemo.fragment;

import android.app.Activity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.chaychan.uikit.refreshlayout.BGANormalRefreshViewHolder;
import com.chaychan.uikit.refreshlayout.BGARefreshLayout;
import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.base.BaseFragment;
import com.example.yc.mvpdemo.bean.LoginResponseBean;
import com.example.yc.mvpdemo.contract.Fragment1Contract;
import com.example.yc.mvpdemo.mvp.IView;
import com.example.yc.mvpdemo.presenter.Fragment1Presenter;
import com.google.gson.Gson;

/**
 * Created by YuChao
 */

public class Fragment1 extends BaseFragment<Fragment1Presenter>
        implements Fragment1Contract.Fragment1View, IView,
        BGARefreshLayout.BGARefreshLayoutDelegate {

    EditText inputEmail;
    EditText inputPassword;
    AppCompatButton btnLogin;

    BGARefreshLayout mRefreshLayout;//刷新 布局
    private String phone;
    private String password;

    public Fragment1(Activity thisActiviy) {
        super(thisActiviy);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment1;
    }

    @Override
    protected void initView(View rootView) {


        inputEmail = getViewById(rootView, R.id.input_email);
        inputPassword = getViewById(rootView, R.id.input_password);
        btnLogin = getViewById(rootView, R.id.btn_login);
        mRefreshLayout = getViewById(rootView, R.id.refresh_layout);
    }

    @Override
    protected void initData() {
        mRefreshLayout.setDelegate(this);

        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGANormalRefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), false);
        // 设置下拉刷新
        refreshViewHolder.setRefreshViewBackgroundColorRes(R.color.selector_grey);//背景色
        refreshViewHolder.setPullDownRefreshText("下拉推荐");//下拉的提示文字
        refreshViewHolder.setReleaseRefreshText("松开推荐");//松开的提示文字
        refreshViewHolder.setRefreshingText("推荐中");//刷新中的提示文字

        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
//        mRefreshLayout.shouldHandleRecyclerViewLoadingMore(mRvNews);

    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void getViewOnClick(int viewId) {
        switch (viewId) {
            case R.id.btn_login:
                phone = inputEmail.getText().toString().trim();
                password = inputPassword.getText().toString().trim();


                mPresenter.clickButton(phone, password);
                break;

        }
    }

    @Override
    protected Fragment1Presenter getLoadPresenter() {
        Fragment1Presenter mFragment1Presenter;
        mFragment1Presenter = new Fragment1Presenter();
        return mFragment1Presenter;
    }

    @Override
    public void successInfo(LoginResponseBean str) {
        mToast("成功" + new Gson().toJson(str));
    }

    @Override
    public void failInfo(String str) {

        for (int i = 0; i < 2; i++) {

            if (i == 2 - 1) {
                mToast("失败:" + str);
                if (mRefreshLayout.getCurrentRefreshStatus() ==
                        BGARefreshLayout.RefreshStatus.REFRESHING) {
                    mRefreshLayout.endRefreshing();
                }
            }
        }
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
//        if (mRefreshLayout.getCurrentRefreshStatus() ==
//                BGARefreshLayout.RefreshStatus.REFRESHING) {
//            mRefreshLayout.endRefreshing();
//        }
        mPresenter.clickButton(phone, password);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
