package com.taurus.moviedbmvvm.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.taurus.moviedbmvvm.data.local.Config;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM " + Config.MOVIE_TABLE_NAME)
    LiveData<List<MovieEntity>> loadMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieEntity movieEntities);

    @Query("SELECT * FROM movies WHERE id=:id")
    LiveData<MovieEntity> getMovie(int id);

    @Query("DELETE FROM " + Config.MOVIE_TABLE_NAME)
    void deleteAll();

}
