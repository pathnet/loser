package com.loser.photograph.network;

import com.loser.photograph.constants.IConstants;
import com.loser.photograph.home.model.MainBean;
import com.loser.photograph.home.model.RepoMain;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by sunbo on 2017/10/24.net
 */

public interface INetService {

    /**
     * 查询历史的今天
     */
    @Headers(IConstants.HEADER_CONTENT_TYPE + IConstants.HEADER_CONTENT_VALUE)
    @GET("/japi/toh")
    Observable<RepoMain> searchHistory(@QueryMap Map<String, String> map);

    /**
     * 查询历史的今天
     */
    @POST("/login")
    @FormUrlEncoded
    Observable<MainBean> test(@Field("userName") String userName, @Field("password") String pwd);

    /**
     * 通用参数传递
     */
    @POST("/japi/toh")
    Observable<MainBean> post(@QueryMap Map<String, String> map);
}
