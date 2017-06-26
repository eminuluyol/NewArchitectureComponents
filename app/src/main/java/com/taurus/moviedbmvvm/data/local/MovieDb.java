package com.taurus.moviedbmvvm.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.data.local.dao.MovieDao;

@Database(entities = MovieEntity.class, version = 1)
public abstract class MovieDb extends RoomDatabase{

    public abstract MovieDao movieDao();

}
