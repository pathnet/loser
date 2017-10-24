package com.xfragwork.xfragwork.base.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Created by leon on 2017/10/19.
 */

public class BaseApplication extends Application {
    private static Activity sTopActivity;
    private static Context sContext;
    private boolean mHasInit;

    /**
     * 全局上下文
     *
     * @return
     */
    public static Context getContext() {
        return sContext;
    }

    public static Activity getTopActivity() {
        if (sTopActivity == null || sTopActivity.isFinishing()) {
            return null;
        }
        return sTopActivity;
    }

    // 与BaseFragmentActivity合用一起维护activity 栈
    public static void setTopActivity(Activity topActivity) {
        sTopActivity = topActivity;
    }

    public final static boolean isTopActivityAvaliable() {
        if (null != sTopActivity && !sTopActivity.isFinishing()) {
            return true;
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        //待添加缓存处理初始化等处理
    }

    public void init() {
        if (mHasInit)
            return;
        mHasInit = true;
        initApp();
    }

    public void initApp() {
    }

    //应用退出的操作
    public void exitApp() {
        mHasInit = false;
        sTopActivity = null;
        new Thread(() -> exitAppInThread()).start();
    }

    //耗时操作可以在这里面解决
    protected void exitAppInThread() {
    }
}
