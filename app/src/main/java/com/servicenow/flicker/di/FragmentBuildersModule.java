package com.servicenow.flicker.di;

import com.servicenow.flicker.view.FullViewFragment;
import com.servicenow.flicker.view.PhotosListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PhotosListFragment contributePhotosListFragment();

    @ContributesAndroidInjector
    abstract FullViewFragment contributeFullViewFragment();
}
