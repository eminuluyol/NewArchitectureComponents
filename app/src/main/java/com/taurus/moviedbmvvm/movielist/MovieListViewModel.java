package com.taurus.moviedbmvvm.movielist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.taurus.moviedbmvvm.data.MovieRepository;
import com.taurus.moviedbmvvm.data.Resource;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;

import java.util.List;

import javax.inject.Inject;

public class MovieListViewModel extends ViewModel{

    private final LiveData<Resource<List<MovieEntity>>> popularMovies;

    @Inject
    MovieListViewModel(MovieRepository movieRepository) {
        popularMovies = movieRepository.loadPopularMovies();
    }

    LiveData<Resource<List<MovieEntity>>> getPopularMovies() {
        return popularMovies;
    }

}
