package com.xfragwork.xfragwork.network;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by sunbo on 2017/10/24.
 */

public interface IBaseService {
    @GET("/japi/toh")
    Observable<ResponseBody> post(@QueryMap Map<String, String> map);
}
