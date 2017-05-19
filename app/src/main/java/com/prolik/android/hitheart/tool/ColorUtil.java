package com.prolik.android.hitheart.tool;

import android.graphics.Color;

/**
 * 颜色处理类
 * Created by LIKANG on 2017/5/17.
 */

public class ColorUtil {

    /**
     * 解析颜色
     * @param colorStr #ffffff 颜色字符串
     * @param alpha 0-255 透明度
     * @return
     */
    public static int parserColor(String colorStr, int alpha){
        int color = Color.parseColor(colorStr);
        return parserColor(color, alpha);
    }

    /**
     * 解析颜色
     * @param color 0xffffff
     * @param alpha 0-255 透明度
     * @return
     */
    public static int parserColor(int color, int alpha){
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        return Color.argb(alpha, red, green, blue);
    }


    /**
     * 解析字符串
     * @param value #ffffff,255
     * @return
     */
    public static int parserColorValue(String value){
        String regularExpression = ",";
        if(value.contains(regularExpression)){
            String[] temp = value.split(regularExpression);
            int color = Color.parseColor(temp[0]);
            int alpha = Integer.valueOf(temp[1]);
            return parserColor(color, alpha);
        }
        return parserColor(value);
    }

    /**
     * 解析颜色
     *
     * @param value #ffffff 颜色字符串
     * @return
     */
    private static int parserColor(String value) {
        return Color.parseColor(value);
    }

}
