package com.example.yc.mvpdemo.base;

import com.example.yc.mvpdemo.http.Http;
import com.example.yc.mvpdemo.http.HttpService;
import com.example.yc.mvpdemo.mvp.IModel;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.base
 */

public class BaseModel implements IModel {

    protected static HttpService httpService;

    //初始化httpService
    static {
        httpService = Http.getHttpService();
    }

}
