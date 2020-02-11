package com.servicenow.flicker.di;

import com.servicenow.flicker.viewmodel.PhotosListViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    PhotosListViewModel getPhotosListViewModel();

}
