package com.loser.photograph.community.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.loser.R;
import com.loser.photograph.home.presenter.HomeFragmentPresenter;
import com.loser.photograph.home.view.IHomeFragmentView;
import com.xfragwork.xfragwork.base.fragment.BaseMVPFragment;

public class CommunityFragment extends BaseMVPFragment<IHomeFragmentView, HomeFragmentPresenter> implements IHomeFragmentView {
    TextView mTvName;
    public static CommunityFragment instance() {
        return new CommunityFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        mTvName = $(R.id.tv_name);
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
    public HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter(this);
    }
}