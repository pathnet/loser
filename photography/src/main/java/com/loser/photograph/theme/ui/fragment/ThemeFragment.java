package com.loser.photograph.theme.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.loser.R;
import com.loser.photograph.base.BaseFragment;
import com.loser.photograph.base.BasePresenter;

import butterknife.BindView;

public class ThemeFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView mTvName;

    public static ThemeFragment instance() {
        return new ThemeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mTvName.setText(getClass().getSimpleName());
    }

    @Override
    public void processClick(View v) {

    }

    @NonNull
    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}