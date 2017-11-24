package com.wstatic.toolandstatusbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolStatusCollActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_status_coll);
        ButterKnife.bind(this);
        setToolBar();
        ToolAndStatusBarHelp.getInstance().setToolAndStatusBarColor(this, R.color.color_toolbar);
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        toolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.CollTitle);
        toolbarLayout.setTitle("测试二");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
