package com.cardenas.adan.mascotas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by adan_ on 05/11/2016.
 */

public class MascotaPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MascotaPageAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
