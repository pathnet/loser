package com.loser.photograph.my.ui.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.loser.R;
import com.loser.photograph.base.BaseFragment;
import com.loser.photograph.base.BasePresenter;

import butterknife.BindView;

/**
 * Created by sunbo on 2017/10/17.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView mTvName;

    public static MyFragment instance() {
        return new MyFragment();
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
