package com.example.yc.mvpdemo.subscriber;

import android.content.Context;

import com.example.yc.mvpdemo.base.BaseSubscriber;
import com.example.yc.mvpdemo.exception.ApiException;
import com.example.yc.mvpdemo.utils.LogUtil;


/**
 * Created by YuChao
 * com.example.yc.myapplication.subscriber
 * <p>
 * 普通订阅者 的类
 */

public abstract class CommonSubscriber<T> extends BaseSubscriber<T> {

    private static final String TAG = "CommonSubscriber";

    private Context context;

    public CommonSubscriber() {
        super();
    }

//    public CommonSubscriber(Context context, T t) {
//        super(t);
//        this.context = context;
//
//    }

//    protected CommonSubscriber(T t) {
//        super(t);
//    }

    @Override
    public void onNext(String jsonString) {
        super.onNext(jsonString);
    }


    @Override
    protected void onError(ApiException e) {
        LogUtil.e(TAG, "错误信息为 " + "code:" + e.code + "   message:" + e.message);
    }

    //
//    @Override
//    public void onStart() {
//        if (!NetworkUtil.isNetworkAvailable(context)) {
//            LogUtil.e(TAG, "网络不可用");
//        } else {
//            LogUtil.e(TAG, "网络可用");
//        }
//    }
//
//
//    @Override
//    protected void onError(ApiException e) {
//
//        LogUtil.e(TAG, "错误信息为 " + "code:" + e.code + "   message:" + e.message);
//    }
//
//
//    @Override
//    public void onCompleted() {
//        LogUtil.e(TAG, "成功了");
//    }

}
