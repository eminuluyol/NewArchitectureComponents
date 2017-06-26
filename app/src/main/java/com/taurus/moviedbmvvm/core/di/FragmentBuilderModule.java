package com.taurus.moviedbmvvm.core.di;

import com.taurus.moviedbmvvm.movielist.MovieListFragment;
import com.taurus.moviedbmvvm.movielist.MovieListPagerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();

    @ContributesAndroidInjector
    abstract MovieListPagerFragment contributeMovieListPagerFragment();
}
