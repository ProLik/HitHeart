package com.prolik.android.hitheart.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.prolik.android.hitheart.R;
import com.prolik.android.hitheart.manage.ActivityManager;
import com.prolik.android.hitheart.model.StorageInfo;
import com.prolik.android.hitheart.tool.StorageListUtil;
import com.prolik.android.hitheart.view.BaseColorImageButton;

import java.util.List;


public class ScaningActivity extends BaseActivity {

    /**
     * 是否完成
     */
    private boolean isFinish = false;

    /**
     * 扫描按钮
     */
    private BaseColorImageButton scanFinishButton;
    /**
     * 扫描结果
     */
    private TextView scaningTipTextView;
    /**
     * 扫描路径
     */
    private TextView pathTextView;

    /**
     * 歌曲首数
     */
    private int songSize = 0;

    private Handler scanHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    //开始扫描
                    scanFinishButton.setVisibility(View.INVISIBLE);
                    pathTextView.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    //扫描完成
                    scanFinishButton.setVisibility(View.VISIBLE);
                    pathTextView.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    //扫描中
                    String path = (String) msg.obj;
                    pathTextView.setText(path);
                    break;
                default:
                    break;
            }
            scaningTipTextView.setText("已添加歌曲" + songSize + "首");
            super.handleMessage(msg);
        }
    };

    @Override
    public int setContentViewId() {
        return R.layout.activity_scaning;
    }

    @Override
    public void onCreate() {
        init();
        loadData();
    }

    private void init() {
        ActivityManager.getInstance().addActivity(this);
        scaningTipTextView  = (TextView) findViewById(R.id.scaningTip);
        pathTextView = (TextView) findViewById(R.id.scaningPathTip);

        //扫描完成
        scanFinishButton = (BaseColorImageButton) findViewById(R.id.scanFinishButton);
        scanFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });
    }

    private void loadData() {

        new AsyncTask<String, Integer, String>(){

            @Override
            protected String doInBackground(String... params) {
                scanStart();
                scaning();
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                scaned();
                super.onPostExecute(s);
            }
        }.execute("");
    }

    /**
     * 扫描开始
     */
    private void scanStart() {
        scanHandler.sendEmptyMessage(0);
        isFinish = false;
    }

    /**
     * 扫描中
     */
    private void scaning() {
        scannerMusic();
    }


    /**
     * 扫描完成
     */
    private void scaned() {

    }

    /**
     * 扫描歌曲，从手机文件夹里面进行递归扫描
     */
    private void scannerMusic() {
        songSize = 0;
        List<StorageInfo> list = StorageListUtil.listAvaliableStorage(getApplicationContext());
        for (int i = 0; i < list.size(); i++) {
            StorageInfo storageInfo = list.get(i);
            scannerLocalAudioFile(storageInfo.path, true);
        }
    }
    /**
     * @param path        搜索目录
     * @param b 是否进入子文件夹
     */
    private void scannerLocalAudioFile(String path, boolean b) {

    }


}
