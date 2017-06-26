package com.taurus.moviedbmvvm.core;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends LifecycleFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);

    }

    public String getDefaultFragmentTag() {
        return this.getClass().getSimpleName();
    }

}
