package com.wstatic.toolandstatusbar.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarMagager;


/**
 * Created by static on 2017/12/12/012.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        ToolAndStatusBarMagager.getInstance().setToolbarHeight(56);
    }
}
