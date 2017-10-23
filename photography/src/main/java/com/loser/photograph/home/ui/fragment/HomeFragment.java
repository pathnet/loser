package com.loser.photograph.home.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.loser.R;
import com.loser.photograph.base.BaseFragment;
import com.loser.photograph.home.presenter.HomeFragmentPresenter;
import com.loser.photograph.home.ui.MainActivity;
import com.loser.photograph.home.view.IHomeFragmentView;

import butterknife.BindView;

/**
 * Created by sunbo on 2017/10/17.
 */

public class HomeFragment extends BaseFragment<IHomeFragmentView, HomeFragmentPresenter> implements IHomeFragmentView {

    @BindView(R.id.tv_name)
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
        ((MainActivity) mContext).mToolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
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


}
