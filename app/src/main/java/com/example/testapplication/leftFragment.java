package com.example.testapplication;


import android.graphics.Color;
import android.os.Bundle;


import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;


public class leftFragment extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{

    private LottieAnimationView animationView;
    private ListView friendsListView;
    private List<String> friendsList;
    private ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_left,container,false);
        initView();
        animationView = view.findViewById(R.id.animationView);
        friendsListView = (ListView) view.findViewById(R.id.friendsListView);
        friendsListView.setVisibility(View.GONE);
        // 创建好友列表
        friendsList = new ArrayList<>();
        friendsList.add(new String("张三"));
        friendsList.add(new String("李四"));
        friendsList.add(new String("王五"));
        // 创建 ArrayAdapter
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, friendsList);
        friendsListView.setAdapter(adapter);
        // 5秒后显示好友列表
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showFriendsList();
            }
        }, 5000);

        return view;
    }

    private void showFriendsList() {
        // 淡入淡出动画
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
        fadeInAnimation.setDuration(1000);
        // 设置 ArrayAdapter 到 ListView
        animationView.startAnimation(fadeInAnimation);
        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0);
        fadeOutAnimation.setDuration(1000);
        animationView.startAnimation(fadeOutAnimation);
        animationView.setVisibility(View.GONE);
        //先停五秒然后再次
        friendsListView.setVisibility(View.VISIBLE);
        friendsListView.startAnimation(fadeInAnimation);

    }



    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button button01,button02;


    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.viewpager01);

        list=new ArrayList<>();
        button01=(Button)view.findViewById(R.id.frag01);
        button02=(Button)view.findViewById(R.id.frag02);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);

        //这些界面要也要一个一个先去实现
        list.add(new leftFragment());
        list.add(new rightFragment());

        viewPager.setAdapter(new FragmentAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initBtnListener();
        FragmentManager ft;
        FragmentTransaction fm;
        button02.setBackgroundColor(Color.parseColor("#ff735c"));

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        System.out.println("页面置换");
        FragmentManager ft;
        FragmentTransaction fm;
        ft =this.getActivity().getSupportFragmentManager();
        fm = ft.beginTransaction();
        fm.replace(R.id.frame, MainActivity.fragments.get(1));
        viewPager.setCurrentItem(1);
        fm.commit();
    }

    @Override
    public void onClick(View v) {


    }


    private void initBtnListener(){
        button01.setBackgroundResource(R.color.white);
        button02.setBackgroundColor(Color.parseColor("#ff735c"));
    }
}