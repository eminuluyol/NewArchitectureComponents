package com.taurus.moviedbmvvm.core.di;

import com.taurus.moviedbmvvm.moviedetail.MovieDetailActivity;
import com.taurus.moviedbmvvm.movielist.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MovieListActivity mainActivity();

    @ContributesAndroidInjector
    abstract MovieDetailActivity movieDetailActivity();

}
