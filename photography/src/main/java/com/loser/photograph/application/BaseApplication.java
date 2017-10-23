package com.loser.photograph.application;

import android.app.Application;
import android.content.Context;

/**
 * @version V2.7.0
 * @Project: MyMvp
 * @Filename:com.mvpdemo.application
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/19  13:38
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public class BaseApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
