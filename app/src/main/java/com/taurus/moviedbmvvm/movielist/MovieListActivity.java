package com.taurus.moviedbmvvm.movielist;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.moviedbmvvm.R;
import com.taurus.moviedbmvvm.core.BaseActivity;
import com.taurus.moviedbmvvm.core.BaseFragment;

public class MovieListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.movie_list_title);

    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return MovieListPagerFragment.newInstance();
    }

}
