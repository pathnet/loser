package com.loser.photograph.api;


import com.loser.photograph.home.model.RepoMain;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


public interface IApiService {

    /**
     * 查询历史的今天
     */
    @GET("/japi/toh")
    Observable<RepoMain> searchHistory(@QueryMap Map<String, String> map);

    /**
     * 加载笑话列表
     */
    @GET("/joke/content/list.from")
    Observable<RepoMain> loadJoke(@QueryMap Map<String, String> map);

    @POST("/joke/content/list.from")
    Observable<RepoMain> login(@QueryMap Map<String, String> map);

}
