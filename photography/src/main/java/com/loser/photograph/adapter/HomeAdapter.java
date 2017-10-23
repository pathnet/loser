package com.loser.photograph.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by sunbo on 2017/10/18.
 */

public class HomeAdapter extends PagerAdapter {
    public HomeAdapter(FragmentManager supportFragmentManager) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
