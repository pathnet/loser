package com.loser.photograph.base;

import android.content.Context;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseMVPActivity<V extends IBaseView, P extends BasePresenter<V>> extends BaseActivity implements IBaseDelegate<V, P> {

    public Context mContext;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mContext = this;
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        setListener();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    /**
     * 设置布局Id
     *
     * @return
     */
    protected abstract int setLayoutId();

    /**
     * 监听方法
     */
    protected abstract void setListener();

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
