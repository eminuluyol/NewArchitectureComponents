package com.taurus.moviedbmvvm.movielist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taurus.moviedbmvvm.core.BaseFragment;
import com.taurus.moviedbmvvm.databinding.FragmentMovieListPagerBinding;
import com.taurus.moviedbmvvm.movielist.adapter.MoviesPagerAdapter;

public class MovieListPagerFragment extends BaseFragment {

    FragmentMovieListPagerBinding binding;

    public static MovieListPagerFragment newInstance() {
        return new MovieListPagerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMovieListPagerBinding.inflate(inflater, container, false);
        binding.viewPager.setAdapter(new MoviesPagerAdapter(getChildFragmentManager()));
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(3);

        return binding.getRoot();

    }

}
