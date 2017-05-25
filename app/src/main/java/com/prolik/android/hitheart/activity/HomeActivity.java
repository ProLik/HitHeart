package com.prolik.android.hitheart.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.prolik.android.hitheart.R;
import com.prolik.android.hitheart.view.PressedRelativeLayout;

public class HomeActivity extends BaseActivity {

    PressedRelativeLayout scanButton;

    @Override
    public int setContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate() {
        //设置状态栏
        LinearLayout statusBarView = (LinearLayout) findViewById(R.id.statusBarView);

        setStatusBarView(statusBarView);

        init();
    }

    private void init() {
        //扫描按钮
        if (scanButton == null){
            scanButton = (PressedRelativeLayout) findViewById(R.id.scanButton);
        }
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
            }
        });
    }
}
