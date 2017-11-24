package com.wstatic.toolandstatusbarlibrary;

import android.app.Activity;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.githang.statusbar.StatusBarCompat;
import com.kelin.translucentbar.library.TranslucentBarManager;

/**
 * Created by static on 2017/11/24/024.
 */

public class ToolAndStatusBarHelp {
    private static ToolAndStatusBarHelp toolAndStatusBarHelp;
    private ToolAndStatusBarHelp(){}
    public static ToolAndStatusBarHelp getInstance(){
        if (toolAndStatusBarHelp==null){
            synchronized (ToolAndStatusBarHelp.class){
                if (toolAndStatusBarHelp==null){
                    toolAndStatusBarHelp=new ToolAndStatusBarHelp();
                }
            }
        }
        return toolAndStatusBarHelp;
    }
    /**
     * ToolBar和StatusBar颜色一致的沉浸式(Activity)
     * */
    public void setToolAndStatusBarColor(Activity activity,@ColorRes int color){
        TranslucentBarManager translucentBarManager = new TranslucentBarManager(activity);
        translucentBarManager.transparent(activity,color);
    }
    /**
     * ToolBar和StatusBar颜色一致的沉浸式(Fragment)
     * */
    public void setToolAndStatusBarColor(Fragment fragment, View contentView,@ColorRes int color){
        TranslucentBarManager translucentBarManager = new TranslucentBarManager(fragment);
        translucentBarManager.transparent(fragment,contentView,color);
    }
    /**
     * 透明的StatusBar
     * */
    public void setStatusBarTransparent(Activity activity){
        TranslucentBarManager translucentBarManager = new TranslucentBarManager(activity);
        translucentBarManager.transparent(activity);
    }
    /**
     * StatusBar颜色设置，且StatusBar的字体颜色自动调整显示深色还是浅色
     * */
    public void setStatusBarColor(Activity activity,@ColorRes int color){
        StatusBarCompat.setStatusBarColor(activity, activity.getResources().getColor(color));
    }
    /**
     * StatusBar颜色设置，且手动调整StatusBar的字体颜色显示深色还是浅色
     * */
    public void setStatusBarColor(Activity activity,@ColorRes int color,boolean isLightBar){
        StatusBarCompat.setStatusBarColor(activity, activity.getResources().getColor(color),isLightBar);
    }
}
