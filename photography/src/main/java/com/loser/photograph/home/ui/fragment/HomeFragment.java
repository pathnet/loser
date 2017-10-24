package com.loser.photograph.home.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.loser.R;
import com.loser.photograph.home.presenter.HomeFragmentPresenter;
import com.loser.photograph.home.view.IHomeFragmentView;
import com.xfragwork.xfragwork.base.fragment.BaseFragment;

/**
 * Created by sunbo on 2017/10/17.
 */

public class HomeFragment extends BaseFragment<IHomeFragmentView, HomeFragmentPresenter> implements IHomeFragmentView {
    TextView mTvName;
    public static HomeFragment instance() {
        return new HomeFragment();
    }

    @NonNull
    @Override
    public HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter(this);
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
        mTvName.setText("HOME");
    }

    @Override
    public void processClick(View v) {

    }

}
