package com.example.yc.mvpdemo.http;

import com.example.yc.mvpdemo.utils.AESUtil;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by admin on 2017/6/16.
 */
public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    
    DecodeResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }
    @Override
    public T convert(ResponseBody value) throws IOException {
        //解密字符串
        return adapter.fromJson(AESUtil.decode(value.string(),"ycgjappdepart123"));
    }
}