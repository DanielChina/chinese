package test.zx.chinese.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import test.zx.chinese.R;

/**
 * Created by THink on 2018/2/18.
 */

public abstract class BaseView extends View {
    private Context context;
    private int mOriginX,mOriginY;
    private int mWidth,mHeight;
    private int mScreenWidth,mScreenHeight;
    private Paint mPaint;
    private String mGraphicTitle;
    private int mColor;
    private float mTextSize;
    private String mXAxisName,mYAxisName;

    public BaseView(Context context) {
        this(context,null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //pattern of self-defined
        mScreenWidth=getWidth();
        mScreenHeight=getHeight();
        mOriginX=mScreenWidth/4;
        mOriginY=(mScreenHeight*2)/3;
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyFirstStyle);
        mGraphicTitle=typedArray.getString(R.styleable.MyFirstStyle_graphTitle);
        mXAxisName=typedArray.getString(R.styleable.MyFirstStyle_xAxisName);
        mYAxisName=typedArray.getString(R.styleable.MyFirstStyle_yAxisName);
        mColor=typedArray.getColor(R.styleable.MyFirstStyle_axisTextColor, getResources().getColor(R.color.colorPrimary));
        mTextSize=typedArray.getDimension(R.styleable.MyFirstStyle_axisTextSize,12);
        if(typedArray!=null){
            typedArray.recycle();
        }
    }
    public void iniPaint(){
        if(mPaint==null){
            mPaint=new Paint();
            mPaint.setDither(true);
            mPaint.setAntiAlias(true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth=mScreenWidth/2;
        mHeight=mScreenHeight/3;
        drawXAxis(canvas,mPaint);
        drawYAxis(canvas,mPaint);
        drawTitle(canvas,mPaint);
        drawXAxisScale(canvas,mPaint);
        drawYAxisScale(canvas,mPaint);
        drawXAxisScaleValue(canvas,mPaint);
        drawYAxisScaleValue(canvas,mPaint);
        drawArrowAndText(canvas,mPaint,mOriginX+mWidth,mOriginY,20,40,true);
        drawArrowAndText(canvas,mPaint,mOriginX,mOriginY-mHeight,20,40,false);
        drawColumn(canvas,mPaint);
    }
    public void drawTitle(Canvas canvas,Paint paint){
        float xAxis,yAxis;
        xAxis=mScreenWidth/2-(paint.measureText(mGraphicTitle))/2;
        yAxis=(mOriginY+mTextSize/2+10);
        if(!TextUtils.isEmpty(mGraphicTitle)){
            mPaint.setTextSize(mTextSize);
            mPaint.setColor(mColor);
            mPaint.setFakeBoldText(true);
            canvas.drawText(mGraphicTitle,xAxis,yAxis,paint);
        }
    }
    protected void drawArrowAndText(Canvas canvas,Paint paint,float x,float y,float width,float height, boolean IfXDirection){
        Path mPathX=new Path();
        if(IfXDirection){
            canvas.drawText(mXAxisName,x-paint.measureText(mXAxisName),y+width+10,paint);
            mPathX.moveTo(x, y);
            mPathX.lineTo(x - height, y - (width / 2));
            mPathX.lineTo(x-height,y+(width/2));

        } else{
            canvas.drawText(mYAxisName,x-paint.measureText(mXAxisName)-width-10,y,paint);
            mPathX.moveTo(x, y);
            mPathX.lineTo(x - width/2, y +height);
            mPathX.lineTo(x+width/2,y+height);
        }
        mPathX.close();
        canvas.drawPath(mPathX,paint);
    }
    protected void drawXAxis(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawLine(mOriginX,mOriginY,mOriginX+mWidth,mOriginY,paint);
    }

    protected void drawYAxis(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawLine(mOriginX,mOriginY,mOriginX,mOriginY-mHeight,paint);
    }

    protected void drawXAxisScale(Canvas canvas, Paint paint) {

    }

    protected void drawYAxisScale(Canvas canvas, Paint paint) {

    }

    protected void drawXAxisScaleValue(Canvas canvas, Paint paint) {

    }

    protected void drawYAxisScaleValue(Canvas canvas, Paint paint) {

    }

    protected void drawColumn(Canvas canvas, Paint paint) {

    }

}
