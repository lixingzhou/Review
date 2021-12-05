package com.mccree.review.base;


import android.app.Activity;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/13 10:47
 * Description:
 */
public class MyBaseActivity extends Activity {


    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        try {
            super.setRequestedOrientation(requestedOrientation);
        } catch (Exception ignore) {
        }
    }
}
