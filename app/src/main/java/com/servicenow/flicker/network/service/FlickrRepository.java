package com.servicenow.flicker.network.service;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.servicenow.flicker.network.model.ImagesModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class FlickrRepository {

    private FlickrService flickrService;

    private static final String METHOD = "flickr.photos.search";
    private static final String API_KEY = "632e28242010d58e91f3ed8ae9916238";
    private static final String FORMAT = "json";
    private static final int NO_JSON_CALLBACK = 1;

    @Inject
    public FlickrRepository(FlickrService flickrService) {
        this.flickrService = flickrService;
    }

    public LiveData<ImagesModel> getPhotosList(String text) {
        final MutableLiveData<ImagesModel> data = new MutableLiveData<>();

        flickrService.getPhotosList(METHOD, API_KEY, FORMAT, NO_JSON_CALLBACK, text).enqueue(new Callback<ImagesModel>() {

            @Override
            public void onResponse(Call<ImagesModel> call, Response<ImagesModel> response) {
                Log.e("SN","url "+call.request().url());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ImagesModel> call, Throwable t) {
                Log.e("SN","url = "+call.request().url());
                data.setValue(null);
            }
        });

        return data;
    }
}
