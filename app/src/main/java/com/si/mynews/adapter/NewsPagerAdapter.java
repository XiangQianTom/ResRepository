package com.si.mynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.si.mynews.fragment.NewsPagerFragment;

import java.util.List;


/**
 * Created by si on 16/11/28.
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter {

    private List<NewsPagerFragment> fragments;

    public NewsPagerAdapter(FragmentManager fm, List<NewsPagerFragment> fragments) {
        super(fm);
        this.fragments = fragments;
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
