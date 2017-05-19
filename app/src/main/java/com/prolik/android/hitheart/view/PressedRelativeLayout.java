package com.prolik.android.hitheart.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.prolik.android.hitheart.tool.ColorUtil;

import static com.prolik.android.hitheart.tool.DataUtil.init;

/**
 * 按钮点击过后，背景颜色
 * Created by LIKANG on 2017/5/17.
 */
public class PressedRelativeLayout extends RelativeLayout {
    private int pressColor;
    private boolean isPressed = false;
    private boolean isLoadColor = false;

    public PressedRelativeLayout(Context context) {
        super(context);
        init(context);
    }

    public PressedRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PressedRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if(!isLoadColor){
            pressColor = ColorUtil.parserColor("#000000",25);
            if(isPressed){
                setBackgroundColor(pressColor);
            }else{
                //透明
                setBackgroundColor(Color.TRANSPARENT);
            }
            isLoadColor = true;
        }
        super.dispatchDraw(canvas);
    }

    public void setPressColor(int pressColor) {

        this.pressColor = pressColor;
        invalidate();
    }

    @Override
    public void setPressed(boolean pressed) {
        isLoadColor = false;
        isPressed = pressed;
        //使当前view无效
        invalidate();
        super.setPressed(pressed);
    }
}
