package com.example.yc.mvpdemo.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.utils.LogUtil;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by YuChao
 * 异常处理类
 */
public class SPathException implements UncaughtExceptionHandler {

    private static final String serialVersionUID = "1L";
    private int httpCode;
    private String redierectUrl;
    private Context context;
    private Map<String, String> infos = new HashMap<String, String>();
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
    private static SPathException sPathException = new SPathException();
    //错误日志存放目录
    public final static String APP_ERRDIR = "/YunChe/Log/";

    /**
     * 系统默认的UncaughtException处理类
     */
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public SPathException(int httpCode, String redierectUrl) {
        super();
        this.httpCode = httpCode;
        this.redierectUrl = redierectUrl;
    }

    private SPathException() {
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        this.context = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static SPathException getInstance() {
        return sPathException;
    }

    @Override
    public String toString() {

        return "SPathException [httpCode=" + httpCode + ", redierectUrl="
                + redierectUrl + "]";
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        }

    }

    /**
     * 自定义异常处理:收集错误信息&发送错误报告
     *
     * @param ex
     * @return true:处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }

        StringWriter stackTrace = new StringWriter();
        ex.printStackTrace(new PrintWriter(stackTrace));
        final String crashReport = stackTrace.toString();
        // final String crashReport = getCrashReport(context, ex);
        LogUtil.e("----------------------------");
        LogUtil.e("——handleException = 异常信息" + crashReport + " " + getClass().getName());
        collectDeviceInfo(true);
        String fileName = saveErrorInfotoFile(ex);
        // 发送异常信息
//		sendAppCrashReport(context, fileName);
//		PushService.actionStop(context.getApplicationContext());
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        return true;
    }

    public void handleErrorMessage(Throwable ex) {
//		collectDeviceInfo(false);
//		sendAppCrashReport(context, saveErrorInfotoFile(ex));
    }

    /**
     * 发送App异常崩溃报告
     *
     * @param context
     * @param fileName
     */
//	public void sendAppCrashReport(Context context, String fileName) {
//		File file = new File(
//				Environment.getExternalStorageDirectory() + SPreferBase.BENGUO_ERRDIR, fileName);
//		if (file.exists()) {
//			BenguoBasic.getInstance().uploadFile(this,
//					TaskID.ACTION_UPLOAD_ERRLOG, file);
//		}
//	}

    /**
     * 收集设备信息
     */
    private void collectDeviceInfo(boolean iscrashed) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                infos.put("应用名称", context.getString(R.string.app_name));
                infos.put("应用包名", context.getPackageName());
                infos.put("应用版本", pi.versionName == null ? "null" : pi.versionName);
                infos.put("应用版本号", "" + pi.versionCode);
            }
            if (iscrashed) {
                infos.put("exctype", "  has crashed!");
            }
            infos.put("sdk_int", "" + Build.VERSION.SDK_INT);
            infos.put("android版本", "" + Build.VERSION.RELEASE);
            infos.put("手机品牌", "" + Build.MANUFACTURER);
            infos.put("手机型号", "" + Build.MODEL);
        } catch (NameNotFoundException e) {
            LogUtil.e(
                    "——collectDeviceInfo = an error occured when collect packinfo"
                            + " " + getClass().getName(), e);
        }
    }

    /**
     * 保存错误日志到文件
     */
    private String saveErrorInfotoFile(Throwable ex) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + "=" + value + "\n");
        }
        sb.append("..." + "\n");
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        try {
            String time = formatter.format(new Date());
            String fileName = "err_" + time + ".txt";
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                String path = Environment.getExternalStorageDirectory()
                        + APP_ERRDIR;
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                } else {
                    File[] files = dir.listFiles();
                    for (File f : files) {
                        f.delete();
                    }
                }
                FileOutputStream fos = new FileOutputStream(path + fileName);
                fos.write(sb.toString().getBytes());
                fos.flush();
                fos.close();
            }
            return fileName;
        } catch (Exception e) {
            LogUtil.e(
                    "——saveErrorInfotoFile = an error occured while writing file..."
                            + " " + getClass().getName(), e);
        }
        return null;
    }

}
