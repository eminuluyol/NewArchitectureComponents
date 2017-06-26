package com.taurus.moviedbmvvm.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.taurus.moviedbmvvm.R;
import com.taurus.moviedbmvvm.data.remote.network.ApiConstants;

/**
 * Created by mertsimsek on 20/05/2017.
 */

public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {

        if (url != null && !url.equals(""))

            Glide.with(view.getContext())
            .load(ApiConstants.IMAGE_ENDPOINT_PREFIX + url)
                    .placeholder(R.drawable.placeholder)
                    .into(view);

    }

}
