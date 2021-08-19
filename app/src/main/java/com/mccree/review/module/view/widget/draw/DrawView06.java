package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/19 11:39
 * Description:Path之贝赛尔曲线和手势轨迹、水波纹效果
 */
public class DrawView06 extends View {

    private Paint mPaint;
    private Path mPath;

    public DrawView06(Context context) {
        super(context);

        mPaint = new Paint();
//        mPaint.setAntiAlias(true);

        mPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //贝塞尔曲线
        /*mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        //moveTo至起点坐标,未调用默认从(0,0)开始
        path.moveTo(100, 300);
        //贝塞尔曲线,参数中(x1,y1)是控制点坐标，(x2,y2)是终点坐标
        path.quadTo(200, 200, 300, 300);
        //调用quadTo后,再次调用,即上一次终点为本次起点坐标
        path.quadTo(400, 400, 500, 300);
        canvas.drawPath(path, mPaint);*/

        //手指轨迹
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(mPath, mPaint);

    }

    /*//直接使用lineTo画路径,锯齿效果较明显
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mPath.moveTo(event.getX(), event.getY());
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                postInvalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }*/

    private float preX;
    private float preY;

    //使用贝塞尔曲线
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mPath.moveTo(event.getX(), event.getY());
                preX = event.getX();
                preY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE:
//                mPath.lineTo(event.getX(), event.getY());
                float endX = (preX + event.getX()) / 2;
                float endY = (preY + event.getY()) / 2;

                mPath.quadTo(preX, preY, endX, endY);
                preX = event.getX();
                preY = event.getY();
                postInvalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }


    public void reset() {
        mPath.reset();
        invalidate();
    }
}
