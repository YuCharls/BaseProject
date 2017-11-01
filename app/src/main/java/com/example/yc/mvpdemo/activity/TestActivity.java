package com.example.yc.mvpdemo.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.base.BaseActiviy;
import com.example.yc.mvpdemo.bean.TestBean;
import com.example.yc.mvpdemo.contract.TestContract;
import com.example.yc.mvpdemo.mvp.IView;
import com.example.yc.mvpdemo.presenter.TestPresenter;
import com.example.yc.mvpdemo.utils.LogUtil;
import com.google.gson.Gson;

/**
 * Created by YuChao
 * <p>
 */
public class TestActivity extends BaseActiviy<TestPresenter>
        implements TestContract.TestView, IView {

    private static final String TAG = "TestActivity";

    EditText inputEmail;
    EditText inputPassword;
    AppCompatButton btnLogin;

    /**
     * 初始化 布局
     *
     * @return 布局id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化 视图
     */
    @Override
    protected void initView() {
        inputEmail = getViewById(R.id.input_email);
        inputPassword = getViewById(R.id.input_password);
        btnLogin = getViewById(R.id.btn_login);

    }

    /**
     * 初始化 数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化 监听
     */
    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    /**
     * 得到  点击事件的id
     *
     * @param viewId 点击事件的id
     */
    @Override
    protected void getViewOnClick(int viewId) {
        switch (viewId) {
            case R.id.btn_login:
                LogUtil.i(TAG, ",getViewOnClick: " + getUserName() + getUserName());

                //调用 推荐者中的 登录业务方法
                mPresenter.clickTest(getUserName(), getPwd());

                break;
        }
    }

    /**
     * 登录 处理逻辑层
     *
     * @return 登录的 逻辑类
     */
    @Override
    protected TestPresenter getLoadPresenter() {
        TestPresenter mTestPresenter;
        mTestPresenter = new TestPresenter();
        return mTestPresenter;
    }

    @Override
    public String getUserName() {
        String inputUserNeme;
        inputUserNeme = inputEmail.getText().toString().trim();
        return inputUserNeme;
    }

    @Override
    public String getPwd() {
        String inputMyPassword;
        inputMyPassword = inputPassword.getText().toString().trim();
        return inputMyPassword;
    }
    /**
     * 请求成功 返回的数据
     *
     * @param str 响应数据Bean对应的数据
     */
    @Override
    public void onSuccess(TestBean str) {

        mToast(new Gson().toJson(str));

        Intent intent = new Intent(this, SlideMainActivity.class);
        startActivity(intent); 
    }
    /**
     * 请求失败 返回的数据
     *
     * @param failMsg 响应数据
     */
    @Override
    public void onFail(String failMsg) {
        mToast(failMsg);
    }
    
}
