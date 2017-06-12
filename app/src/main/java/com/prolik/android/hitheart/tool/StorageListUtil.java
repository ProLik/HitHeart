package com.prolik.android.hitheart.tool;

import android.app.Activity;
import android.content.Context;
import android.os.storage.StorageManager;

import java.lang.reflect.Method;

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


    }
}
