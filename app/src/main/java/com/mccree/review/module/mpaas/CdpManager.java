package com.mccree.review.module.mpaas;

import android.app.Activity;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.mccree.review.utils.LLog;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.structure.SpaceInfo;

import java.util.HashMap;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/10 14:43
 * Description:MPaaS智能投放管理
 */
public class CdpManager {

    private static CdpManager manager;

    private CdpAdvertisementService mService;

    private CdpManager() {
    }

    public static CdpManager getInstance() {
        if (manager == null) {
            synchronized (CdpManager.class) {
                if (manager == null) {
                    manager = new CdpManager();
                }
            }
        }
        return manager;
    }

    /**
     * 获取Serview
     *
     * @return
     */
    public CdpAdvertisementService getService() {
        return LauncherApplicationAgent.getInstance().getMicroApplicationContext().findServiceByInterface(CdpAdvertisementService.class.getName());
    }

    /**
     * 检查是否有广告配置
     *
     * @return
     */
    public boolean checkIfSplashPrepared() {

        if (mService == null) {
            mService = getService();
        }
        if (mService != null) {
            LLog.e("return mService.checkIfSplashPrepared()");
            return mService.checkIfSplashPrepared();
        }
        LLog.e("return false");
        return false;
    }

    /**
     * 展示开屏广告
     *
     * @param activity
     */
    public void showCdpSplash(Activity activity) {
        if (mService == null) {
            mService = getService();
        }
        mService.doSplash(activity, new HashMap<String, String>(), new CdpAdvertisementService.IAdEventHandler() {
            @Override
            public void onClosed(SpaceInfo spaceInfo) {
            }

            @Override
            public void onJump(SpaceInfo spaceInfo) {
                // 跳转到活动目标页面
                LLog.d("onJump() " + spaceInfo.toString());
            }
        });

    }

    /**
     * 刷新所有广告
     */
    public void refreshAllCdp() {
        if (null == mService) {
            getService();
        }
        if (null != mService) {
            mService.refresh(new CdpAdvertisementService.IRefreshZoneCallBack() {
                @Override
                public void onStart() {

                }

                @Override
                public void onEnd() {

                }
            });
        }
    }

    /**
     * 通过广告ID  获取对应广告相关数据
     *
     * @param codeId   广告ID
     * @param callback
     */
    public void getSpaceInfoByCode(String codeId, CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack callback) {
        if (getService() == null) {
            mService = getService();
        }
        if (mService != null) {
            mService.getSpaceInfoByCode(codeId, callback);
        }
    }

}


