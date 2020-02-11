package com.servicenow.flicker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.servicenow.flicker.network.model.ImagesModel;
import com.servicenow.flicker.network.service.FlickrRepository;

import javax.inject.Inject;

public class PhotosListViewModel extends AndroidViewModel {

    private FlickrRepository flickrRepository;

    @Inject
    public PhotosListViewModel(@NonNull FlickrRepository flickrRepository, @NonNull Application application) {
        super(application);
        this.flickrRepository = flickrRepository;
    }

    public LiveData<ImagesModel> getPhotosListObservable(String text) {
        return flickrRepository.getPhotosList(text);
    }
}
