package com.loser.photograph.home.model;

import com.loser.photograph.home.presenter.HomeFragmentPresenter;
import com.loser.photograph.network.NetUtils;
import com.xfragwork.xfragwork.base.model.BaseModel;
import com.xfragwork.xfragwork.network.manager.ObserverResponseManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sunbo on 2017/10/27.
 */

public class HomeFragmentModel extends BaseModel<HomeFragmentPresenter> {
    public HomeFragmentModel(HomeFragmentPresenter homeFragmentPresenter) {
        super(homeFragmentPresenter);
    }

    public void loadData() {
        NetUtils.getInstance().getService()
                .test("hpzd", "1234568")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverResponseManager<MainBean>(mIPresenter) {
                    @Override
                    public void onSuccessful(MainBean responseBody) {
                    }
                });

    }
}
