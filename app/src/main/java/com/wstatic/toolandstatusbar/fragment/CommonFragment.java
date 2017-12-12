package com.wstatic.toolandstatusbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wstatic.toolandstatusbar.R;
import com.wstatic.toolandstatusbarlibrary.ToolAndStatusBarMagager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by static on 2017/11/25/025.
 */

public class CommonFragment extends Fragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private View rootView;
    private String title;
    private int position;
    private int []Colors={R.color.color_one,
            R.color.color_two,
            R.color.color_three,
            R.color.color_four,};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_common_bar, container, false);
            ButterKnife.bind(this, rootView);
            title = getArguments().getString("title");
            position = getArguments().getInt("position");
        }
        ToolAndStatusBarMagager.getInstance().setToolAndStatusBarColor(this, rootView, Colors[position]);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolBar();
    }

    private void setToolBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).setTitle(title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }


}
