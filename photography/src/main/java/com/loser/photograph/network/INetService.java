package com.loser.photograph.network;

import com.loser.photograph.constants.IConstants;
import com.loser.photograph.home.model.RepoMain;
import com.xfragwork.xfragwork.network.IBaseService;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by sunbo on 2017/10/24.net
 */

public interface INetService extends IBaseService {

    /**
     * 查询历史的今天
     */
    @Headers(IConstants.HEADER_CONTENT_TYPE + IConstants.HEADER_CONTENT_VALUE)
    @GET("/japi/toh")
    Observable<RepoMain> searchHistory(@QueryMap Map<String, String> map);
}
