package com.loser.photograph.home.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.loser.R;
import com.loser.photograph.base.BaseMVPActivity;
import com.loser.photograph.home.presenter.MainPresenter;
import com.loser.photograph.home.view.IMainView;
import com.wakehao.bar.BottomNavigationBar;
import com.wakehao.bar.BottomNavigationItemWithDot;

public class MainActivity extends BaseMVPActivity<IMainView, MainPresenter> implements IMainView {
    public Toolbar mToolbar;
    BottomNavigationBar mBnBar;

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
        mToolbar = findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mBnBar = findViewById(R.id.bar);
        mBnBar.showNum(0, 80);
        mBnBar.showNum(1, 100);
        mBnBar.showNum(2, -2);
        mBnBar.disMissNum(3);
    }

    @Override
    public void initListener() {
        mBnBar.setOnNavigationItemSelectedListener(new BottomNavigationBar.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull BottomNavigationItemWithDot item, int selectedPosition) {
                if (selectedPosition == 2) {
                    //用户切换item
//                    mBnBar.setItemSelected(2, false);
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
    public void initData() {
    }

    @Override
    public void processClick(View v) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK || requestCode != 1) return;
        //不带动画的切换item
        mBnBar.setItemSelected(3, false);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public BottomNavigationBar getBar() {
        return mBnBar;
    }

}
