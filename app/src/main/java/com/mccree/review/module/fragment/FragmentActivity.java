package com.mccree.review.module.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.mccree.review.R;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/27 11:28
 * Description: Fragment模块
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mLayoutRoot;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    private TestFragment1 testFragment1;
    private TestFragment2 testFragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mLayoutRoot = findViewById(R.id.layout_fragment_root);
        findViewById(R.id.btn_replace).setOnClickListener(this);

        Bundle bundle = new Bundle();
        bundle.putString("text", "妈的智障");
        testFragment1 = TestFragment1.getInstance(bundle);
        testFragment2 = TestFragment2.getInstance(null);

        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.add(R.id.layout_fragment_root, testFragment1);
        mTransaction.commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_replace:
                replace();
                break;
        }

    }

    private void replace() {
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.layout_fragment_root, testFragment2);
        mTransaction.commit();
    }
}