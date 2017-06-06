package com.prolik.android.hitheart.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.prolik.android.hitheart.R;
import com.prolik.android.hitheart.manage.ActivityManager;
import com.prolik.android.hitheart.view.PressedRelativeLayout;

public class ScanActivity extends BaseActivity {
    //返回按钮
    private PressedRelativeLayout backButton;

    //扫描按钮
    private PressedRelativeLayout scanButton;

    @Override
    public int setContentViewId() {
        return R.layout.activity_scan;
    }

    @Override
    public void onCreate() {
        //设置状态栏
        LinearLayout statusBatView = (LinearLayout) findViewById(R.id.statusBarView);
        setStatusBarView(statusBatView);
        init();

        ActivityManager.getInstance().addActivity(this);
    }

    private void init() {
        //返回按钮
        if(backButton == null){
            backButton = (PressedRelativeLayout) findViewById(R.id.backParent);
        }
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //扫描按钮
        scanButton = (PressedRelativeLayout) findViewById(R.id.scanParent);
        scanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScanActivity.this, ScaningActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

    }
}
