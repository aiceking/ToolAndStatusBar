package com.wstatic.toolandstatusbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.wstatic.toolandstatusbar.fragment.CommonFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTestActivity extends AppCompatActivity {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.linear_parent)
    LinearLayout linearParent;
    private List<String> list_titles;
    private List<Fragment> list_fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        ButterKnife.bind(this);
        initTitleAndFragment();
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.linear_parent, list_fragments.get(tab.getPosition()));
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTitleAndFragment() {
        list_titles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list_titles.add("测试 " + (i + 1));
        }
        list_fragments = new ArrayList<>();
        for (int i = 0; i < list_titles.size(); i++) {
            tablayout.addTab(tablayout.newTab().setText(list_titles.get(i)));
            Fragment fragment;
                fragment = new CommonFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", list_titles.get(i));
            bundle.putInt("position", i);
            fragment.setArguments(bundle);
            list_fragments.add(fragment);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.linear_parent, list_fragments.get(0));
        transaction.commit();
    }


}
