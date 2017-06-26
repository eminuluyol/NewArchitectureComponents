package com.taurus.moviedbmvvm.core.baseadapter;

import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;
import com.taurus.moviedbmvvm.listener.OnItemClickListener;

public abstract class BaseAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder>
        extends AbsListItemAdapterDelegate<I, T, VH> {

    private OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
