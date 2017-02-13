package com.payne.anyshapeimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

public class AnyShapeImageView extends View {
    private Paint mPaint;
    private Bitmap mDstBmp, mSrcBmp;
    private RectF mRect;

    private Xfermode mXfermode;

    public AnyShapeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.AnyShapeImageView);
        int shapePicId = array.getResourceId(R.styleable.AnyShapeImageView_shapePic, R.mipmap.cat);
        int srcPicId = array.getResourceId(R.styleable.AnyShapeImageView_backgroundPic, R.mipmap.sea);
        array.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        mDstBmp = BitmapFactory.decodeResource(getResources(), shapePicId);
        mSrcBmp = BitmapFactory.decodeResource(getResources(), srcPicId);
        PorterDuff.Mode porterDuffMode = PorterDuff.Mode.SRC_IN;
        mXfermode = new PorterDuffXfermode(porterDuffMode);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);//背景色设为透明
        canvas.saveLayer(mRect, mPaint, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);//保存图层
        canvas.drawBitmap(mDstBmp, null, mRect, mPaint);//绘制目标图
        mPaint.setXfermode(mXfermode);//设置混合模式 （只在源图像和目标图像相交的地方绘制目标图像）
        canvas.drawBitmap(mSrcBmp, null, mRect, mPaint); //绘制源图
        mPaint.setXfermode(null);//清除混合模式
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int width = w <= h ? w : h;
        int centerY = h / 2;
        int quarterWidth = width / 2;
        mRect = new RectF(0, 0, w, centerY + quarterWidth);
    }
}