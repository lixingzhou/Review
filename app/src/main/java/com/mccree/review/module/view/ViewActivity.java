package com.mccree.review.module.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mccree.review.R;
import com.mccree.review.module.view.widget.draw.DrawView01;
import com.mccree.review.module.view.widget.draw.DrawView02;
import com.mccree.review.module.view.widget.draw.DrawView03;
import com.mccree.review.module.view.widget.draw.DrawView04;
import com.mccree.review.module.view.widget.draw.DrawView05;
import com.mccree.review.module.view.widget.draw.DrawView06;
import com.mccree.review.module.view.widget.draw.DrawView06_01;

public class ViewActivity extends AppCompatActivity {

    private FrameLayout mLayoutRoot;
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mLayoutRoot = findViewById(R.id.layout_root);
        mBtnClick = findViewById(R.id.btn_click);
//        mLayou tRoot.addView(new DrawView01(this));
//        mLayoutRoot.addView(new DrawView02(this));
//        mLayoutRoot.addView(new DrawView03(this));
//        mLayoutRoot.addView(new DrawView04(this));
//        mLayoutRoot.addView(new DrawView05(this));

        /*DrawView06 view06 = new DrawView06(this);
        mBtnClick.setVisibility(View.VISIBLE);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view06.reset();
            }
        });
        mLayoutRoot.addView(view06);*/

        mLayoutRoot.addView(new DrawView06_01(this));

//        mLayoutRoot.addView(new DrawView07(this));

    }
}