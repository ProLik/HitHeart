package com.prolik.android.hitheart.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.prolik.android.hitheart.tool.FontUtil;

/**
 * Created by ProLik on 2017/5/16.
 */

public class BaseImageView extends android.support.v7.widget.AppCompatTextView {
    public BaseImageView(Context context) {
        super(context);
        init(context);
    }

    public BaseImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        //设置字体图片
        Typeface typeface = FontUtil.getInstance(context).getTypeface();
        setTypeface(typeface);
    }

}
