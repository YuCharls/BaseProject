package com.example.yc.mvpdemo.base;

import com.example.yc.mvpdemo.mvp.IPresenter;
import com.example.yc.mvpdemo.mvp.IView;

import java.lang.ref.WeakReference;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.base
 */

public abstract class BasePresenter<V extends IView> implements IPresenter {
    private WeakReference actReference;
    protected V iView;

//    public abstract HashMap<String, IModel> getiModelMap();

//    /**
//     * @param models 模型
//     * @return 添加多个model, 如有需要
//     */
//    public abstract HashMap<String, IModel> loadModelMap(IModel... models);
   
    @Override
    public void attachView(IView iView) {
        actReference = new WeakReference(iView);
    }

    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }

    @Override
    public V getIView() {
        return (V) actReference.get();
    }

}
