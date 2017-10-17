package com.loser.photograph.base;

/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:BasePresenter.java
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/22  18:09
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public abstract class BasePresenter<V extends IBaseView> {
    public V mView;

    public BasePresenter(V mView) {
        attachView(mView);
    }

    /**
     * 绑定接口
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 释放接口
     */
    public void detachView() {
        this.mView = null;
    }

    /*关闭进度条*/
    public void onDismiss() {
        mView.dismiss();
    }

    /*显示空布局*/
    public void showEmpty() {
        mView.showEmpty();
    }

}
