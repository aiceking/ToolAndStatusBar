package com.wstatic.toolandstatusbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarMagager;

public class StatusTransparentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_transparent);
        ToolAndStatusBarMagager.getInstance().setStatusBarTransparent(this);
    }
}
