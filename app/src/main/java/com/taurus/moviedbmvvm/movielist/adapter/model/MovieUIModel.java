package com.taurus.moviedbmvvm.movielist.adapter.model;

import com.taurus.moviedbmvvm.core.baseadapter.model.GenericItem;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.util.ListConverter;

import java.util.List;

public class MovieUIModel extends GenericItem {

    private int id;
    private String posterPath;
    private boolean adult;
    private String overview;
    private String originalTitle;
    private String title;
    private int voteCount;
    private double voteAverage;
    private String backdropPath;
    private String originalLanguage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public static List<MovieUIModel> createList(List<MovieEntity> placeMarkers) {
        return ListConverter.convert(placeMarkers, item -> create(item));
    }

    private static MovieUIModel create(MovieEntity item) {

        final MovieUIModel model = new MovieUIModel();

        model.setId(item.getId());
        model.setPosterPath(item.getPosterPath());
        model.setAdult(item.isAdult());
        model.setOverview(item.getOverview());
        model.setOriginalTitle(item.getOriginalTitle());
        model.setTitle(item.getTitle());
        model.setVoteCount(item.getVoteCount());
        model.setVoteAverage(item.getVoteAverage());
        model.setBackdropPath(item.getBackdropPath());
        model.setOriginalLanguage(item.getOriginalLanguage());

        return model;
    }

}
