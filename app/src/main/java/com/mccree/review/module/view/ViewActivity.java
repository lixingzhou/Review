package com.mccree.review.module.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.mccree.review.R;

public class ViewActivity extends AppCompatActivity {

    private FrameLayout mLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mLayoutRoot = findViewById(R.id.layout_root);
    }
}