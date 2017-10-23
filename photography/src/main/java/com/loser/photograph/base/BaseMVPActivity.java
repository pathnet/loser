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
        setContentView(getLayoutId());
//        SystemBarTintManager tintManager=new SystemBarTintManager(this);
//        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
//        tintManager.setStatusBarTintEnabled(true);
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
