package com.xfragwork.xfragwork.network.manager;


import com.xfragwork.xfragwork.base.application.BaseApplication;
import com.xfragwork.xfragwork.base.presenter.BasePresenter;
import com.xfragwork.xfragwork.network.exception.ErrorHandler;
import com.xfragwork.xfragwork.network.exception.ErrorResponseBean;
import com.xfragwork.xfragwork.network.exception.Result;
import com.xfragwork.xfragwork.utils.ToastUtil;

import io.reactivex.observers.DefaultObserver;


/**
 * @version V2.7.0
 * @Project: MyMvp
 * @Filename:com.mvpdemo.application
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/19  13:38
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public abstract class ObserverResponseManager<T> extends DefaultObserver<T> {

    private BasePresenter mIPresenter;

    public ObserverResponseManager(BasePresenter mIPresenter) {
        this.mIPresenter = mIPresenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null != mIPresenter.mView) {
            mIPresenter.mView.showLoading();
        }
    }

    @Override
    public void onComplete() {
        mIPresenter.onDismiss();
    }

    @Override
    public void onError(Throwable e) {
        mIPresenter.onDismiss();
        mIPresenter.showEmpty();
        ErrorResponseBean errorMessage = ErrorHandler.getErrorMessage(e);
        onError(errorMessage);
        onError(errorMessage.getCode(), errorMessage.getErrorMessage());
    }

    @Override
    public void onNext(T responseBody) {
        mIPresenter.onDismiss();
        if (responseBody instanceof Result) {
        }
        onSuccessful(responseBody);
    }

    /**
     * 返回错误码及错误信息【重写此方法,无需再处理错误提示信息】
     *
     * @param errorCode
     * @param errorMsg
     */
    public void onError(int errorCode, String errorMsg) {

    }
    /**
     * 请求成功
     * @param responseBody
     */
    public abstract void onSuccessful(T responseBody);

    /**
     * 统一管理错误提示
     */
    private void onError(ErrorResponseBean ex) {
        ToastUtil.showToast(BaseApplication.getContext(), ex.getCode() + ex.getErrorMessage());
    }
}