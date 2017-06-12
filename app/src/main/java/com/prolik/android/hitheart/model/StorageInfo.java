package com.prolik.android.hitheart.model;

import java.io.Serializable;

/**
 * Created by ProLik on 2017/6/11.
 */

public class StorageInfo implements Serializable {

    public String path;
    public String state;
    public boolean isRemoveable;

    public StorageInfo(String path) {
        this.path = path;
    }

    public boolean isMounted(){
        return "mounted".equals(state);
    }
}
