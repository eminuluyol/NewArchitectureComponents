package com.taurus.moviedbmvvm.movielist.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.taurus.moviedbmvvm.core.baseadapter.BaseAdapterDelegate;
import com.taurus.moviedbmvvm.core.baseadapter.model.GenericItem;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.listener.OnItemClickListener;
import com.taurus.moviedbmvvm.movielist.adapter.viewholder.MovieViewHolder;

import java.util.List;

public class MovieListAdapterDelegate extends BaseAdapterDelegate<MovieEntity, GenericItem, MovieViewHolder> {

    public MovieListAdapterDelegate(OnItemClickListener listener) {
        setOnItemClickListener(listener);
    }

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof  MovieEntity;
    }

    @NonNull
    @Override
    protected MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return MovieViewHolder.create(LayoutInflater.from(parent.getContext()), parent, getOnItemClickListener());
    }

    @Override
    protected void onBindViewHolder(@NonNull MovieEntity item, @NonNull MovieViewHolder viewHolder, @NonNull List<Object> payloads) {
        viewHolder.onBind(item);
    }

}
