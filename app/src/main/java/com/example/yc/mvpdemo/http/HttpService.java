package com.example.yc.mvpdemo.http;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
//import rx.Observable;

/**
 * Created by YuChao
 * 网络请求的接口都在这里
 */

public interface HttpService {
    //登录接口
    
    //普通的 post  发送的是 键值对
    @FormUrlEncoded
    @POST("FundPaperTrade/AppUserLogin")
    Observable<String> loginPost(@FieldMap Map<String,String> map);
    
    //普通的 get  发送的 是键值对
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @GET("japi/toh")
    Observable<String> test(@QueryMap Map<String,String> params);
    
    //利用 body  直接 接受 json 数据的 
//    @FormUrlEncoded
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("login")
    Observable<String> login(@Body RequestBody route);


   



}
