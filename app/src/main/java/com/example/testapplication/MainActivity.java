package com.example.testapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;



    public static ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("kjkk");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();


    }

    private void initFragment() {
        FragmentManager ft = getSupportFragmentManager();
        FragmentTransaction fm = ft.beginTransaction();
        rightFragment rightFragment = new rightFragment();
        leftFragment leftFragment =new leftFragment();
        fragments.add(leftFragment);
        fragments.add(rightFragment);
        fm.replace(R.id.frame, fragments.get(0));
        fm.commit();
    }





    }