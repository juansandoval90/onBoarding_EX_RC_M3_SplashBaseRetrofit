package com.splashbaseretro.juansandoval.splashbaseretrofit.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.splashbaseretro.juansandoval.splashbaseretrofit.BaseApp;
import com.splashbaseretro.juansandoval.splashbaseretrofit.R;
import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListData;
import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListResponse;
import com.splashbaseretro.juansandoval.splashbaseretrofit.networking.Service;

import javax.inject.Inject;

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        HomePresenter presenter = new HomePresenter(service,this);
        presenter.getImageList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_home);
        list = (RecyclerView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getListSuccess(ImageListResponse imageListResponse) {

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), imageListResponse.getImages(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(ImageListData Item) {
                        Toast.makeText(getApplicationContext(),Item.getUrl(),Toast.LENGTH_LONG).show();
                    }
                });

        list.setAdapter(adapter);
    }
}
