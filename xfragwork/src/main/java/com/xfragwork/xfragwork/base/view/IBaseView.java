package com.xfragwork.xfragwork.base.view;

/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:IBaseView.java
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/22  18:09
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public interface IBaseView {
    /**
     * 显示加载
     */
    void showLoading();
    /**
     * 完成加载
     */
    void dismiss();

    /*显示数据界面*/
    void showEmpty();
}
