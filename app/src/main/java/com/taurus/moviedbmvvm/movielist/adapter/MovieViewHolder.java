package com.taurus.moviedbmvvm.movielist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.databinding.ItemMovieListBinding;
import com.taurus.moviedbmvvm.listener.OnItemClickListener;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener listener;
    private ItemMovieListBinding binding;

    public static MovieViewHolder create (LayoutInflater inflater, ViewGroup parent, OnItemClickListener callback) {
        ItemMovieListBinding itemMovieListBinding = ItemMovieListBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(itemMovieListBinding, callback);
    }

    public MovieViewHolder(@NonNull ItemMovieListBinding binding, OnItemClickListener listener) {
        super(binding.getRoot());

        this.listener = listener;
        this.binding = binding;

    }

    public void onBind(MovieEntity movieEntity) {
        binding.setMovie(movieEntity);
        binding.executePendingBindings();
    }

}
