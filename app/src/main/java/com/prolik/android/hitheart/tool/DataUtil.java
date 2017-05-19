package com.prolik.android.hitheart.tool;

/**
 * Created by ProLik on 2017/5/11.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.prolik.android.hitheart.Constants;
import com.prolik.android.hitheart.manage.MediaManage;

import java.io.File;

/**
 * 配置文件处理和皮肤初始化处理
 */
public class DataUtil {
    private static SharedPreferences sharedPreferences;

    public static void init(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, context.MODE_PRIVATE);
        }
        initFont(context);
        initSharedPreference();
        initFile(context);
        //应用第一次使用，先将asserts里面的皮肤包解压
        if(Constants.isFrist){
            Constants.isFrist = false;
            saveValue(context, Constants.isFrist_KEY, Constants.isFrist);
        }
        initSongData(context);
    }

    private static void initSongData(Context context) {
        MediaManage.getMediaManage(context);
    }

    /**
     * 保存数据到SharedPreferences配置文件
     * @param context
     * @param key
     * @param data
     */
    private static void saveValue(Context context, String key, Object data) {
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME,Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(data instanceof Boolean){
            editor.putBoolean(key, (Boolean) data);
        }else if (data instanceof Integer){
            editor.putInt(key, (Integer) data);
        }else if(data instanceof Float){
            editor.putFloat(key, (Float) data);
        }else if(data instanceof Long){
            editor.putLong(key, (Long) data);
        }else if(data instanceof String){
            editor.putString(key , (String) data);
        }

        editor.commit();
    }

    /**
     * 初始化文件夹
     * @param context
     */
    private static void initFile(Context context) {
        File file = new File(Constants.PATH_AUDIO);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Constants.PATH_LYRICS);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Constants.PATH_ARTIST);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Constants.PATH_ALBUM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Constants.PATH_LOGCAT);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_CRASH);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_CACHE_IMAGE);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_CACHE_AUDIO);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_SKIN);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_APK);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_SPLASH);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_EasyTouch);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(Constants.PATH_AUDIOTEMP);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 初始化基本数据配置
     */
    private static void initSharedPreference() {
        //是否是第一次启动
        Constants.isFrist = sharedPreferences.getBoolean(Constants.isFrist_KEY, Constants.isFrist);

        //是否是wifi网络设置
        Constants.isWifi = sharedPreferences.getBoolean(Constants.isWifi_KEY, Constants.isWifi);

        //播放分模式
        Constants.playModel = sharedPreferences.getInt(Constants.playModel_KEY, Constants.playModel);

        //桌面歌词
        Constants.showDesktopLyrics = sharedPreferences.getBoolean(Constants.showDesktopLyrics_KEY, Constants.showDesktopLyrics);

        //桌面歌词的位置x轴
        Constants.LRCX = sharedPreferences.getInt(Constants.LRCX_KEY, Constants.LRCX);

        //桌面歌词的位置y轴
        Constants.LRCY = sharedPreferences.getInt(Constants.LRCY_KEY, Constants.LRCY);

        //桌面歌词是否可以移动
        Constants.desktopLyricsIsMove = sharedPreferences.getBoolean(Constants.desktopLyricsIsMove_KEY, Constants.desktopLyricsIsMove);

        //锁屏歌词
        Constants.showLockScreen = sharedPreferences.getBoolean(Constants.showLockScreen_KEY, Constants.showLockScreen);

        //是否线控
        Constants.isWire = sharedPreferences.getBoolean(Constants.isWire_KEY, Constants.isWire);

        //是否开启辅助操控
        Constants.isEasyTouch = sharedPreferences.getBoolean(Constants.isEasyTouch_KEY, Constants.isEasyTouch);
        
        //是否开启问候音
        Constants.isSayHello = sharedPreferences.getBoolean(Constants.isSayHello_KEY, Constants.isSayHello);
        
        //音质索引
        Constants.soundIndex = sharedPreferences.getInt(Constants.soundIndex_KEY, Constants.soundIndex);
        
        //播放列表类型
        Constants.playListType = sharedPreferences.getInt(Constants.playListType_KEY, Constants.playListType);

        // 歌曲id
        Constants.playInfoID = sharedPreferences.getString(Constants.playInfoID_KEY, Constants.playInfoID);

        // 标题颜色索引
        Constants.colorIndex = sharedPreferences.getInt(Constants.colorIndex_KEY, Constants.colorIndex);

        // 歌词颜色索引
        Constants.lrcColorIndex = sharedPreferences.getInt(Constants.lrcColorIndex_KEY, Constants.lrcColorIndex);

        // 歌词字体大小
        Constants.lrcFontSize = sharedPreferences.getInt(Constants.lrcFontSize_KEY, Constants.lrcFontSize);

        // 桌面歌词字体大小
        Constants.desktopLrcFontSize = sharedPreferences.getInt(Constants.desktopLrcFontSize_KEY, Constants.desktopLrcFontSize);

        // 桌面歌词颜色索引
        Constants.desktopLrcIndex = sharedPreferences.getInt(Constants.desktopLrcIndex_KEY, Constants.desktopLrcIndex);

        // 是否是第一次点击显示桌面歌词
        Constants.isFristSettingDesLrc = sharedPreferences.getBoolean(Constants.isFristSettingDesLrc_KEY, Constants.isFristSettingDesLrc);

    }

    /***
     * 初始化字体
     * @param context
     */
    private static void initFont(Context context) {
        FontUtil.getInstance(context);
    }
}
