package com.xfragwork.xfragwork.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseMVCFragment extends BaseFragment {

    public View mView;
    public Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mView = View.inflate(getActivity(), getLayoutId(), null);
        initView();
        initListener();
        initData();
        regCommonBtn();
        return mView;
    }
}
