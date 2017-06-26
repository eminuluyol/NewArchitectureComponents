package com.taurus.moviedbmvvm.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.taurus.moviedbmvvm.core.baseadapter.BaseRecyclerAdapter;
import com.taurus.moviedbmvvm.core.baseadapter.model.GenericItem;
import com.taurus.moviedbmvvm.data.Resource;

import java.util.ArrayList;
import java.util.List;

public class ListBindingAdapter {

    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        if (resource == null || resource.data == null)
            return;

        if (adapter instanceof BaseRecyclerAdapter) {

            List<GenericItem> data = new ArrayList<>((List) resource.data);
            ((BaseRecyclerAdapter) adapter).setData(data);

        }
    }

}
