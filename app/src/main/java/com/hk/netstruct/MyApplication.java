package com.hk.netstruct;

import android.app.Application;

/**
 * Created by hk on 2019/5/13.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.getInstance().init(new OkHttpProcessor());
    }
}
