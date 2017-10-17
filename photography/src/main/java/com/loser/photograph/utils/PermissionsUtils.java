package com.loser.photograph.utils;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import com.loser.R;
import com.loser.photograph.base.BaseActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * @version V2.7.0
 * @Project: CMN-Android
 * @Filename:com.asc.cmn.utils
 * @Desciption:
 * @Author: sunbo
 * @Date: 2017/8/15  15:18
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */

public class PermissionsUtils {
    public static void callPhone(BaseActivity activity, String phoneNumber) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.request(Manifest.permission.CALL_PHONE)
                .subscribe(granted -> {
                    if (granted) {
                        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);
                    } else {
                        //没有权限
                        ToastUtil.showToast(activity, activity.getString(R.string.call_phone));
                    }
                });
    }
}
