package com.mccree.review.module.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mccree.review.R;
import com.mccree.review.utils.AppMarketUtils;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/27 11:28
 * Description: 工具集(旁门左道)
 */
public class ToolsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvOpenMarket;//跳转应用在应用市场中下载页(详情页)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_open_market:
                AppMarketUtils.gotoMarket(this, "com.glsx.aicar");
                break;
        }

    }

    private void initView() {
        mTvOpenMarket = findViewById(R.id.tv_open_market);
        mTvOpenMarket.setOnClickListener(this);
    }
}