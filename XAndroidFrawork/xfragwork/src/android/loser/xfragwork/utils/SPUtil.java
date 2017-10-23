package android.loser.xfragwork.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    public final static String SP_NAME = "BusinessControl";
    private static SharedPreferences mSp;
    private SharedPreferences.Editor editor;

    public static void setBoolean(Context context, String key, boolean value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        mSp.edit().putBoolean(key, value).commit();
    }

    public static void setInt(Context context, String key, int value) {

        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        mSp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getInt(key, defValue);

    }

    public static int getInt(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getInt(key, -1);

    }

    public static long getLong(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getLong(key, -1);

    }

    public static void setLong(Context context, String key, long value) {

        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        mSp.edit().putLong(key, value).commit();
    }

    public static void setString(Context context, String key, String value) {

        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        mSp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getString(key, defValue);
    }


    public static String getString(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getString(key, "");
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getBoolean(key, defValue);
    }

    public static boolean getBoolean(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        return mSp.getBoolean(key, false);
    }
}
