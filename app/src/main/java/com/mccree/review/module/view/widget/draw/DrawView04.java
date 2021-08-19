package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/18 11:19
 * Description:canvas变换与操作
 */
public class DrawView04 extends View {
    private Paint mPaint;

    public DrawView04(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect = new Rect(0, 0, 400, 200);
        canvas.drawRect(rect, mPaint);

        /*mPaint.setColor(Color.RED);
        //平移
//        canvas.translate(100,100);
        //旋转
//        canvas.rotate(45);
        *//*canvas.rotate(45,500,500);
        canvas.drawPoint(500,500,mPaint);*//*

        //缩放
//        canvas.scale(0.5F,2F);

        canvas.save();
        //扭曲(斜切/倾斜)
        canvas.skew((float) Math.tan(60), 0);


        canvas.drawRect(rect, mPaint);
        canvas.restore();

        canvas.drawColor(Color.RED);
        canvas.clipRect(new Rect(100, 100, 200, 200));
        canvas.drawColor(Color.GREEN);*/

        canvas.drawColor(Color.RED);
        //保存的画布大小为全屏幕大小
        canvas.save();

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);
        //保存画布大小为Rect(100, 100, 800, 800)
        canvas.save();

        canvas.clipRect(new Rect(200, 200, 700, 700));
        canvas.drawColor(Color.BLUE);
        //保存画布大小为Rect(200, 200, 700, 700)
        canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLACK);
        //保存画布大小为Rect(300, 300, 600, 600)
        canvas.save();

        canvas.clipRect(new Rect(400, 400, 500, 500));
        canvas.drawColor(Color.WHITE);

        //将栈顶的画布状态取出来，作为当前画布，并画成黄色背景
        /*canvas.restore();
        canvas.restore();
        canvas.restore();
        canvas.drawColor(Color.YELLOW);*/


    }
}
