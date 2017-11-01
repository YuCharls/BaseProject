package com.example.yc.mvpdemo.utils;

import android.util.Log;

/**
 * 类 描述 Log打印日志类
 */
public class LogUtil {

    private static final String TAG = "Yc";

    //测试环境为true
    public static final boolean DEBUG = true;

    //生产环境为false
//    public static final boolean DEBUG = false;

    public static void v(Object message) {
        if (DEBUG) {
            Log.v(TAG, message.toString());
        }
    }

    public static void i(Object message) {
        if (DEBUG) {
            Log.i(TAG, message.toString());
        }
    }

    public static void e(Object message) {
        if (DEBUG) {
            Log.e(TAG, message.toString());
        }
    }

    public static void d(Object message) {
        if (DEBUG) {
            Log.d(TAG, message.toString());
        }
    }

    public static void w(Object message) {
        if (DEBUG) {
            Log.w(TAG, message.toString());
        }
    }


    public static void v(String tag, Object message) {
        if (DEBUG) {
            Log.v(tag, message.toString());
        }
    }

    public static void i(String tag, Object message) {
        if (DEBUG) {
            Log.i(tag, message.toString());
        }
    }

    public static void e(String tag, Object message) {
        if (DEBUG) {
            Log.e(tag, message.toString());
        }
    }

    public static void d(String tag, Object message) {
        if (DEBUG) {
            Log.d(tag, message.toString());
        }
    }


    public static void w(String tag, Object message) {
        if (DEBUG) {
            Log.w(tag, message.toString());
        }
    }

    public static void w(Object message, Throwable tr) {
        if (DEBUG) {
            Log.w(TAG, message.toString(), tr);
        }
    }

    public static void w(String tag, Object message, Throwable tr) {
        if (DEBUG) {
            Log.w(tag, message.toString(), tr);
        }
    }


    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (DEBUG) {
            Log.e("jiemo_" + cls.getSimpleName(), msg);
        }
    }


    /**
     * 解除 解析json的 字数限制
     *
     * @param tag     标志
     * @param content 内容
     */
    public static void logi(String tag, String content) {
        try {
            if (DEBUG) {
                int p = 2048;
                long length = content.length();
                if (length < p || length == p)
                    Log.i(tag, content);
                else {
                    while (content.length() > p) {
                        String logContent = content.substring(0, p);
                        content = content.replace(logContent, "");
                        Log.i(tag, logContent);
                    }
                    Log.i(tag, content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
