package com.mccree.review.module.view.widget.draw;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/19 11:39
 * Description:Path之贝赛尔曲线和手势轨迹、水波纹效果
 */
public class DrawView06_01 extends View {

    private Paint mPaint;
    private Path mPath;
    private int mItemWaveLength = 700;
    private int dx;

    public DrawView06_01(Context context) {
        super(context);

        mPaint = new Paint();
//        mPaint.setAntiAlias(true);

        mPath = new Path();

        new Handler().postDelayed(() -> startAnim(), 1000);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //贝塞尔曲线
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(3);
//        Path path = new Path();
//        //moveTo至起点坐标,未调用默认从(0,0)开始
//        path.moveTo(100, 300);
//        /*//贝塞尔曲线,参数中(x1,y1)是控制点坐标，(x2,y2)是终点坐标
//        path.quadTo(200, 200, 300, 300);
//        //调用quadTo后,再次调用,即上一次终点为本次起点坐标
//        path.quadTo(400, 400, 500, 300);*/
//        path.rQuadTo(100,-100,200,0);
//        path.rQuadTo(100,100,200,0);
//
//        canvas.drawPath(path, mPaint);

        mPath.reset();
        int originY = 300;
        int halfWaveLen = mItemWaveLength / 2;
        mPath.moveTo(-mItemWaveLength + dx, originY);
        for (int i = -mItemWaveLength; i <= getWidth() + mItemWaveLength; i += mItemWaveLength) {
            mPath.rQuadTo(halfWaveLen / 2, -50, halfWaveLen, 0);
            mPath.rQuadTo(halfWaveLen / 2, 50, halfWaveLen, 0);
        }

        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();

        canvas.drawPath(mPath, mPaint);


    }

    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

}
