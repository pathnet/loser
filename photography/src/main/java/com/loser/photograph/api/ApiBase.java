package com.loser.photograph.api;


import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;

import com.loser.photograph.application.BaseApplication;
import com.loser.photograph.constants.IConstants;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:ApiBase.java
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/22  18:10
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public class ApiBase {

    /**历史上的今天 http://api.juheapi.com/japi/toh?key=7ac7e02ff7f1f8f1ccdc2f9e5dddb6be&v=1
     * .0&month=11&day=1*/
    /**
     * 笑话大全 http://japi.juhe.cn/joke/content/list
     * .from?key=d796a03545bddee0b56d913111f5f199&page=2&pagesize=10&sort=asc&time=1418745237
     */
    protected static IApiService getService() {
        return getService(null);
    }

    protected static IApiService getService(String ip) {
        return getService(ip, 0, 0);
    }

    protected static IApiService getService(String ip, long readTime, long connectTime) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.netease.im/api/")
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//用于返回Rxjava调用,非必须
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IApiService.class);
    }

    public static OkHttpClient getClient() {
        Context mContext = BaseApplication.getContext();
//        final SetCookieCache mCookies = new SetCookieCache();
//        ClearableCookieJar mCookieJar = new PersistentCookieJar(mCookies, new SharedPrefsCookiePersistor(mContext.getApplicationContext()));
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(IConstants.TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(IConstants.TIME_OUT, TimeUnit.MILLISECONDS)
//                .cookieJar(mCookieJar)
                .addInterceptor((chain) -> chain.proceed(chain.request().newBuilder()
                        .addHeader(IConstants.CLIENT_INFO, getClientInfoValue()).build())).build();

        return httpClient;
    }

    /**
     * 头信息
     *
     * @return
     */
    @NonNull
    public static String getClientInfoValue() {
        try {
            Context mContext = BaseApplication.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(IConstants.API_VERSION);
            sb.append(mContext.getPackageManager().getPackageInfo(mContext.getApplicationInfo().processName, 0).versionName);
            sb.append(IConstants.APP_VERSION_CODE);
            sb.append(mContext.getPackageManager().getPackageInfo(mContext.getApplicationInfo().processName, 0).versionCode);
            sb.append(IConstants.OS);
            sb.append(Build.VERSION.RELEASE + IConstants.MOBILE_DEVICE_INFO + URLEncoder.encode(Build.MODEL, IConstants.UTF_8));
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
