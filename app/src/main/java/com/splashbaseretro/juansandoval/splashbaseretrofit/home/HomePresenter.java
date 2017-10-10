package com.splashbaseretro.juansandoval.splashbaseretrofit.home;


import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListResponse;
import com.splashbaseretro.juansandoval.splashbaseretrofit.networking.NetworkError;
import com.splashbaseretro.juansandoval.splashbaseretrofit.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HomePresenter {
    private final Service service;
    private final HomeView view;
    private CompositeSubscription subscriptions;

    public HomePresenter(Service service, HomeView view){
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getImageList(){
        view.showWait();

        Subscription subscription = service.getImageList(new Service.GetImageListCallback() {
            @Override
            public void onSuccess(ImageListResponse imageListResponse) {
                view.removeWait();
                view.getListSuccess(imageListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void onStop(){
        subscriptions.unsubscribe();
    }

}
