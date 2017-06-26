package com.taurus.moviedbmvvm.movielist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taurus.moviedbmvvm.R;
import com.taurus.moviedbmvvm.core.BaseFragment;
import com.taurus.moviedbmvvm.core.baseadapter.RecyclerAdapter;
import com.taurus.moviedbmvvm.data.local.entity.MovieEntity;
import com.taurus.moviedbmvvm.databinding.FragmentMovieListBinding;
import com.taurus.moviedbmvvm.moviedetail.MovieDetailActivity;
import com.taurus.moviedbmvvm.movielist.adapter.delegate.MovieListAdapterDelegate;

import javax.inject.Inject;

public class MovieListFragment extends BaseFragment implements MovieListCallback {

    @Inject
    MovieListViewModel movieListViewModel;

    FragmentMovieListBinding binding;
    RecyclerAdapter movieAdapter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMovieListBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        movieAdapter = RecyclerAdapter.with(new MovieListAdapterDelegate(this));
        binding.recyclerView.setAdapter(movieAdapter);

        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieListViewModel
                .getPopularMovies()
                .observe(this, listResource -> binding.setResource(listResource));
    }

    @Override
    public void onMovieClicked(MovieEntity movieEntity, View sharedView) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), sharedView, getString(R.string.shared_image));
        startActivity(MovieDetailActivity.newIntent(getActivity(), movieEntity.getId()), options.toBundle());
    }
}
