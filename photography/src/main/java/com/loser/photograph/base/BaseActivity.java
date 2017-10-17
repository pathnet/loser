package com.loser.photograph.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loser.R;
import com.loser.photograph.dialog.IDialogControl;
import com.loser.photograph.utils.DialogUtils;


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

public abstract class BaseActivity extends AppCompatActivity implements IDialogControl {
    private ProgressDialog mWaitDialog;

    protected void startActivity(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
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
