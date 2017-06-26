package com.taurus.moviedbmvvm.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.taurus.moviedbmvvm.R;
import com.taurus.moviedbmvvm.databinding.ActivityBaseBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private ActivityBaseBinding binding;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;

    private boolean homeAsUpEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        binding = putContentView(getLayoutResId());

        setSupportActionBar(binding.toolbarContainer.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) {

            final BaseFragment fragment = getContainedFragment();

            if (fragment != null) {
                addFragment(fragment).commit();
            }
        }

    }

    protected <T extends ViewDataBinding> T putContentView(@LayoutRes int resId) {
        return DataBindingUtil.setContentView(this, resId);
    }

    /**
     * Start fragment transaction and add a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>addFragment(fragment).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction addFragment(BaseFragment fragment) {
        return addFragment(fragment, fragment.getDefaultFragmentTag());
    }

    /**
     * Start fragment transaction and add a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>addFragment(fragment, tag).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @param tag      fragment tag
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction addFragment(BaseFragment fragment, String tag) {
        return getSupportFragmentManager().beginTransaction()
                .add(getContainerLayoutId(), fragment, tag);
    }

    /**
     * Start fragment transaction and replace a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>replaceFragment(fragment).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction replaceFragment(BaseFragment fragment) {
        return replaceFragment(fragment, fragment.getDefaultFragmentTag());
    }

    /**
     * Start fragment transaction and replace a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>replaceFragment(fragment, tag).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @param tag      fragment tag
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction replaceFragment(BaseFragment fragment, String tag) {
        return getSupportFragmentManager().beginTransaction()
                .replace(getContainerLayoutId(), fragment, tag);
    }

    /**
     * Find fragment by tag.
     *
     * @param tag fragment tag
     * @return fragment instance
     */
    protected Fragment findFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    /**
     * Get container layout id.
     * <p>
     * It will be used for adding fragment automatically. {@see BaseActivity#getContainedFragment()}.
     * Override this if you create different layout for child activity.
     *
     * @return container layout id
     */
    @IdRes
    protected int getContainerLayoutId() {
        return R.id.container;
    }

    /**
     * Get layout resource id of activity.
     * <p>
     * It is activity_base.xml by default. Override this to change layout.
     *
     * @return layout resource id
     */
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_base;
    }

    /**
     * Get root view of activity layout.
     *
     * @return root view
     */
    public View getRootView() {
        return binding.root;
    }

    /**
     * Specify contained fragment.
     *
     * @return contained fragment
     */
    @Nullable
    protected abstract BaseFragment getContainedFragment();

    /**
     * Set toolbar title
     *
     * @param title string will be used for setting the toolbar title
     */
    @Override
    public void setTitle(CharSequence title) {
        binding.toolbarContainer.toolbarTitle.setText(title);
    }

    /**
     * Set toolbar title
     *
     * @param titleId string resource id will be used for setting the toolbar title
     */
    @Override
    public void setTitle(@StringRes int titleId) {
        binding.toolbarContainer.toolbarTitle.setText(titleId);
    }

    /**
     * Set home as up enabled
     *
     * @param enabled if true home as up button will be visible on toolbar
     */
    protected void setHomeAsUpEnabled(boolean enabled) {
        homeAsUpEnabled = enabled;
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }

    @CallSuper
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            navigateUp();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (!getSupportFragmentManager().popBackStackImmediate()) {
            if (homeAsUpEnabled) {
                navigateUp();
            } else {
                finish();
            }
        }

    }

    private void navigateUp() {
        NavUtils.navigateUpFromSameTask(this);
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    /**
     * Make statusbar transparent
     * <p>
     *This method makes statusbar transparent. DO NOT forget to add fitSystemTrue in your XML layout
     */
    protected void makeStatusBarTransparent() {

        Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
        }

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }
}
