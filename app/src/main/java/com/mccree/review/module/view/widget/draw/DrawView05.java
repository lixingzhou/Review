package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.mccree.review.utils.LLog;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/18 15:53
 * Description: DrawText详解
 */
public class DrawView05 extends View {

    private Paint mPaint;

    public DrawView05(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int baseLineX = 0;
        int baseLineY = 200;

        //画基线
        canvas.drawLine(baseLineX, baseLineY, 1080, baseLineY, mPaint);

        String text = "Android自定义控件";
        mPaint.setTextSize(120);
        mPaint.setColor(Color.GREEN);

        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, baseLineX, baseLineY, mPaint);



        //计算各线在位置
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        LLog.i(fm.top + " , " + fm.ascent + " , " + fm.descent + " , " + fm.bottom);
        float ascent = baseLineY + fm.ascent;
        float descent = baseLineY + fm.descent;
        float top = baseLineY + fm.top;
        float bottom = baseLineY + fm.bottom;

        //画基线
        mPaint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, mPaint);

        //画top
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(baseLineX, top, 3000, top, mPaint);

        //画ascent
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX, ascent, 3000, ascent, mPaint);

        //画descent
        mPaint.setColor(Color.YELLOW);
        canvas.drawLine(baseLineX, descent, 3000, descent, mPaint);

        //画bottom
        mPaint.setColor(Color.RED);
        canvas.drawLine(baseLineX, bottom, 3000, bottom, mPaint);


    }
}
