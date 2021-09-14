package com.mccree.review.module.mpaas;


import android.os.Bundle;

import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.mccree.review.R;
//import com.mpaas.cdp.CdpAdvertisementService;
//import com.mpaas.cdp.structure.SpaceInfo;


/**
 * Created by: lixingzhou
 * Created Date: 2021/9/10 14:34
 * Description: MPaaS启动页(广告)
 */
public class MPaaSSplashActivity extends BaseFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpaa_ssplash);

//        show();
        CdpManager.getInstance().showCdpSplash(this);
        CdpManager.getInstance().refreshAllCdp();
    }

//    private void show() {
//        final CdpAdvertisementService cdpAdvertisementService = CdpManager.getInstance().getService();
//        cdpAdvertisementService.doSplash(this, new HashMap<>(), new CdpAdvertisementService.IAdEventHandler() {
//            @Override
//            public void onClosed(SpaceInfo spaceInfo) {
//            }
//
//            @Override
//            public void onJump(SpaceInfo spaceInfo) {
//                // 跳转到活动目标页面
//            }
//        });
//    }


}