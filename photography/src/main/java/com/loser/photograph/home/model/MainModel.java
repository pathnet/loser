package com.loser.photograph.home.model;

import com.loser.photograph.home.presenter.MainPresenter;
import com.loser.photograph.network.NetUtils;
import com.xfragwork.xfragwork.base.model.BaseModel;

import java.util.HashMap;

/**
 * Created by sunbo on 2017/10/24.
 */

public class MainModel extends BaseModel<MainPresenter> {
    public MainModel(MainPresenter presenter) {
        super(presenter);

    }

    public void loadData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("测试", "测试");
        NetUtils.getService().post(map);
    }
}
