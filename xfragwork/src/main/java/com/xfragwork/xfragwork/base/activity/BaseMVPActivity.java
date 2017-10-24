package com.xfragwork.xfragwork.base.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.xfragwork.xfragwork.base.presenter.BasePresenter;
import com.xfragwork.xfragwork.base.view.IBaseDelegate;
import com.xfragwork.xfragwork.base.view.IBaseView;

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
        setStatusBar();
        initView();
        initListener();
        ButterKnife.bind(this);
    }

    public void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
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
