package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/24 16:52
 * Description:
 */
public class DrawView07  extends View {

    private Paint mPaint;

    public DrawView07(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(40);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path  = new Path();
        path.moveTo(100,100);
        path.lineTo(450,100);
        path.lineTo(100,300);
        //设置结合处为锐角
        mPaint.setStrokeJoin(Paint.Join.MITER);
        //设置线帽样式，取值有Cap.ROUND(圆形线帽)、Cap.SQUARE(方形线帽)、Paint.Cap.BUTT(无线帽)
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPath(path,mPaint);

        path.moveTo(100,400);
        path.lineTo(450,400);
        path.lineTo(100,600);
        //结合处为直线
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPath(path,mPaint);

        path.moveTo(100,700);
        path.lineTo(450,700);
        path.lineTo(100,900);
        //结合处为圆弧
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPath(path,mPaint);

    }
}
