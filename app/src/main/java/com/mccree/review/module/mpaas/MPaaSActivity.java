package com.mccree.review.module.mpaas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mccree.review.R;

public class MPaaSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpaas_activity);

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MPNebula.startApp("6214856552053526");
//                MPNebula.startApp("1234567800000000");
//                MPNebula.startApp("2018080616290001");
            }

        });

    }
}