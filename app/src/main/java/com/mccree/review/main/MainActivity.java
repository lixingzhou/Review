package com.mccree.review.main;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.mccree.review.MyApplication;
import com.mccree.review.R;
import com.mccree.review.base.MyBaseActivity;
import com.mccree.review.greendao.DaoManager;
import com.mccree.review.module.database.DatabaseActivity;
import com.mccree.review.module.fragment.FragmentActivity;
import com.mccree.review.module.mpaas.CdpManager;
import com.mccree.review.module.mpaas.MPaaSActivity;
import com.mccree.review.module.mpaas.MPaaSSplashActivity;
import com.mccree.review.module.tools.ToolsActivity;
import com.mccree.review.module.view.ViewActivity;
import com.mccree.review.utils.LLog;
import com.mpaas.mas.adapter.api.MPLogger;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MyBaseActivity {

    private RecyclerView mRecyclerView;
    private List<Module> mModules;
    private ModuleAdapter mModuleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        requestPermission();
        MPLogger.reportUserLogin(MyApplication.getInstance().getAccountId());
        MPLogger.setUserId(MyApplication.getInstance().getAccountId());

        //刷新所有广告
        CdpManager.getInstance().refreshAllCdp();
        //设置广告点击事件处理器
        CdpManager.getInstance().setActionExecutor();


        //智能投放-启动页广告
        try {
            if (CdpManager.getInstance().checkIfSplashPrepared()) {
                showSplash();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LLog.e(e.getMessage());
        }

        DaoManager.getInstance().init(getApplication());

    }

    private void requestPermission() {
        AndPermission.with(this)
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE
                        , Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_BACKGROUND_LOCATION, Permission.ACCESS_COARSE_LOCATION)
                .onGranted(permissions -> {
                    initEvent();
                })
                .onDenied(permissions -> {
                    Toast.makeText(MainActivity.this, "Permission Denied!!", Toast.LENGTH_SHORT).show();
                })
                .start();

    }

    private void showSplash() {
        startActivity(new Intent(this, MPaaSSplashActivity.class));
        overridePendingTransition(0, 0); // 去掉转场动画
    }

    private void initEvent() {

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mModules = new ArrayList<>();
        mModules.add(new Module(0, "mPaaS"));
        mModules.add(new Module(1, "View"));
        mModules.add(new Module(2, "Fragment"));
        mModules.add(new Module(3, "Tools"));
        mModules.add(new Module(4, "Database"));

        mModuleAdapter = new ModuleAdapter(R.layout.layout_module_item, mModules);
        mModuleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                Intent intent = null;
                switch (mModules.get(position).getIndex()) {
                    case 0:
                        intent = new Intent(MainActivity.this, MPaaSActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, FragmentActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ToolsActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, DatabaseActivity.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mModuleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MPLogger.setUserId(null);
    }
}