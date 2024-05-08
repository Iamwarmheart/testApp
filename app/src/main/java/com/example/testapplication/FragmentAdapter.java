package com.example.testapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author ironjam
 * @version 1.0
 * @project TestApplication
 * @description
 * @date 2024/5/7 12:56:33
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }



    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}