package com.loser.photograph.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loser.R;
import com.loser.photograph.interfaces.IUiInterface;


public abstract class BaseFragment<V extends IBaseView, P extends BasePresenter<V>> extends Fragment implements IBaseDelegate<V, P>, IUiInterface, View.OnClickListener {

    public View mView;
    public Context mContext;
    protected P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mView = View.inflate(getActivity(), getLayoutId(), null);
        initView();
        initListener();
        initData();
        regCommonBtn();
        return mView;
    }

    /**
     * 返回viewId引用的view
     */
    protected <T extends View> T $(int viewId) {
        return (T) mView.findViewById(viewId);
    }

    /**
     * 处理所有的返回键
     */
    private void regCommonBtn() {
        View view = $(R.id.back);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onClick(View v) {
        // 把在多个界面间都存在的点击，统一处理掉
        switch (v.getId()) {
            case R.id.back:
                getFragmentManager().popBackStack();
                break;
            default:
                processClick(v);
                break;
        }
    }

    public void showEmpty() {

    }

    public void showLoading() {

    }

    public void dismiss() {

    }
}
