package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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

        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int baseLineX = 0;
        int baseLineY = 200;

        String text = "自定义控件";
        /*mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(120);
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, baseLineX, baseLineY, mPaint);

        Rect minRect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), minRect);
        LLog.e(minRect.toShortString());

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
        canvas.drawLine(baseLineX, bottom, 3000, bottom, mPaint);*/


        //画文字显示区域
        /*mPaint.setTextSize(120);
        mPaint.setTextAlign(Paint.Align.LEFT);

        //画text所占的区域
        Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
        int top = baseLineY + fm.top;
        int bottom = baseLineY + fm.bottom;
        int width = (int) mPaint.measureText(text);
        Rect rect = new Rect(baseLineX, top, baseLineX + width, bottom);

        mPaint.setColor(Color.GREEN);
        canvas.drawRect(rect, mPaint);

        //画最小矩形
        Rect minRect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), minRect);
        minRect.top = baseLineY + minRect.top;
        minRect.bottom = baseLineY + minRect.bottom;
        mPaint.setColor(Color.RED);
        canvas.drawRect(minRect, mPaint);

        //写文字
        mPaint.setColor(Color.BLACK);
        canvas.drawText(text, baseLineX, baseLineY, mPaint);*/

        //通过中间线,推导baseline, drawText
//        baseline = center + (FontMetrics.bottom - FontMetrics.top)/2 - FontMetrics.bottom;

        int center = 200;
        baseLineX = 0;

        //设置paint
        Paint paint = new Paint();
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStrokeWidth(3);

        //画center线
        paint.setColor(Color.YELLOW);
        canvas.drawLine(baseLineX, center, 3000, center, paint);

        //计算出baseLine位置
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        baseLineY = center + (fm.bottom - fm.top) / 2 - fm.bottom;

        //画基线
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //写文字
        paint.setColor(Color.GREEN);
        canvas.drawText(text, baseLineX, baseLineY, paint);

    }
}
