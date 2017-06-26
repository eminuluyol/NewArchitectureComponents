package com.taurus.moviedbmvvm.moviedetail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.taurus.moviedbmvvm.data.MovieRepository;
import com.taurus.moviedbmvvm.data.Resource;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;

import javax.inject.Inject;

public class MovieDetailViewModel extends ViewModel {

    private final LiveData<Resource<MovieEntity>>  movieDetail = new MutableLiveData<>();
    private final MovieRepository movieRepository;

    @Inject
    public MovieDetailViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<MovieEntity> getMovie(int id){
        return movieRepository.getMovie(id);
    }

}


