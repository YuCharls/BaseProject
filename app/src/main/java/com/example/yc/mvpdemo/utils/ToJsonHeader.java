package com.example.yc.mvpdemo.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.example.yc.mvpdemo.config.ProApplication;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

// 拼接报文头部
public class ToJsonHeader {
    private static final String TAG = "ToJsonHeader";

    public static String SetHeader(JSONObject body) {
        JSONObject tokenJSONObject = new JSONObject();
        JSONObject bodyJSONObject = new JSONObject();
        try {
            tokenJSONObject.put("token", "");
            tokenJSONObject.put("systemType", "android");
            tokenJSONObject.put("systemVersion", android.os.Build.VERSION.RELEASE);
            tokenJSONObject.put("deviceModel", android.os.Build.MODEL);
            tokenJSONObject.put("mobileId", ((TelephonyManager) ProApplication.getmContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId());

            bodyJSONObject.put("common", tokenJSONObject);
            bodyJSONObject.put("body", body);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LogUtil.logi(TAG, ",SetHeader: 未加密" + bodyJSONObject.toString());

        String encodeJson;

        encodeJson = AESUtil.encode(bodyJSONObject.toString(), "ycgjappdepart123");

        return encodeJson;

    }


    public static RequestBody setEnCodeResponseBody(JSONObject body) {

        JSONObject tokenJSONObject = new JSONObject();
        JSONObject bodyJSONObject = new JSONObject();
        try {
            tokenJSONObject.put("token", "");
            tokenJSONObject.put("systemType", "android");
            tokenJSONObject.put("systemVersion", android.os.Build.VERSION.RELEASE);
            tokenJSONObject.put("deviceModel", android.os.Build.MODEL);
            tokenJSONObject.put("mobileId", ((TelephonyManager) ProApplication.getmContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId());

            bodyJSONObject.put("common", tokenJSONObject);
            bodyJSONObject.put("body", body);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LogUtil.logi(TAG, ",SetHeader: 未加密" + bodyJSONObject.toString());

        String encodeJson;

        encodeJson = AESUtil.encode(bodyJSONObject.toString(), "ycgjappdepart123");

        RequestBody encodeRequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), encodeJson);


        return encodeRequestBody;
    }

}
