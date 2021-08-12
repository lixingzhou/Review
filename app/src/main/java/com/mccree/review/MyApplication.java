package com.mccree.review;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.alipay.mobile.framework.quinoxless.IInitCallback;
import com.alipay.mobile.framework.quinoxless.QuinoxlessFramework;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.mccree.review.utils.LLog;
import com.mpaas.tinyappcommonres.TinyAppCenterPresetProvider;

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
        QuinoxlessFramework.init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initMPaaS();
    }

    private void initMPaaS() {
        QuinoxlessFramework.setup(this, new IInitCallback() {
            @Override
            public void onPostInit() {
                LLog.i("mPaaS init ! ");
                // 初始化小程序公共资源包
                H5Utils.setProvider(H5AppCenterPresetProvider.class.getName(), new TinyAppCenterPresetProvider());
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
