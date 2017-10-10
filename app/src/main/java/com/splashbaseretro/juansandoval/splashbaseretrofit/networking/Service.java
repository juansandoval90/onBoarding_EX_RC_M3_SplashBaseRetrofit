package com.splashbaseretro.juansandoval.splashbaseretrofit.networking;


import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getImageList(final GetImageListCallback callback){
        return networkService.getImageList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ImageListResponse>>() {
                    @Override
                    public Observable<? extends ImageListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ImageListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ImageListResponse imageListResponse) {

                    }
                });
    }

    public interface GetImageListCallback{
        void onSuccess(ImageListResponse imageListResponse);

        void onError(NetworkError networkError);
    }
}