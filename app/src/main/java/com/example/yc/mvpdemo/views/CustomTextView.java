package com.example.yc.mvpdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.yc.mvpdemo.R;

/**
 * Created by Yuchao on 2017/9/23.
 */

public class CustomTextView extends View {

    private int mColor = Color.RED;//默认为红色
    private String mText = "I am a Custom TextView";//默认显示该文本
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//画笔

    public CustomTextView(Context context) {
        super(context);
//        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);//注意不是super(context,attrs,0);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {//解析自定义属性
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        mColor = typedArray.getColor(R.styleable.CustomTextView_customColor, Color.RED);
//        如果没有判断，当没有指定该属性而去加载该属性app便会崩溃掉
        if (typedArray.getText(R.styleable.CustomTextView_customText) != null) {
            mText = typedArray.getText(R.styleable.CustomTextView_customText).toString();
        }
        typedArray.recycle();//释放资源
        init();
    }

    private void init() {
        mPaint.setColor(mColor);// 为画笔添加颜色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mText, 100, 100, mPaint);
    }
}

