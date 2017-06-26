package com.taurus.moviedbmvvm.movielist.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.databinding.ItemMovieListBinding;
import com.taurus.moviedbmvvm.movielist.MovieListCallback;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private MovieListCallback listener;
    private ItemMovieListBinding binding;
    private MovieEntity movieEntity;

    public static MovieViewHolder create (LayoutInflater inflater, ViewGroup parent, MovieListCallback callback) {
        ItemMovieListBinding itemMovieListBinding = ItemMovieListBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(itemMovieListBinding, callback);
    }

    public MovieViewHolder(@NonNull ItemMovieListBinding binding, MovieListCallback listener) {
        super(binding.getRoot());

        this.listener = listener;
        this.binding = binding;
        binding.getRoot().setOnClickListener(v ->
                listener.onMovieClicked(binding.getMovie(), binding.imageViewCover));

    }

    public void onBind(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
        binding.setMovie(movieEntity);
        binding.executePendingBindings();
    }

}
