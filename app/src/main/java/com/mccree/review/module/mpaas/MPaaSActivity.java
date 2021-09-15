package com.mccree.review.module.mpaas;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mccree.review.R;
import com.mccree.review.base.MyBaseActivity;
import com.mccree.review.module.mpaas.cdp.CdpTestEntity;
import com.mccree.review.utils.LLog;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.CdpAdvertisementView;
import com.mpaas.cdp.structure.SpaceInfo;

import java.util.ArrayList;
import java.util.List;

public class MPaaSActivity extends MyBaseActivity {

    private LinearLayout mLayoutRoot;
    private CdpAdvertisementView mCdpAdvertisementView;

    private RecyclerView mRecyclerView;
    private CdpAdapter mAdapter;
    private List<CdpTestEntity> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpaas_activity);

        mLayoutRoot = (LinearLayout) findViewById(R.id.layout_root);
        mCdpAdvertisementView = (CdpAdvertisementView) findViewById(R.id.cdp_content);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mDataList = new ArrayList<>();
        mDataList.add(new CdpTestEntity(1, "广告1", true, "Banner_list_01"));
        mDataList.add(new CdpTestEntity(2, "内容", false));
        mDataList.add(new CdpTestEntity(3, "广告2", true, "Banner_list_02"));

        mAdapter = new CdpAdapter(R.layout.layout_cdp_item, mDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MPaaSActivity.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                CdpTestEntity entity = mDataList.get(position);
                if (entity.isCdp()) {
                    return;
                }
                Toast.makeText(MPaaSActivity.this, entity.getContent(), Toast.LENGTH_SHORT).show();
            }
        });

        initBannerCdp();

        //弹屏广告
        CdpManager.getInstance().getSpaceInfoByCode("cdp_dialog_03", new CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack() {
            @Override
            public void onSuccess(SpaceInfo spaceInfo) {
                LLog.d("testInfo", "弹屏广告：" + spaceInfo.toString());
//                if (spaceInfo.spaceObjectList != null && spaceInfo.spaceObjectList.size() > 0) {
//
//                    CdpAdvertisementView view = new CdpAdvertisementView(MPaaSActivity.this);
//                    mLayoutRoot.addView(view);
//                    view.updateSpaceCode("cdp_dialog_01");
//
//                }
            }

            @Override
            public void onFail() {
                LLog.d("testInfo", "弹屏广告：onFail()");
            }
        });

    }

    private void initBannerCdp() {
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
                mCdpAdvertisementView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Adapter
     */
    private class CdpAdapter extends BaseQuickAdapter<CdpTestEntity, BaseViewHolder> {

        public CdpAdapter(int layoutResId, @Nullable List<CdpTestEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder baseViewHolder, CdpTestEntity cdpTestEntity) {
            RelativeLayout mLayoutRoot = baseViewHolder.getView(R.id.layout_cdp_root);
            if (cdpTestEntity.isCdp()) {
                CdpAdvertisementView cdpView = new CdpAdvertisementView(MPaaSActivity.this);
                cdpView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                mLayoutRoot.addView(cdpView);
//                cdpView.updateSpaceCode(cdpTestEntity.getCdpCode());

                updateCdpView(cdpView, cdpTestEntity.getCdpCode());

            } else {
                TextView textView = new TextView(MPaaSActivity.this);
                textView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTextColor(Color.BLACK);
                textView.setText(cdpTestEntity.getContent());
                mLayoutRoot.addView(textView);

            }

        }
    }

    private void updateCdpView(CdpAdvertisementView cdpView, String cdpCode) {
        CdpManager.getInstance().getSpaceInfoByCode(cdpCode, new CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack() {
            @Override
            public void onSuccess(SpaceInfo spaceInfo) {
                if (spaceInfo.spaceObjectList != null && spaceInfo.spaceObjectList.size() > 0) {
                    cdpView.updateSpaceCode(cdpCode);
                }
            }

            @Override
            public void onFail() {

            }
        });

    }

}