package com.xfragwork.xfragwork.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.xfragwork.xfragwork.base.application.BaseApplication;

/**
 * Created by leon on 2017/10/19.
 */

public class BaseFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).init();
        BaseApplication.setTopActivity(this);
    }
}
