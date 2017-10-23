package com.loser.photograph.api.exception;


import com.loser.photograph.application.BaseApplication;
import com.loser.photograph.base.BasePresenter;
import com.loser.photograph.utils.ToastUtil;

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
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, 123));
        }
    }

    @Override
    public void onNext(T responseBody) {
        mIPresenter.onDismiss();
        if (responseBody instanceof Result) {
        }
        onSuccessful(responseBody);
    }

    /**
     * 请求成功
     *
     * @param responseBody
     */
    public abstract void onSuccessful(T responseBody);

    /**
     * 错误回调
     */
    private void onError(ApiException ex) {
        ToastUtil.showToast(BaseApplication.getContext(), ex.getDisplayMessage());
    }
}