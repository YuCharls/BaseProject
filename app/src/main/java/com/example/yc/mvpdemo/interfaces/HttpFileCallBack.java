package com.example.yc.mvpdemo.interfaces;

public interface HttpFileCallBack {
    void onSuccess(String result);

    void onFiled(String errmsg);

    void onStart();

    void onLoading(long total, long current, boolean isUploading);
}
