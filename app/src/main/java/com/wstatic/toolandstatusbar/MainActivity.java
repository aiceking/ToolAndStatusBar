package com.wstatic.toolandstatusbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_tool_status)
    Button btnToolStatus;
    @BindView(R.id.btn_tool_status_Coll)
    Button btnToolStatusColl;
    @BindView(R.id.btn_tool_status_different)
    Button btnToolStatusDifferent;
    @BindView(R.id.btn_status_Transparent)
    Button btnStatusTransparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_tool_status, R.id.btn_tool_status_Coll, R.id.btn_tool_status_different, R.id.btn_status_Transparent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_tool_status:
                startActivity(new Intent(this,ToolStatusActivity.class));
                break;
            case R.id.btn_tool_status_Coll:
                startActivity(new Intent(this,ToolStatusCollActivity.class));
                break;
            case R.id.btn_tool_status_different:
                startActivity(new Intent(this,StatusColorActivity.class));
                break;
            case R.id.btn_status_Transparent:
                startActivity(new Intent(this,StatusTransparentActivity.class));
                break;
        }
    }
}
