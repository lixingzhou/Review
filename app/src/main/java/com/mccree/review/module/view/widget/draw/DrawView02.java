package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/17 14:33
 * Description:绘图篇 02
 */
public class DrawView02 extends View {

    private Paint mPaint;
    private Paint mTextPaint;
    private Context mContext;

    public DrawView02(Context context) {
        super(context);
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

        mTextPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //直线路径
        Path path = new Path();
        path.moveTo(100, 20);
        path.lineTo(400, 100);
        path.lineTo(100, 220);
        path.close();
        canvas.drawPath(path, mPaint);

        //矩形路径
        //逆时针
        Path CCWRectPath = new Path();
        RectF rect1 = new RectF(50, 250, 240, 400);
        CCWRectPath.addRect(rect1, Path.Direction.CCW.CCW);

        //顺时针
        Path CWRectPath = new Path();
        RectF rect2 = new RectF(290, 250, 480, 400);
        float radii[] = {10, 15, 20, 25, 30, 35, 40, 45};
//        CWRectPath.addRect(rect2, Path.Direction.CW);
        CWRectPath.addRoundRect(rect2, radii, Path.Direction.CW);

        canvas.drawPath(CCWRectPath, mPaint);
        canvas.drawPath(CWRectPath, mPaint);

        //依据路径写出文字
        String text = "ABCDEFG,HIJKLMN";
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(30);
//        canvas.drawTextOnPath(text, CCWRectPath, 0, 18, mPaint);//逆时针生成
//        canvas.drawTextOnPath(text, CWRectPath, 0, 18, mPaint);//顺时针生成

        //圆形路径
        Path path1 = new Path();
        path1.addCircle(700, 200, 150, Path.Direction.CCW);
        canvas.drawPath(path1, mPaint);

        //椭圆路径
        Path path2 = new Path();
        RectF rect = new RectF(50, 550, 240, 700);
        path2.addOval(rect, Path.Direction.CCW);
        canvas.drawPath(path2, mPaint);

        //弧线路径
        mPaint.setColor(Color.BLUE);
        Path path3 = new Path();
        RectF rect3 = new RectF(50, 50, 240, 200);
        path3.addArc(rect3, 0, 100);
        canvas.drawPath(path3, mPaint);


        //普通设置
        mTextPaint.setStrokeWidth(5);//设置画笔宽度
        mTextPaint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        mTextPaint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
        mTextPaint.setTextAlign(Paint.Align.LEFT);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
        mTextPaint.setTextSize(55);//设置文字大小

        //样式设置
        /*mTextPaint.setFakeBoldText(true);//设置是否为粗体文字
        mTextPaint.setUnderlineText(true);//设置下划线
        mTextPaint.setStrikeThruText(true);//设置带有删除线效果

        mTextPaint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
        canvas.drawText(text, 10, 1000, mTextPaint);
        mTextPaint.setTextSkewX((float) 0.25);//设置字体水平倾斜度，普通斜体字是-0.25
        canvas.drawText(text, 10, 1100, mTextPaint);*/


        mPaint.setTextSize(40);
        //变通样式字体
        canvas.drawText(text, 10, 1300, mTextPaint);

        //水平方向拉伸两倍
        mTextPaint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
        canvas.drawText(text, 10, 1400, mTextPaint);

        //写在同一位置,不同颜色,看下高度是否看的不变
        mTextPaint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText(text, 10, 1500, mTextPaint);

        mTextPaint.setColor(Color.GREEN);
        mTextPaint.setTextScaleX(2);//重新设置拉伸效果
        canvas.drawText(text, 10, 1500, mTextPaint);

        //使用系统自带字体绘制
        Paint paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(60);//设置文字大小
        paint.setStyle(Paint.Style.STROKE);//绘图样式，设置为填充

        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.NORMAL);
        paint.setTypeface(font);
        canvas.drawText(text, 10, 1600, paint);

        //自定义字体
        paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(60);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

        AssetManager mgr = mContext.getAssets();//得到AssetManager
        Typeface typeface = Typeface.createFromAsset(mgr, "fonts/font.ttf");//根据路径得到Typeface
        paint.setTypeface(typeface);
        canvas.drawText("此情可待成追忆，只是当时已惘然。", 10, 1700, paint);//两个构造函数


    }
}
