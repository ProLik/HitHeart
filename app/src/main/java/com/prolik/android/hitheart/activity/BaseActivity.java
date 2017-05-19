package com.prolik.android.hitheart.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.prolik.android.hitheart.R;

/**
 * Created by ProLik on 2017/5/10.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View contentView = LayoutInflater.from(getApplicationContext()).inflate(setContentViewId(),null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }

        setContentView(contentView);
        onCreate();

    }

    protected static int getStatusBarHeight(Context context){
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resourceId > 0){
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;

    }


    public void setStatusBarView(View titleView){
        ViewGroup titleViewGroup = (ViewGroup) titleView;

        int statusBarHeight = getStatusBarHeight(this);
        View statusBarView = new View(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        statusBarView.setBackgroundColor(getResources().getColor(R.color.titleBG));
        titleViewGroup.addView(statusBarView,0,lp);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,R.anim.activity_ani_exit);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.activity_ani_exit);
    }

    /**
     * 设置主界面的布局文件
     *
     * @return
     */
    public abstract int setContentViewId();

    public abstract void onCreate();
}
