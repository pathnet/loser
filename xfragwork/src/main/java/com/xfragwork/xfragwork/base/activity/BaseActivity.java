package com.xfragwork.xfragwork.base.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xfragwork.R;
import com.xfragwork.xfragwork.interfaces.IDialogControl;
import com.xfragwork.xfragwork.interfaces.IUiInterface;
import com.xfragwork.xfragwork.utils.DialogUtils;


/**
 * @version V2.7.0
 * @Project: MyMvp
 * @Filename:com.mvpdemo.application
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/9/19  12:33
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, IDialogControl, IUiInterface {
    private ProgressDialog mWaitDialog;

    protected void startActivity(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }

    /**
     * 处理所有的返回键
     */
    public void regCommonBtn() {
        View view = $(R.id.back);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // 把在多个界面间都存在的点击，统一处理掉
        if (v.getId() == R.id.back) {
            getFragmentManager().popBackStack();
        } else {
            processClick(v);
        }
    }
    /**
     * 子类抽取至父类
     */
    public void showEmpty() {
        View view = setEmptyView();
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 返回viewId引用的view
     */
    protected <T extends View> T $(int viewId) {
        return (T) findViewById(viewId);
    }
    /**
     * 子类返回空状态布局
     *
     * @return
     */
    public View setEmptyView() {
        return null;
    }

    /**
     * 子类抽取至父类loading
     */
    public void showLoading() {
        showWaitDialog();
    }

    /**
     * 子类抽取至父类
     */
    public void dismiss() {
        hideWaitDialog();
    }

    @Override
    public ProgressDialog showWaitDialog(int resid) {
        return showWaitDialog(getString(resid));
    }

    /**
     * 显示Progrss
     *
     * @return
     */
    @Override
    public synchronized ProgressDialog showWaitDialog(String msg) {
        if (mWaitDialog == null) {
            mWaitDialog = DialogUtils.getWaitDialog(this, msg);
        } else {
            mWaitDialog.setMessage(msg);
        }
        mWaitDialog.show();
        mWaitDialog.setCanceledOnTouchOutside(false);
        return mWaitDialog;
    }

    @Override
    public ProgressDialog showWaitDialog() {
        return showWaitDialog(getString(R.string.request_data));
    }

    /**
     * 关闭弹窗
     */
    @Override
    public void hideWaitDialog() {
        if (mWaitDialog != null) {
            try {
                mWaitDialog.dismiss();
                mWaitDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
