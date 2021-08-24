package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/24 17:51
 * Description:Paint之ColorMatrix与滤镜效果
 */
public class DrawView08 extends View {

    private Paint mPaint;

    public DrawView08(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
