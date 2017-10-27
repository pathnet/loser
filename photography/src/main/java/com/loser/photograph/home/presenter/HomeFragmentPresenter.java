package com.loser.photograph.home.presenter;

import com.loser.photograph.home.model.HomeFragmentModel;
import com.loser.photograph.home.view.IHomeFragmentView;
import com.xfragwork.xfragwork.base.presenter.BasePresenter;

/**
 * Created by sunbo on 2017/10/20.
 */

public class HomeFragmentPresenter extends BasePresenter<IHomeFragmentView> {
    private HomeFragmentModel mMainModel;

    public HomeFragmentPresenter(IHomeFragmentView homeFragment) {
        super(homeFragment);
        mMainModel = new HomeFragmentModel(this);
    }

    public void loadData() {
        mMainModel.loadData();
    }
}
