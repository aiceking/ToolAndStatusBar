package com.wstatic.toolandstatusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarHelp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusColorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_status_textcolor_black)
    Button btnStatusTextcolorBlack;
    @BindView(R.id.btn_status_textcolor_white)
    Button btnStatusTextcolorWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_color);
        ButterKnife.bind(this);
        setToolBar();
        ToolAndStatusBarHelp.getInstance().setStatusBarColor(this, R.color.color_statusbar);
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

    @OnClick({R.id.btn_status_textcolor_black, R.id.btn_status_textcolor_white})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_status_textcolor_black:
                ToolAndStatusBarHelp.getInstance().setStatusBarColor(this, R.color.color_statusbar,true);
                break;
            case R.id.btn_status_textcolor_white:
                ToolAndStatusBarHelp.getInstance().setStatusBarColor(this, R.color.color_statusbar,false);
                break;
        }
    }
}
