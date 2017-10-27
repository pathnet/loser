package com.loser.photograph.network;

import com.loser.photograph.constants.IUrl;
import com.xfragwork.xfragwork.network.BaseNetwork;

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
    private static NetUtils mNetUtils;

    private NetUtils(String baseUrl, Class<INetService> iNetServiceClass) {
        super(baseUrl, iNetServiceClass);
    }

    public static NetUtils getInstance() {
        if (mNetUtils == null) {
            synchronized (NetUtils.class) {
                if (mNetUtils == null) {
                    mNetUtils = new NetUtils(IUrl.BASE_URL, INetService.class);
                }
            }
        }
        return mNetUtils;
    }

    @Override
    public INetService getService() {
        return (INetService) super.getService();
    }
}
