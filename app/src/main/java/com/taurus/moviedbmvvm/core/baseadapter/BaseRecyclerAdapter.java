package com.taurus.moviedbmvvm.core.baseadapter;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;
import com.taurus.moviedbmvvm.core.baseadapter.model.GenericItem;

import java.util.List;

public abstract class BaseRecyclerAdapter extends ListDelegationAdapter<List<GenericItem>> {


    public BaseRecyclerAdapter(AdapterDelegatesManager<List<GenericItem>> delegatesManager) {
        super(delegatesManager);
    }

    public abstract void setData(List<GenericItem> data);

}
