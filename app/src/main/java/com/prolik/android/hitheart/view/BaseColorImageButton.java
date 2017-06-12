package com.prolik.android.hitheart.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.prolik.android.hitheart.tool.ColorUtil;
import com.prolik.android.hitheart.tool.FontUtil;

/**
 * Created by ProLik on 2017/6/6.
 */

public class BaseColorImageButton extends android.support.v7.widget.AppCompatTextView {
    private int defColor;
    private int pressColor;
    private boolean isPressed = false;
    private boolean isLoadColor = false;

    public BaseColorImageButton(Context context) {
        super(context);
        init(context);
    }

    public BaseColorImageButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseColorImageButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //设置字体图片
        Typeface typeface = FontUtil.getInstance(context).getTypeface();
        setTypeface(typeface);

        defColor = ColorUtil.parserColor("#ffffff",255);
        pressColor = ColorUtil.parserColor("#e1e1e1",200);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if(!isLoadColor){
            if(isPressed){
                setTextColor(pressColor);
            }else{
                setTextColor(defColor);
            }
            isLoadColor = true;
        }
        super.dispatchDraw(canvas);
    }

    @Override
    public void setPressed(boolean pressed) {
        isLoadColor = false;
        isPressed = pressed;
        invalidate();
        super.setPressed(pressed);
    }
}
