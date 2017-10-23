package android.loser.xfragwork.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by root on 16-6-24.
 */
public class UiUtils {
    /**
     * @param value
     * @return
     */
    public static void setText(TextView textView, String value) {
        textView.setText(getText(value));
    }

    /**
     * @param value
     * @return
     */
    public static void setText(Button textView, String value) {
        textView.setText(getText(value));
    }

    /**
     * @param value
     * @return
     */
    public static void setText(CheckBox textView, String value) {
        textView.setText(getText(value));
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(String value) {
        if (value != null) {
            return TextUtils.isEmpty(value) ? "" : value.trim();
        } else {
            return "";
        }
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(CharSequence value) {
        return TextUtils.isEmpty(value) ? "" : value.toString().trim();
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(int value) {
        return String.valueOf(value);
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(long value) {
        return String.valueOf(value);
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(double value) {
        return String.valueOf(value);
    }

    /**
     * 去除null
     *
     * @param value
     * @return
     */
    public static String getText(float value) {
        return String.valueOf(value);
    }

    /**
     * 获取EditText的值
     *
     * @param editText
     * @return
     */
    public static String getText(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim()) ? "" : editText.getText().toString().trim();
    }

    /**
     * 获取textView的值
     *
     * @param editText
     * @return
     */
    public static String getText(TextView editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim()) ? "" : editText.getText().toString().trim();
    }

    /**
     * 获取Button的值
     *
     * @param editText
     * @return
     */
    public static String getText(Button editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim()) ? "" : editText.getText().toString().trim();
    }

    /**
     * 计算出该TextView中文字的长度(像素)
     *
     * @param textView
     * @param text
     * @return
     */
    public static float getTextViewLength(TextView textView, String text) {
        TextPaint paint = textView.getPaint();
        // 得到使用该paint写上text的时候,像素为多少
        float textLength = paint.measureText(text);
        return textLength;
    }

    /**
     * 设置textview 的值
     *
     * @param mTvActivityName
     * @param activityName
     */
    public static void setTextView(TextView mTvActivityName, String activityName) {
        if (mTvActivityName != null) {
            mTvActivityName.setText(getText(activityName));
        }
    }

    /**
     * 设置textView 的值
     *
     * @param textView 控件
     * @param value    值
     */
    public static void setTextViewValue(TextView textView, String value) {
        textView.setText(getText(value));
    }

    /**
     * 设置textView 的值
     *
     * @param textView 控件
     * @param value    值
     */
    public static void setTextViewValue(TextView textView, String title, String value) {
        textView.setText(title + getText(value));
    }

    /**
     * 设置Button 的值
     *
     * @param text  控件
     * @param value 值
     */
    public static void setButtonValue(Button text, String value) {
        text.setText(getText(value));
    }

    /**
     * 设置Button 的值
     *
     * @param text  控件
     * @param value 值
     */
    public static void setButtonValue(Button text, String title, String value) {
        text.setText(getText(title) + getText(value));
    }

    /**
     * 设置CheckBox 的值
     *
     * @param text  控件
     * @param value 值
     */
    public static void setCheckBoxValue(CheckBox text, String value) {
        text.setText(getText(value));
    }

    /**
     * 设置CheckBox 的值
     *
     * @param text  控件
     * @param value 值
     */
    public static void setCheckBoxValue(CheckBox text, String title, String value) {
        text.setText(getText(title) + getText(value));
    }

    /**
     * 测量文字的宽度
     *
     * @param paint
     * @param str
     * @return
     */
    public static int getTextWidth(Paint paint, String str) {
        int w = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                w += (int) Math.ceil(widths[j]);
            }
        }
        return w;
    }

    /**
     * 设置DrawableTop之类的图片大小
     *
     * @param textView
     * @param redId
     * @param width
     * @param height
     */
    public static void setDrawableLeft(Context context, TextView textView, int redId, int width, int height) {
        Drawable drawable = context.getResources().getDrawable(redId);
        drawable.setBounds(0, 0, height, width);
        textView.setCompoundDrawables(drawable, null, null, null);
    }
}
