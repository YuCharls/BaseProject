package com.example.yc.mvpdemo.config;


import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by YuChao
 * 应用,主要用来做一下初始化的操作
 */

public class ProApplication extends Application {

    private static Context mContext;

    private static ProApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        mContext = this;


        initManager();

    }

    /**
     * @return 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }

    public static ProApplication getInstance() {
        return instance;
    }


    private void initManager() {
        //内存泄漏检测
        LeakCanary.install(this);

        SPathException.getInstance().init(getApplicationContext());
        
    }

}
