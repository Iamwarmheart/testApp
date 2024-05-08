package com.example.testapplication;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;


public class rightFragment extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener {

    private LottieAnimationView animationView;
    private View friendsListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_right,container,false);
        initView();
        return view;
    }





    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button button01,button02;


    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.viewpager01);

        list=new ArrayList<>();
        button01=(Button)view.findViewById(R.id.frag03);
        button02=(Button)view.findViewById(R.id.frag04);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);

        //这些界面要也要一个一个先去实现
        list.add(new leftFragment());
        list.add(new rightFragment());

        viewPager.setAdapter(new FragmentAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(1);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int i) {
        initBtnListener();
        FragmentManager ft;
        FragmentTransaction fm;
        button01.setBackgroundColor(Color.parseColor("#ff735c"));


    }

    @Override
    public void onPageScrollStateChanged(int i) {
        System.out.println("页面置换");
        FragmentManager ft;
        FragmentTransaction fm;
        ft =this.getActivity().getSupportFragmentManager();
        fm = ft.beginTransaction();
        fm.replace(R.id.frame, MainActivity.fragments.get(0));
        viewPager.setCurrentItem(0);
        fm.commit();
    }

    @Override
    public void onClick(View v) {



    }


    private void initBtnListener(){
        button01.setBackgroundResource(R.color.white);
        button02.setBackgroundResource(R.color.white);
    }
}