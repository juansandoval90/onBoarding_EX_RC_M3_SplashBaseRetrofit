package com.splashbaseretro.juansandoval.splashbaseretrofit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ImageListResponse {

    @SerializedName("images")
    @Expose
    private List<ImageListData> data = new ArrayList<ImageListData>();

    public List<ImageListData> getImages() {
        return data;
    }

    public void setImages(List<ImageListData> data) {
        this.data = data;
    }



}
