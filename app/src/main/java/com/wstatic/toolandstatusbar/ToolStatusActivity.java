package com.wstatic.toolandstatusbar;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarMagager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolStatusActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_status);
        ButterKnife.bind(this);
        setToolBar();
        ToolAndStatusBarMagager.getInstance().setToolAndStatusBarColor(this, R.color.color_toolbar);
    }
    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("测试一");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
