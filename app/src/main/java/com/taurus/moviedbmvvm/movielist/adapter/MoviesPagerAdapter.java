package com.taurus.moviedbmvvm.movielist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.taurus.moviedbmvvm.movielist.MovieListFragment;

public class MoviesPagerAdapter extends FragmentStatePagerAdapter {

    private static final String[] titles = new String[]{"Popular", "Science", "Comedy"};

    public MoviesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return MovieListFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}