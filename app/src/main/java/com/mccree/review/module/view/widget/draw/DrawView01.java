package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;


/**
 * Created by: lixingzhou
 * Created Date: 2021/8/12 16:06
 * Description:概述及基本几何图形绘制
 */
public class DrawView01 extends View {

    private Paint mPaint;


    public DrawView01(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawARGB(0, 255, 255, 255);
        canvas.drawRGB(255, 255, 255);

        //圆，带阴影
//        mPaint.setShadowLayer(10, 15, 15, Color.RED);
        canvas.drawCircle(190, 200, 150, mPaint);

        //线条
        canvas.drawLine(190, 200, 390, 400, mPaint);

        //多条线条，两点相连，
        float points[] = new float[]{10, 10, 100, 100, 200, 200, 400, 400};
//        canvas.drawLines(points, mPaint);

        //点
        mPaint.setStrokeWidth(15);
        canvas.drawPoint(500, 500, mPaint);
        float points1[] = new float[]{10, 10, 100, 100, 200, 200, 400, 400};
//        canvas.drawPoints(points1, mPaint);
//        canvas.drawPoints(points1, 2, 4, mPaint);

        //矩形
        mPaint.setStrokeWidth(5);
        Rect rect = new Rect(100, 100, 300, 200);
        canvas.drawRect(rect, mPaint);

        RectF rectF = new RectF(550, 550, 1000, 800);
//        canvas.drawRect(rectF, mPaint);

        //圆角矩形
        canvas.drawRoundRect(rectF, 30, 30, mPaint);

        //圆形
        canvas.drawCircle(600, 600, 200, mPaint);

        //椭圆

        mPaint.setColor(Color.RED);
        canvas.drawOval(rectF, mPaint);
        //弧
        mPaint.setStyle(Paint.Style.FILL);
        RectF rectF1 = new RectF(100, 1000, 500, 1300);
        canvas.drawArc(rectF1, -90, 90, true, mPaint);
        mPaint.setColor(Color.CYAN);
        canvas.drawArc(rectF1, 90, 180, false, mPaint);


    }
}
