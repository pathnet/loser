package com.xfragwork.xfragwork.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    /**
     * 判断是否有网络(wifi加移动网络)
     *
     * @param context
     * @return
     */
    public static boolean getNetWorkState(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo(); // wifi
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (activeNetInfo != null || mobNetInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否有wifi
     *
     * @param context
     * @return
     */
    public static boolean getNetWork(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (null != info) {
                return true;
            }
        }
        return false;
    }
}
