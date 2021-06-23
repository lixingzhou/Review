package com.mccree.review;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.alipay.mobile.framework.quinoxless.IInitCallback;
import com.alipay.mobile.framework.quinoxless.QuinoxlessFramework;
import com.mccree.review.utils.LLog;

/**
 * Created by: lixingzhou
 * Created Date: 2021/6/23 10:52
 * Description:
 */
@SuppressLint("StaticFieldLeak")
public class MyApplication extends Application {
    private static MyApplication sApp;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        sContext = getApplicationContext();

        initMPaaS();
    }

    private void initMPaaS() {
        QuinoxlessFramework.setup(this, new IInitCallback() {
            @Override
            public void onPostInit() {
                LLog.i("mPaaS init ! ");
            }
        });
    }

    public static MyApplication getInstance() {
        return sApp;
    }

    public static Context getContext() {
        return sContext;
    }
}
