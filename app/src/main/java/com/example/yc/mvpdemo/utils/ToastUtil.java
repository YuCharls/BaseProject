package com.example.yc.mvpdemo.utils;

import android.widget.Toast;

import com.example.yc.mvpdemo.config.ProApplication;


/**
 * Created by YuChao
 * com.example.yc.myapplication.utils
 */

public class ToastUtil {
    public static Toast toast;

    public static void setToast(String str) {

        if (toast == null) {
            toast = Toast.makeText(ProApplication.getmContext(), str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }
}
