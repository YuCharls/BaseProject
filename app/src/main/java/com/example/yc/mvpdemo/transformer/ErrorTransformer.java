package com.example.yc.mvpdemo.transformer;


import com.example.yc.mvpdemo.base.BaseBean;
import com.example.yc.mvpdemo.exception.ErrorType;
import com.example.yc.mvpdemo.exception.ExceptionEngine;
import com.example.yc.mvpdemo.exception.ServerException;
import com.example.yc.mvpdemo.utils.GsonUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
//import rx.Observable;
//import rx.functions.Func1;

/**
 * Created by YuChao
 */

public class ErrorTransformer<T> implements ObservableTransformer<T, T> {

    private static ErrorTransformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    /**
     * @return 线程安全, 双层校验
     */
    public static <T> ErrorTransformer<T> getInstance() {

        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer<>();
                }
            }
        }
        return errorTransformer;

    }

//    @Override
//    public Observable<T> call(Observable<T> responseObservable) {
//
//        return responseObservable.map(new Func1<T, T>() {
//            @Override
//            public T call(T httpResult) {
//
//                if (httpResult == null) {
//                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
//                }
//
//                String mJson = httpResult.toString();
//                BaseBean mBaseBean = GsonUtil.GsonToBean(mJson, BaseBean.class);
//
//                //判断对应的 token 是不是为空的 如果不是空的 就设置上 对应的 token
//                if (!TextUtils.isEmpty(mBaseBean.common.token)) {
//                    SPUtil.instance().setStringKey("Token", mBaseBean.common.token);
//                }
//
////                if (mBaseBean.body.response == null) {
////                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
////                }
//
//                if (!String.valueOf(mBaseBean.body.code).equals(String.valueOf(ErrorType.SUCCESS))) {
//                    throw new ServerException(mBaseBean.body.code, String.valueOf(mBaseBean.body.msg));
//                }
//
//
//                return (T) httpResult;
//
//            }
//        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
//            @Override
//            public Observable<? extends T> call(Throwable throwable) {
//                //ExceptionEngine为处理异常的驱动器throwable
//                throwable.printStackTrace();
//                return Observable.error(ExceptionEngine.handleException(throwable));
//            }
//        });
//
//    }


    @Override
    public ObservableSource<T> apply(Observable<T> responseObservable) {

        return responseObservable.map(new Function<T, T>() {
            @Override
            public T apply(T httpResult) throws Exception {
                if (httpResult == null) {
                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
                }

                String mJson = httpResult.toString();
                BaseBean mBaseBean = GsonUtil.GsonToBean(mJson, BaseBean.class);

//                //判断对应的 token 是不是为空的 如果不是空的 就设置上 对应的 token
//                if (!TextUtils.isEmpty(mBaseBean.common.token)) {
//                    SPUtil.instance().setStringKey("Token", mBaseBean.common.token);
//                }

//                if (mBaseBean.body.response == null) {
//                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
//                }
                
                    //报错的 可以 用
//                if (!String.valueOf(mBaseBean.body.code).equals(String.valueOf(ErrorType.SUCCESS))) {
//                    throw new ServerException(mBaseBean.body.code, String.valueOf(mBaseBean.body.msg));
//                }


                return (T) httpResult;
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
            @Override
            public ObservableSource<? extends T> apply(Throwable throwable) throws Exception {
                //ExceptionEngine为处理异常的驱动器throwable
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });


    }
}
