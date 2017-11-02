package com.example.yc.mvpdemo.http;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by admin on 2017/6/16.
 */

public class EncodeRequestBodyConverter<T> implements Converter<T, RequestBody> {

    public EncodeRequestBodyConverter(T gson, T adapter) {
        
    }

    @Override
    public RequestBody convert(T value) throws IOException {
//        Log.i("xiaozhang", "request中传递的json数据：" + value.toString());
//        data.setData(XXTEA.Encrypt(value.toString(), HttpConstant.KEY));
//        String postBody = gson.toJson(data); //对象转化成json
//        Log.i("xiaozhang", "转化后的数据：" + postBody);
//        return RequestBody.create(MEDIA_TYPE, postBody);
        
        
        
        return null;
    }
}