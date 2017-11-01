/*
 * Copyright (C) 2014 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.example.yc.mvpdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.yc.mvpdemo.config.ProApplication;

/**
 * Created by YuChao
 * 公共共享参数文件
 */
public class SPUtil {

    private SharedPreferences commonShare;
    private Editor commonEditor;
    // 单例模式
    private static SPUtil instance;
    // 存放配置信息的文件名称
    public final static String SP_CONFIG_FILENAME = "sp_cunchu";
    public final static String SP_ONCENAME = "once";

    public synchronized static SPUtil instance() {
        if (instance == null) {
            instance = new SPUtil();
        }
        return instance;
    }

    private SPUtil() {
        commonShare = ProApplication.getInstance().getSharedPreferences(SP_CONFIG_FILENAME, Context.MODE_PRIVATE);
        commonEditor = commonShare.edit();
    }


    /**
     * 获取公共共享信息
     *
     * @return 返回配置信息的值
     */
    public String getStringKey(String key, String delValue) {
        return commonShare.getString(key, delValue);
    }

    public String getStringPassWord(String key, String delValue) {
        return commonShare.getString(key, delValue);
    }

    public boolean getBooleanKey(String key, boolean delValue) {
        return commonShare.getBoolean(key, delValue);
    }

    public int getIntKey(String key, int delValue) {
        return commonShare.getInt(key, delValue);
    }

    public long getLongKey(String key, long delValue) {
        return commonShare.getLong(key, delValue);
    }

    /**
     * 设置公共共享信息
     *
     * @return 返回配置信息的值
     */
    public synchronized void setStringKey(String key, String value) {
        commonEditor.putString(key, value);
        commonEditor.commit();
    }

    public synchronized void setStringPassWord(String key, String value) {
        commonEditor.putString(key, value);
        commonEditor.commit();
    }

    public synchronized void setBooleanKey(String key, boolean value) {
        commonEditor.putBoolean(key, value);
        commonEditor.commit();
    }


    public synchronized void setIntKey(String key, int value) {
        commonEditor.putInt(key, value);
        commonEditor.commit();
    }

    public synchronized void setLongKey(String key, long value) {
        commonEditor.putLong(key, value);
        commonEditor.commit();
    }


}
