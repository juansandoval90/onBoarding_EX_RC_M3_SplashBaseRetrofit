package com.splashbaseretro.juansandoval.splashbaseretrofit.deps;


import com.splashbaseretro.juansandoval.splashbaseretrofit.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject();
}
