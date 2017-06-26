package com.taurus.moviedbmvvm.data.remote.network.retrofit;

import com.taurus.moviedbmvvm.data.remote.network.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies();

}
