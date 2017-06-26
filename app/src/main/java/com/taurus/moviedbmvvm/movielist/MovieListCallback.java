
package com.taurus.moviedbmvvm.movielist;

import android.view.View;

import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;



public interface MovieListCallback {
    void onMovieClicked(MovieEntity movieEntity, View sharedView);
}
