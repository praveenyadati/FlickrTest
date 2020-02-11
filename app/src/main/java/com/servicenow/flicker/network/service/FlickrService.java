package com.servicenow.flicker.network.service;

import com.servicenow.flicker.network.model.ImagesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {
    String HTTPS_API_FLICKR_URL = "https://api.flickr.com/";

    @GET("services/rest/")
    Call<ImagesModel> getPhotosList(@Query("method") String method, @Query("api_key") String apiKey, @Query("format") String format, @Query("nojsoncallback") int nojsoncallback, @Query("text") String text);
}