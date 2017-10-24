package com.loser.photograph.home.view;


import com.loser.photograph.home.model.MainBean;
import com.xfragwork.xfragwork.base.view.IBaseView;

/**
 * @version V2.7.0
 * @Project: MyMvp
 * @Filename:com.mvpdemo.home.view
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/21  16:11
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public interface IMainView extends IBaseView {
    void showData(MainBean param);
}
