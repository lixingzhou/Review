package com.mccree.review.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import com.alipay.mobile.framework.quinoxless.QuinoxlessPrivacyUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.mccree.review.R;
import com.mccree.review.module.mpaas.MPaaSActivity;
import com.mccree.review.module.view.ViewActivity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Module> mModules;
    private ModuleAdapter mModuleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        AndPermission.with(this)
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE, Permission.ACCESS_FINE_LOCATION)
                .onGranted(permissions -> {
                    initEvent();
                })
                .onDenied(permissions -> {
                    Toast.makeText(MainActivity.this, "Permission Denied!!", Toast.LENGTH_SHORT).show();
                })
                .start();

    }

    private void initEvent() {

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mModules = new ArrayList<>();
        mModules.add(new Module(0, "mPaaS"));
        mModules.add(new Module(1, "View"));

        mModuleAdapter = new ModuleAdapter(R.layout.layout_module, mModules);
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
}