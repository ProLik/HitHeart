package com.prolik.android.hitheart.tool;

import android.content.Context;
import android.graphics.Typeface;

/**
 * 加载字体
 *
 * Created by ProLik on 2017/5/15.
 */

public class FontUtil {

    private static Typeface typeface;

    private static FontUtil _fontUtil;

    public FontUtil(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(),"fonts/iconfont.ttf");
    }

    public static FontUtil getInstance(Context context){
        if(_fontUtil == null){
            _fontUtil = new FontUtil(context);
        }
        return _fontUtil;
    }

    public static Typeface getTypeface() {
        return FontUtil.typeface;
    }
}
