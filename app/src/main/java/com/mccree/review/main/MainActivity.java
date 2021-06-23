package com.mccree.review.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import com.alipay.mobile.framework.quinoxless.QuinoxlessPrivacyUtil;
import com.alipay.mobile.framework.quinoxless.QuinoxlessPrivacyUtil;
import com.mccree.review.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //同意隐私协议
        QuinoxlessPrivacyUtil.sendPrivacyAgreedBroadcast(this);
        /*//用户是否已经同意隐私权限的使用。
        boolean isAgree = QuinoxlessPrivacyUtil.isUserAgreed(this);
        //更新用户同意使用隐私权限的标记，可以方便您在特定的场景下再次弹窗
        QuinoxlessPrivacyUtil.setUserAgreedState(this,false);*/
    }
}