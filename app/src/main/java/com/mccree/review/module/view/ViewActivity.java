package com.mccree.review.module.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.mccree.review.R;
import com.mccree.review.module.view.widget.draw.DrawView01;
import com.mccree.review.module.view.widget.draw.DrawView02;
import com.mccree.review.module.view.widget.draw.DrawView03;

public class ViewActivity extends AppCompatActivity {

    private FrameLayout mLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mLayoutRoot = findViewById(R.id.layout_root);
//        mLayoutRoot.addView(new DrawView01(this));
//        mLayoutRoot.addView(new DrawView02(this));
        mLayoutRoot.addView(new DrawView03(this));
    }
}