package com.mccree.review;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.mccree.review.utils.LLog;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by: lixingzhou
 * Created Date: 2021/6/23 10:52
 * Description:
 */
@SuppressLint("StaticFieldLeak")
public class MyApplication extends Application {
    private static MyApplication sApp;
    private static Context sContext;

    private String mAccountId = "12345678";

    private final static int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private final static int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        sContext = getApplicationContext();
        ExecutorService service = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        service.submit(new Runnable() {
            @Override
            public void run() {
                //腾讯X5初始化
                initX5();
            }
        });

    }

    /**
     * 腾讯X5-webView初始化
     */
    public void initX5() {
        // 在调用TBS初始化、创建WebView之前进行如下配置
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
        //非wifi情况下，主动下载x5内核
        QbSdk.setDownloadWithoutWifi(true);
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LLog.d("开启TBS===X5加速成功");
            }

            @Override
            public void onCoreInitFinished() {
                LLog.d("开启TBS===X5加速失败");
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static MyApplication getInstance() {
        return sApp;
    }

    public static Context getContext() {
        return sContext;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public void setAccountId(String mAccountId) {
        this.mAccountId = mAccountId;
    }
}
