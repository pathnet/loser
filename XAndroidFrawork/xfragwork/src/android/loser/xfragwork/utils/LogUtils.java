package android.loser.xfragwork.utils;

import com.orhanobut.logger.Logger;

public class LogUtils {
    public static final String mTag = "asc_";
    private static final boolean ENABLE = true;

    /**
     * 打印一个debug等级的log
     */
    public static void d(String tag, String msg) {
        if (ENABLE) {
            Logger.d(mTag + tag, msg);
        }
    }

    /**
     * 打印一个debug等级的log
     */
    public static void d(Class cls, String msg) {
        if (ENABLE) {
            Logger.d(mTag + cls.getSimpleName(), msg);
        }
    }

    /**
     * 打印一个 error 等级的log
     */
    public static void e(String tag, String msg) {
        if (ENABLE) {
            Logger.e(tag + msg);
        }
    }

    /**
     * 打印一个 error 等级的log
     */
    public static void e(Class cls, String msg) {
        if (ENABLE) {
            Logger.e(cls.getSimpleName() + msg);
        }
    }

    /**
     * 打印一个 error 等级的log
     */
    public static void e(Exception msg) {
        if (ENABLE) {
            Logger.e(mTag, msg);
        }
    }
}
