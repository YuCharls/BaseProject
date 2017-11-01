package com.example.yc.mvpdemo.utils;

import android.content.Context;


import com.example.yc.mvpdemo.interfaces.HttpFileCallBack;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import id.zelory.compressor.Compressor;


public class HttpFileUtil {
    private static final String TAG = "HttpFileUtil";
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

//    /**
//     * 上传图片
//     *
//     * @param context   上下文
//     * @param picPath   图片地址
//     * @param imageType 图片类型
//     * @param callback  数据回调
//     */
//    public static void Upload(final Context context,
//                              final String picPath,
//                              final String imageType,
//                              final HttpFileCallBack callback) {
//
//        Runnable mRunnable = new Runnable() {
//            @Override
//            public void run() {
//                RequestParams params = new RequestParams();
//
//                try {
//                    File newfile = customCompressImage(context, new File(picPath));
//                    if (newfile != null) {
//                        params.addBodyParameter("imageFile", newfile);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                String token;
//                String uploadurl;
//                try {
//
//                    token = URLEncoder.encode(SPUtil.instance().getStringKey("Token", ""), "utf-8");
//                    uploadurl = Constants.APi_UPLoad + "token=" + token + "&imageType=" + imageType;
//
//                    LogUtil.w(TAG, uploadurl);
//
//
//                    HttpUtils http = new HttpUtils();
//
//                    http.send(HttpRequest.HttpMethod.POST, uploadurl, params, new RequestCallBack<String>() {
//                        @Override
//                        public void onLoading(long total, long current, boolean isUploading) {
//                            callback.onLoading(total, current, isUploading);
//                        }
//
//                        @Override
//                        public void onStart() {
//                            callback.onStart();
//                        }
//
//                        @Override
//                        public void onFailure(HttpException error, String msg) {
//                            LogUtil.v(StringEscapeUtils.unescapeJava(msg));
//                            callback.onFiled(msg);
//                        }
//
//                        @Override
//                        public void onSuccess(ResponseInfo<String> responseInfo) {
//                            if (responseInfo != null) {
//                                LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
//                                callback.onSuccess(responseInfo.result);
//                            }
//                        }
//                    });
//
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        };
//        executorService.execute(mRunnable);
//    }
//
//
//    /**
//     * 上传图片 通过 文件流
//     *
//     * @param context   上下文
//     * @param newfile   图片地址
//     * @param imageType 图片类型
//     * @param callback  数据回调
//     */
//    public static void Upload(final Context context,
//                              final File newfile,
//                              final String imageType,
//                              final HttpFileCallBack callback) {
//
//        Runnable mRunnable = new Runnable() {
//            @Override
//            public void run() {
//                RequestParams params = new RequestParams();
//                try {
//                    if (newfile != null) {
//                        params.addBodyParameter("imageFile", newfile);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                String token;
//                String uploadurl;
//                try {
//
//                    token = URLEncoder.encode(SPUtil.instance().getStringKey("Token", ""), "utf-8");
//                    uploadurl = Constants.APi_UPLoad + "token=" + token + "&imageType=" + imageType;
//
//                    LogUtil.w(TAG, uploadurl);
//
//
//                    HttpUtils http = new HttpUtils();
//
//                    http.send(HttpRequest.HttpMethod.POST, uploadurl, params, new RequestCallBack<String>() {
//                        @Override
//                        public void onLoading(long total, long current, boolean isUploading) {
//                            callback.onLoading(total, current, isUploading);
//                        }
//
//                        @Override
//                        public void onStart() {
//                            callback.onStart();
//                        }
//
//                        @Override
//                        public void onFailure(HttpException error, String msg) {
//                            LogUtil.v(StringEscapeUtils.unescapeJava(msg));
//                            callback.onFiled(msg);
//                        }
//
//                        @Override
//                        public void onSuccess(ResponseInfo<String> responseInfo) {
//                            if (responseInfo != null) {
//                                LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
//                                callback.onSuccess(responseInfo.result);
//                            }
//                        }
//                    });
//
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        };
//        executorService.execute(mRunnable);
//    }
//
//
//    /**
//     * 上传多图 图片(暂时 后台接口不支持)
//     *
//     * @param context     上下文
//     * @param picPathList 图片地址 集合
//     * @param imageType   图片类型
//     * @param callback    数据回调
//     */
//    public static void UploadMore(Context context,
//                                  List<String> picPathList,
//                                  String imageType,
//                                  final HttpFileCallBack callback) {
//
//        RequestParams params = new RequestParams();
//
//        try {
//            for (int i = 0; i < picPathList.size(); i++) {
//                params.addBodyParameter("imageFile",
//                        customCompressImage(context, new File(picPathList.get(i))));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String token;
//        String uploadurl;
//        try {
//            token = URLEncoder.encode(SPUtil.instance().getStringKey("Token", ""), "utf-8");
//            uploadurl = Constants.APi_UPLoad + "token=" + token + "&imageType=" + imageType;
//
//            LogUtil.w(TAG, uploadurl);
//
//
//            HttpUtils http = new HttpUtils();
//
//            http.send(HttpRequest.HttpMethod.POST, uploadurl, params, new RequestCallBack<String>() {
//                @Override
//                public void onLoading(long total, long current, boolean isUploading) {
//                    callback.onLoading(total, current, isUploading);
//                }
//
//                @Override
//                public void onStart() {
//                    callback.onStart();
//                }
//
//                @Override
//                public void onFailure(HttpException error, String msg) {
//                    LogUtil.v(StringEscapeUtils.unescapeJava(msg));
//                    callback.onFiled(msg);
//                }
//
//                @Override
//                public void onSuccess(ResponseInfo<String> responseInfo) {
//                    if (responseInfo != null) {
//                        LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
//                        callback.onSuccess(responseInfo.result);
//                    }
//                }
//            });
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 图片 压缩
     *
     * @param context     上下文
     * @param actualImage 图片文件
     * @return 压缩后的图片文件
     */
    public static File customCompressImage(Context context, File actualImage) {
//        File compressedImage = null;
//        compressedImage = CompressHelper.getDefault(context).compressToFile(actualImage);
        if (!actualImage.exists()) {
            return null;
        }
        File compressedImage = null;
        try {
            compressedImage = new Compressor(context).compressToFile(actualImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressedImage;
    }
}
