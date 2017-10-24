package com.loser.photograph.home.presenter;

import com.loser.photograph.home.model.MainBean;
import com.loser.photograph.home.model.MainModel;
import com.loser.photograph.home.view.IMainView;
import com.xfragwork.xfragwork.base.presenter.BasePresenter;

/**
 * @version V2.7.0
 * @Project: MyMvp
 * @Filename:com.mvpdemo.presenter
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/21  16:12
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public class MainPresenter extends BasePresenter<IMainView> {

    private MainModel mMainModel;

    public MainPresenter(IMainView mView) {
        super(mView);
        mMainModel = new MainModel(this);
    }

    public void loadData() {
        mMainModel.loadData();
    }

    public void showData(MainBean param) {
        mView.showData(param);
    }
}
