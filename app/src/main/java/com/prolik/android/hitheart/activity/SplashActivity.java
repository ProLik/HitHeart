package com.prolik.android.hitheart.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.prolik.android.hitheart.MainActivity;
import com.prolik.android.hitheart.R;
import com.prolik.android.hitheart.tool.DataUtil;

public class SplashActivity extends BaseActivity {

    @Override
    public int setContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreate() {
        loadData();
    }

    private void loadData() {
        new AsyncTask<String,Integer,String>(){

            @Override
            protected String doInBackground(String... params) {
                try {
                    DataUtil.init(SplashActivity.this);
                    Thread.sleep(1* 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                goHome();
            }
        }.execute("");
    }

    private void goHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        //添加页面切换效果
        if(Build.VERSION.SDK_INT >= 5){
            overridePendingTransition(0,0);
        }
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
