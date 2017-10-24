package com.loser.photograph.network;

import com.loser.photograph.constants.IUrl;
import com.xfragwork.xfragwork.network.BaseNetwork;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:ApiUtils.java
 * @Desciption: 构造设置url及指定service, getClient设置请求头信息, getClientInfoValue 头信息内容(父类中)
 * @Author: sunbo
 * @Date: 2017/9/22  18:10
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public class NetUtils extends BaseNetwork {
    /**
     * 设置url及指定service
     */
    private NetUtils() {
        super(IUrl.BASE_URL, INetService.class);
    }

    /**
     * 方法例子
     *
     * @param month
     * @param day
     * @return
     */
    public static Observable<ResponseBody> test(String month, String day) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "7ac7e02ff7f1f8f1ccdc2f9e5dddb6be");
        map.put("v", "1.0");
        map.put("month", month);
        map.put("day", day);
        return getService().post(map);
    }

}
