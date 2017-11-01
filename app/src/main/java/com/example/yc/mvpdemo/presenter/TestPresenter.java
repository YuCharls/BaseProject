package com.example.yc.mvpdemo.presenter;

import com.example.yc.mvpdemo.activity.TestActivity;
import com.example.yc.mvpdemo.base.BasePresenter;
import com.example.yc.mvpdemo.bean.TestBean;
import com.example.yc.mvpdemo.contract.TestContract;
import com.example.yc.mvpdemo.model.TestModel;
import com.example.yc.mvpdemo.utils.LogUtil;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.presenter
 */

public class TestPresenter extends BasePresenter<TestActivity> implements
        TestContract.TestPresenter {
    private static final String TAG = "LoginPresenter";

    @Override
    public void clickTest(String month, String day) {
        TestModel mTestModel = new TestModel();
        mTestModel.testModel(month, day, new TestModel.InfoHint() {
            @Override
            public void successInfo(TestBean mTestBean) {
                getIView().onSuccess(mTestBean);  //视图层 成功 回调
            }

            @Override
            public void failInfo(String str) {
                LogUtil.e("LoginPresenter.failInfo", str);
                getIView().onFail(str);  //视图层 失败 回调
            }
        });
        
    }


}
