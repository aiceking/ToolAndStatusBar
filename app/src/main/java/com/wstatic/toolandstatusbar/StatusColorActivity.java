package com.wstatic.toolandstatusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatusColorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_color);
        ButterKnife.bind(this);
        setToolBar();
        ToolAndStatusBarHelp.getInstance().setStatusBarColor(this,R.color.color_statusbar);
    }
    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("测试三");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setBackgroundColor(getResources().getColor(R.color.color_toolbar));
    }
}
