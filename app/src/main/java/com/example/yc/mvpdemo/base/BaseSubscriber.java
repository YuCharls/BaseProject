package com.example.yc.mvpdemo.base;


import com.example.yc.mvpdemo.exception.ApiException;
import com.example.yc.mvpdemo.utils.GsonUtil;
import com.example.yc.mvpdemo.utils.LogUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;

//import rx.Subscriber;


/**
 * Created by YuChao
 */

public abstract class BaseSubscriber<T> implements Observer<String> {
    private static final String TAG = "BaseSubscriber";
    
//    private T t;
//    private Class<T> clazz;

    private Type type;

    protected BaseSubscriber() {
        super();
        Type genType = getClass().getGenericSuperclass();
        //兼容泛型嵌套
        type = ((ParameterizedType) genType).getActualTypeArguments()[0];

        LogUtil.i(TAG, ",onNext: type:" + type);
    }

//    protected BaseSubscriber(T t) {
//        super();
//        this.t = t;
//        Type genType = getClass().getGenericSuperclass();
//        type = ((ParameterizedType) genType).getActualTypeArguments()[0];//兼容泛型嵌套
//    }

    @SuppressWarnings("unchecked")
    @Override
    public void onNext(String jsonString) {
        T t = GsonUtil.GsonToBean(jsonString, type);
        if (t != null) {
            onSuccess(t);
        }

    }

    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }


    public abstract void onSuccess(T t);


    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);

}
