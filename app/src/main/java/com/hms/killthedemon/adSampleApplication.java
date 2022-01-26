package com.hms.killthedemon;

import android.app.Application;

import com.huawei.hms.ads.HwAds;

public class adSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HwAds.init(this);
    }
}
