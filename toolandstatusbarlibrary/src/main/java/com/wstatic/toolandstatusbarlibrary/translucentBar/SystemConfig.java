package com.wstatic.toolandstatusbarlibrary.translucentBar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarMagager;

/**
 * Created by kelin on 2017/5/31.
 */

public class SystemConfig {

    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private final boolean mTranslucentStatusBar;
    private final int mStatusBarHeight;
    private final int mActionBarHeight;

    SystemConfig(Activity activity, boolean translucentStatusBar) {
        Resources res = activity.getResources();
        mStatusBarHeight = getInternalDimensionSize(res, STATUS_BAR_HEIGHT_RES_NAME);
        mActionBarHeight = getActionBarHeight(activity);
        mTranslucentStatusBar = translucentStatusBar;
    }

    @TargetApi(14)
    private int getActionBarHeight(Context context) {
        int result = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            result = ToolAndStatusBarMagager.getInstance().getToolbarHeight()==0?
                    dip2px(context,56):dip2px(context,ToolAndStatusBarMagager.getInstance().getToolbarHeight());
        }
        return result;
    }
    private   int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    private int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /**
     * Get the height of the system status bar.
     *
     * @return The height of the status bar (in pixels).
     */
    public int getStatusBarHeight() {
        return mStatusBarHeight;
    }

    /**
     * Get the height of the action bar.
     *
     * @return The height of the action bar (in pixels).
     */
    public int getActionBarHeight() {
        return mActionBarHeight;
    }

    /**
     * Get the layout inset for any system UI that appears at the top of the screen.
     *
     * @param withActionBar True to include the height of the action bar, False otherwise.
     * @return The layout inset (in pixels).
     */
    public int getPixelInsetTop(boolean withActionBar) {
        return (mTranslucentStatusBar ? mStatusBarHeight : 0) + (withActionBar ? mActionBarHeight : 0);
    }

}
