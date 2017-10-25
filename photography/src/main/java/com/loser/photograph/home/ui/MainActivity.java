package com.loser.photograph.home.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.loser.R;
import com.loser.photograph.home.model.MainBean;
import com.loser.photograph.home.presenter.MainPresenter;
import com.loser.photograph.home.view.IMainView;
import com.wakehao.bar.BottomNavigationBar;
import com.wakehao.bar.BottomNavigationItemWithDot;
import com.xfragwork.xfragwork.base.activity.BaseMVPActivity;

public class MainActivity extends BaseMVPActivity<IMainView, MainPresenter> implements IMainView {
    public Toolbar mToolbar;
    private BottomNavigationBar mBnBar;

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBnBar = $(R.id.bar);
        mToolbar = $(R.id.toolbar);
        mBnBar = findViewById(R.id.bar);
    }

    @Override
    public void initData() {
        mToolbar.setVisibility(View.GONE);
        getPresenter().loadData();
        mBnBar.showNum(0, 80);
        mBnBar.showNum(1, 100);
        mBnBar.showNum(2, -2);
        mBnBar.disMissNum(3);
    }

    @Override
    public void processClick(View v) {

    }
    @Override
    public void initListener() {
        mBnBar.setOnNavigationItemSelectedListener(new BottomNavigationBar.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull BottomNavigationItemWithDot item, int selectedPosition) {
                switch (selectedPosition) {
                    case 0:
                        mToolbar.setVisibility(View.GONE);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        mToolbar.setVisibility(View.VISIBLE);
                        break;
                }
                if (selectedPosition == 2) {
                    //mBnBar.setItemSelected(2, false);
                    new MaterialDialog.Builder(mContext)
                            .title("提示")
                            .content("这是一条内容")
                            .positiveText("按钮1")
                            .negativeText("按钮2")
                            .show();
                    //返回false表示不响应点击事件
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public void onNavigationItemSelectedAgain(@NonNull BottomNavigationItemWithDot item, int reSelectedPosition) {
                //连续点击了同一个reSelectedPosition位置的item
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK || requestCode != 1) return;
        //不带动画的切换item
//        mBnBar.setItemSelected(3, false);
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 返回BottomNavigationBar 对象
     *
     * @return
     */
    public BottomNavigationBar getBnBar() {
        return mBnBar;
    }


    @Override
    public void showData(MainBean param) {

    }
}
