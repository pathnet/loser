package com.xfragwork.xfragwork.network;


import android.content.Context;
import android.os.Build;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.xfragwork.xfragwork.base.application.BaseApplication;
import com.xfragwork.xfragwork.interfaces.IConstants;

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
public abstract class BaseNetwork<T> {
    /**
     * service实例
     */
    private static IBaseService mBaseService;

    /**
     * 初始化service
     */
    public BaseNetwork(String baseUrl, Class<IBaseService> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//用于返回Rxjava调用,非必须
                .build();
        mBaseService = retrofit.create(service);
    }

    /**
     * 返回service
     *
     * @return
     */
    public static IBaseService getService() {
        return mBaseService;
    }

    /**
     * 头信息设置
     *
     * @return
     */
    public OkHttpClient getClient() {
        final SetCookieCache mCookies = new SetCookieCache();
        ClearableCookieJar mCookieJar = new PersistentCookieJar(mCookies, new SharedPrefsCookiePersistor(BaseApplication.getContext()));
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(IConstants.TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(IConstants.TIME_OUT, TimeUnit.MILLISECONDS)
                .cookieJar(mCookieJar)
                .addInterceptor((chain) -> chain.proceed(chain.request().newBuilder()
                        .addHeader(IConstants.CLIENT_INFO, getClientInfoValue()).build())).build();
        return httpClient;
    }

    /**
     * 头信息
     *
     * @return
     */
    public String getClientInfoValue() {
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
