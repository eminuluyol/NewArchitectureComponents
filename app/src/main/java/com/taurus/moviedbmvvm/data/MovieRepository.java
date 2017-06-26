package com.taurus.moviedbmvvm.data;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.taurus.moviedbmvvm.data.local.dao.MovieDao;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.data.remote.network.model.MoviesResponse;
import com.taurus.moviedbmvvm.data.remote.network.retrofit.MovieService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class MovieRepository {

    private MovieDao movieDao;
    private MovieService movieService;

    @Inject
    MovieRepository(MovieDao movieDao, MovieService movieService) {
        this.movieDao = movieDao;
        this.movieService = movieService;
    }

    public LiveData<Resource<List<MovieEntity>>> loadPopularMovies() {
        return new NetworkBoundResource<List<MovieEntity>, MoviesResponse>() {

            @Override
            protected void saveCallResult(@NonNull MoviesResponse item) {
                for(MovieEntity movie : item.getResults()) {
                    movieDao.insert(movie);
                }
            }

            @NonNull
            @Override
            protected LiveData<List<MovieEntity>> loadFromDb() {
                return movieDao.loadMovies();
            }

            @NonNull
            @Override
            protected Call<MoviesResponse> createCall() {
                return movieService.getPopularMovies();
            }

        }.getAsLiveData();
    }

    public LiveData<MovieEntity> getMovie(int id){
        return movieDao.getMovie(id);
    }
}
