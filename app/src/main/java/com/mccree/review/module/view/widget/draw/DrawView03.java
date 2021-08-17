package com.mccree.review.module.view.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/17 16:29
 * Description:区域
 */
public class DrawView03 extends View {

    private Context mContext;
    private Paint mPaint;

    public DrawView03(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Region region = new Region(10, 10, 100, 100);
//        region.set(100, 100, 200, 200);
//        drawRegion(canvas, region, mPaint);

        Path ovalPath = new Path();
        RectF rect = new RectF(50, 50, 400, 1000);
        ovalPath.addOval(rect, Path.Direction.CCW);
        //SetPath时,传入一个比椭圆区域小的矩形区域,让其取交集
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50, 50, 400, 525));
        //画出路径
        drawRegion(canvas, rgn, mPaint);


        //区域合并
        //构造两个矩形
        Rect rect1 = new Rect(100,700,400,800);
        Rect rect2 = new Rect(200,600,300,900);

        //构造一个画笔，画出矩形轮廓
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        //构造两个Region
        Region region = new Region(rect1);
        Region region2= new Region(rect2);

        /*假设用region1  去组合region2
        public enum Op {
            DIFFERENCE(0), //最终区域为region1 与 region2不同的区域
            INTERSECT(1), // 最终区域为region1 与 region2相交的区域
            UNION(2),      //最终区域为region1 与 region2组合一起的区域
            XOR(3),        //最终区域为region1 与 region2相交之外的区域
            REVERSE_DIFFERENCE(4), //最终区域为region2 与 region1不同的区域
            REPLACE(5); //最终区域为为region2的区域
        }*/

        //取两个区域的交集
//        region.op(region2, Region.Op.DIFFERENCE);
//        region.op(region2, Region.Op.INTERSECT);
//        region.op(region2, Region.Op.UNION);
        region.op(region2, Region.Op.XOR);
//        region.op(region2, Region.Op.REVERSE_DIFFERENCE);
//        region.op(region2, Region.Op.REPLACE);

        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.GREEN);
        paint_fill.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region, paint_fill);


        /*//其他方法
        *//**几个判断方法*//*
        public native boolean isEmpty();//判断该区域是否为空
        public native boolean isRect(); //是否是一个矩阵
        public native boolean isComplex();//是否是多个矩阵组合


        *//**一系列的getBound方法，返回一个Region的边界*//*
        public Rect getBounds()
        public boolean getBounds(Rect r)
        public Path getBoundaryPath()
        public boolean getBoundaryPath(Path path)


        *//**一系列的判断是否包含某点 和是否相交*//*
        public native boolean contains(int x, int y);//是否包含某点
        public boolean quickContains(Rect r)   //是否包含某矩形
        public native boolean quickContains(int left, int top, int right,
        int bottom) //是否没有包含某矩阵形
        public boolean quickReject(Rect r) //是否没和该矩形相交
        public native boolean quickReject(int left, int top, int right, int bottom); //是否没和该矩形相交
        public native boolean quickReject(Region rgn);  //是否没和该矩形相交

        *//**几个平移变换的方法*//*
        public void translate(int dx, int dy)
        public native void translate(int dx, int dy, Region dst);
        public void scale(float scale) //hide
        public native void scale(float scale, Region dst);//hide  */

    }


    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
