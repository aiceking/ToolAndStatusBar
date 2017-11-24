package com.wstatic.toolandstatusbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarHelp;

public class ToolStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_status);
        ToolAndStatusBarHelp.getInstance().setToolAndStatusBarColor(this,R.color.color_toolbar);
    }
}
