package com.splashbaseretro.juansandoval.splashbaseretrofit;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.splashbaseretro.juansandoval.splashbaseretrofit.deps.DaggerDeps;
import com.splashbaseretro.juansandoval.splashbaseretrofit.deps.Deps;
import com.splashbaseretro.juansandoval.splashbaseretrofit.networking.NetworkModule;

import java.io.File;

public class BaseApp  extends AppCompatActivity {
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
