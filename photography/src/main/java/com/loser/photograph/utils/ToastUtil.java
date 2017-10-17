package com.loser.photograph.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtil {


    private static Toast mToast;

    private ToastUtil() {
    }

    /**
     * 显示toast
     *
     * @param text
     */
    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        }
        mToast.setText(text);
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param text
     */
    public static void showToast(String text, Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        }
        mToast.setText(text);
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param text
     */
    public static void showToast(int text, Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        }
        mToast.setText(context.getResources().getString(text));
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param text
     */
    public static void showToast(Context context, int text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        }
        mToast.setText(context.getResources().getString(text));
        mToast.show();
    }
}
