package com.taurus.moviedbmvvm.core.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.taurus.moviedbmvvm.core.viewmodel.MovieViewModelFactory;
import com.taurus.moviedbmvvm.moviedetail.MovieDetailViewModel;
import com.taurus.moviedbmvvm.movielist.MovieListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    abstract ViewModel bindsMovieListViewModel(MovieListViewModel movieListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(MovieViewModelFactory movieViewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel.class)
    abstract  ViewModel bindsMovieDetailViewModel(MovieDetailViewModel movieDetailViewModel);
}
