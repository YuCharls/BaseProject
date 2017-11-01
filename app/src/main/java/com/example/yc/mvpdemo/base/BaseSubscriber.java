package com.example.yc.mvpdemo.base;



import com.example.yc.mvpdemo.exception.ApiException;
import com.example.yc.mvpdemo.utils.GsonUtil;

import io.reactivex.Observer;

//import rx.Subscriber;


/**
 * Created by YuChao
 */

public abstract class BaseSubscriber<T> implements Observer<String> {

    private T t1;

    protected BaseSubscriber(T t) {
        super();
        this.t1 = t;

    }

    @Override
    public void onNext(String jsonString) {

        T t = (T) GsonUtil.GsonToBean(jsonString, t1.getClass());

        onSuccess(t);

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
