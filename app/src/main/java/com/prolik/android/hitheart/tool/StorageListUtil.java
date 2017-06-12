package com.prolik.android.hitheart.tool;

import android.app.Activity;
import android.content.Context;
import android.os.storage.StorageManager;

import com.prolik.android.hitheart.model.StorageInfo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取手机可用的外置内存卡和内置的内存卡
 * Created by ProLik on 2017/6/11.
 */

public class StorageListUtil {

    private Activity activity;

    private StorageManager storageManager;
    private Method methodGetPaths;

    public StorageListUtil(Activity activity) {
        this.activity = activity;
        storageManager = (StorageManager) activity.getSystemService(Context.STORAGE_SERVICE);
        /**
         * api 被隐藏，可以通过反射来调用
         */
        try {
            methodGetPaths = storageManager.getClass().getMethod("getVolumePaths");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public String[] getVolumePaths() {
        String[] paths = null;

        try {
            paths = (String[]) methodGetPaths.invoke(storageManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return paths;
    }

    public static List<StorageInfo> listAvaliableStorage(Context context){
        ArrayList<StorageInfo> storageInfos = new ArrayList<>();
        StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);

        Class<?>[] paramClasses = {};
        try {
            Method getVolumeList = StorageManager.class.getMethod("getVolumeList", paramClasses);
            getVolumeList.setAccessible(true);
            Object[] params = {};
            Object[] invokes = (Object[]) getVolumeList.invoke(storageManager, params);
            if(invokes != null){
                StorageInfo info = null;
                for (int i = 0; i < invokes.length; i++){
                    Object obj = invokes[i];
                    Method getPath = obj.getClass().getMethod("getPath");
                    String path = (String) getPath.invoke(obj);
                    info = new StorageInfo(path);

                    File file = new File(info.path);
                    if(file.exists() && file.isDirectory() && file.canWrite()){
                        Method isRemovable = obj.getClass().getMethod("isRemovable");
                        String state = null;
                        try{
                            Method getVolumeState = StorageManager.class.getMethod("getVolumeState", String.class);
                            state = (String) getVolumeState.invoke(storageManager, info.path);
                            info.state = state;
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        if(info.isMounted()){
                            info.isRemoveable = ((Boolean) isRemovable.invoke(
                                    obj)).booleanValue();
                            storageInfos.add(info);
                        }
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        storageInfos.trimToSize();
        return storageInfos;
    }

}
