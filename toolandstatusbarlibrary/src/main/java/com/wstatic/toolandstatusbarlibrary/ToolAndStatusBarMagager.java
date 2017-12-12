package com.wstatic.toolandstatusbarlibrary;

import android.app.Activity;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wstatic.toolandstatusbarlibrary.statusbar.StatusBarCompat;
import com.wstatic.toolandstatusbarlibrary.translucentBar.TranslucentBarManager;

/**
 * Created by static on 2017/11/24/024.
 */

public class ToolAndStatusBarMagager {
    private static ToolAndStatusBarMagager toolAndStatusBarMagager;
    private int toolbarHeight;

    public int getToolbarHeight() {
        return toolbarHeight;
    }

    public void setToolbarHeight(int toolbarHeight) {
        this.toolbarHeight = toolbarHeight;
    }

    private ToolAndStatusBarMagager(){}
    public static ToolAndStatusBarMagager getInstance(){
        if (toolAndStatusBarMagager ==null){
            synchronized (ToolAndStatusBarMagager.class){
                if (toolAndStatusBarMagager ==null){
                    toolAndStatusBarMagager =new ToolAndStatusBarMagager();
                }
            }
        }
        return toolAndStatusBarMagager;
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
