package com.example.yc.mvpdemo.model;

import android.support.annotation.NonNull;

import com.example.yc.mvpdemo.base.BaseModel;
import com.example.yc.mvpdemo.bean.LoginResponseBean;
import com.example.yc.mvpdemo.config.ProApplication;
import com.example.yc.mvpdemo.exception.ApiException;
import com.example.yc.mvpdemo.subscriber.CommonSubscriber;
import com.example.yc.mvpdemo.transformer.CommonTransformer;
import com.example.yc.mvpdemo.utils.LogUtil;
import com.example.yc.mvpdemo.utils.ToJsonHeader;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.Disposable;
import okhttp3.RequestBody;

/**
 * Created by YuChao
 * <p>
 * com.example.yc.mvpdemo.model
 * <p>
 * 主要做一些数据处理呀,网路请求呀
 * 依然是业务逻辑和实体模型
 */

public class LoginModel extends BaseModel {


    private static final String TAG = "LoginModel";

    private boolean isLogin = false;

    private RequestBody body;

    public boolean login(@NonNull String username, @NonNull String pwd, @NonNull final InfoHint infoHint) {

        if (infoHint == null) {
            throw new RuntimeException("InfoHint不能为空");
        }

        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("phone", username);
            jsonObject.put("password", pwd);
            body = ToJsonHeader.setEnCodeResponseBody(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        httpService.login(body)
                .compose(new CommonTransformer<String>())
                .subscribe(new CommonSubscriber<LoginResponseBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSuccess(LoginResponseBean loginResponseBean) {
                        LogUtil.i(TAG, ",onNext: " + loginResponseBean.toString());

                        isLogin = true;
                        infoHint.successInfo(loginResponseBean);//推荐者层 成功回调
                    }

                    @Override
                    protected void onError(ApiException e) {
                        super.onError(e);

                        isLogin = false;
                        infoHint.failInfo(e.message);//推荐者层 失败回调
                    }
                });
        return isLogin;
    }


    //通过接口产生信息回调
    public interface InfoHint {

        void successInfo(LoginResponseBean str);

        void failInfo(String str);

    }

}
