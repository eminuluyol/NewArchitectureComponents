package com.taurus.moviedbmvvm.core.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.taurus.moviedbmvvm.data.local.Config;
import com.taurus.moviedbmvvm.data.local.MovieDb;
import com.taurus.moviedbmvvm.data.local.dao.MovieDao;
import com.taurus.moviedbmvvm.data.remote.network.ApiConstants;
import com.taurus.moviedbmvvm.data.remote.network.retrofit.MovieService;
import com.taurus.moviedbmvvm.data.remote.network.retrofit.RequestInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    MovieService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(MovieService.class);
    }

    @Provides
    @Singleton
    MovieDb provideMovieDatabase(Application application) {
        return Room.databaseBuilder(application, MovieDb.class, Config.DATABASE_NAME).build();
    }

    @Provides
    @Singleton
    MovieDao provideMovieDao(MovieDb movieDatabase) {
        return movieDatabase.movieDao();
    }

}
