package com.servicenow.flicker.di;

import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.servicenow.flicker.network.service.FlickrService;
import com.servicenow.flicker.viewmodel.PhotosViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton @Provides
    FlickrService provideFlickrService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(FlickrService.HTTPS_API_FLICKR_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(FlickrService.class);
    }



    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new PhotosViewModelFactory(viewModelSubComponent.build());
    }
}
