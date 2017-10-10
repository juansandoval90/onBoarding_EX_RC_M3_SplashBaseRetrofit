package com.splashbaseretro.juansandoval.splashbaseretrofit.networking;


import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListResponse;

import rx.Observable;

import retrofit2.http.GET;

public interface NetworkService {

    @GET("api/v1/images/latest")
    Observable<ImageListResponse>getImageList();

}
