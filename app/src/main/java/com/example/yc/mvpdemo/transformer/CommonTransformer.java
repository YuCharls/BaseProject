package com.example.yc.mvpdemo.transformer;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;

/**
 * Created by YuChao on 2016/11/6.
 * 23:28
 */

public class CommonTransformer<T> implements ObservableTransformer<T, T> {

//    @Override
//    public Observable<T> call(Observable<T> tansFormerObservable) {
//      
//        return tansFormerObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(ErrorTransformer.<T>getInstance());
//    }

    @Override
    public ObservableSource<T> apply(Observable<T> tansFormerObservable) {
        
        return tansFormerObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorTransformer.<T>getInstance());
    }
}

