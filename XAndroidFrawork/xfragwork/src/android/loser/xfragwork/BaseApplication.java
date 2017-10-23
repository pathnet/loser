package android.loser.xfragwork;

import android.app.Activity;
import android.app.Application;

/**
 * Created by leon on 2017/10/19.
 */

public abstract class BaseApplication extends Application {
    private static Activity mTopActivity;
    private boolean hasInit;


    public void onCreate() {
        super.onCreate();
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        //待添加缓存处理初始化等处理
    }

    public void init(){
        if(hasInit)
            return;
        hasInit = true;
        initApp();
    }

    public abstract void initApp();
    // 与BaseFragmentActivity合用一起维护activity 栈
    public static void setTopActivity(Activity topActivity) {
        mTopActivity = topActivity;
    }

    public static Activity getTopActivity() {
        if(mTopActivity == null || mTopActivity.isFinishing()) {
            return null;
        }
        return mTopActivity;
    }

    public final static boolean isTopActivityAvaliable()
    {
        if (null != mTopActivity && !mTopActivity.isFinishing())
        {
            return true;
        }

        return false;
    }
     //应用退出的操作
    public void exitApp(){
        hasInit = false;
        mTopActivity = null;
        new Thread(new Runnable() {
            @Override
            public void run() {
                exitAppInThread();
            }
        }).start();
    }
    //耗时操作可以在这里面解决
    protected abstract void exitAppInThread();
}
