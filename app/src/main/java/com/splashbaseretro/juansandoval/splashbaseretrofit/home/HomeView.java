package com.splashbaseretro.juansandoval.splashbaseretrofit.home;


import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListResponse;

public interface HomeView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getListSuccess(ImageListResponse imageListResponse);


}
