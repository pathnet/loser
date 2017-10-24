package com.xfragwork.xfragwork.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @version V2.7.0
 * @Project: CMN-Android
 * @Filename:com.asc.ud.utils
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/8/22  9:38
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public class AppInfo {
    public static String getVersionName(Context context) {
        //获取当前版本号
        PackageInfo pi = null;//getPackageName()是你当前类的包名，0代表是获取版本信息
        try {
            pi = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //版本名称
        String name = pi.versionName;
        //版本号
        int code = pi.versionCode;
        return name;
    }

    public static int getVersionCode(Context context) {
        //获取当前版本号
        PackageInfo pi = null;//getPackageName()是你当前类的包名，0代表是获取版本信息
        try {
            pi = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //版本号
        int code = pi.versionCode;
        return code;
    }

}
