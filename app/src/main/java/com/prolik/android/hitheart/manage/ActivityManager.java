package com.prolik.android.hitheart.manage;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

import static android.os.Process.killProcess;
import static android.os.Process.myPid;

/**
 *
 * activity 的管理
 * 退出时，便利所有的activity
 * 并且finish，最后退出系统
 * Created by ProLik on 2017/6/3.
 */

public class ActivityManager {
    private List<Activity> activityList = new LinkedList<>();
    private static ActivityManager instance = null;

    public ActivityManager() {
    }

    public static ActivityManager getInstance(){
        if(instance == null){
            instance = new ActivityManager();
        }
        return instance;
    }


    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    public void exit(){
        for (Activity activity :activityList) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }

        int pid = myPid();
        if(pid != 0){
            killProcess(pid);
        }
    }
}
