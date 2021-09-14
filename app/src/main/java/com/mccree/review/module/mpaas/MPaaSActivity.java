package com.mccree.review.module.mpaas;

import android.os.Bundle;

import com.mccree.review.R;
import com.mccree.review.base.MyBaseActivity;
import com.mccree.review.utils.LLog;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.CdpAdvertisementView;
import com.mpaas.cdp.structure.SpaceInfo;

public class MPaaSActivity extends MyBaseActivity {

    private CdpAdvertisementView mCdpAdvertisementView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpaas_activity);

        mCdpAdvertisementView = (CdpAdvertisementView) findViewById(R.id.cdp_content);


        CdpManager.getInstance().getSpaceInfoByCode("banner_test", new CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack() {
            @Override
            public void onSuccess(SpaceInfo spaceInfo) {
                LLog.i("onSuccess() " + spaceInfo.toString());
                if (spaceInfo.spaceObjectList != null) {
                    mCdpAdvertisementView.updateSpaceCode("banner_test");
                }
            }

            @Override
            public void onFail() {
                LLog.e("onFail() ");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        mCdpAdvertisementView.updateSpaceCode("banner_test");
    }
}