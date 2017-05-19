package com.prolik.android.hitheart.manage;

import android.content.Context;

import com.prolik.android.hitheart.observable.ObserverManage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ProLik on 2017/5/16.
 */

public class MediaManage implements Observer {

    private static MediaManage _mediaManage;

    private final Context context;

    private LoggerManage logger;

    public MediaManage(Context context) {
        this.context = context;
        init();
    }


    private void init() {
        this.logger = LoggerManage.getLoggerManage(this.context);
        //添加观察者
        //ObserverManage.getObserver().addObserver(MediaManage.this);
        initAllSongData(this.context);
    }

    /**
     * 初始化本地歌曲列表
     * @param context
     */
    private void initAllSongData(Context context) {
    }

    public static MediaManage getMediaManage(Context context){
        if(_mediaManage == null){
            _mediaManage = new MediaManage(context);
        }
        return _mediaManage;
    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
