package com.mccree.review.base;


import com.alipay.mobile.framework.app.ui.BaseActivity;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/13 10:47
 * Description:
 */
public class MyBaseActivity extends BaseActivity {


    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        try {
            super.setRequestedOrientation(requestedOrientation);
        } catch (Exception ignore) {
        }
    }
}
