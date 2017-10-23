package com.loser.photograph.api;

import com.loser.photograph.home.model.RepoMain;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:ApiUtils.java
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/22  18:10
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public class ApiUtils extends ApiBase {

    public static Observable<RepoMain> searchHistory(String month, String day) {
        /**key=7ac7e02ff7f1f8f1ccdc2f9e5dddb6be&v=1.0&month=11&day=1*/
        Map<String, String> map = new HashMap<>();
        map.put("key", "7ac7e02ff7f1f8f1ccdc2f9e5dddb6be");
        map.put("v", "1.0");
        map.put("month", month);
        map.put("day", day);
        return getService().searchHistory(map);
    }
}
