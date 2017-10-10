package com.splashbaseretro.juansandoval.splashbaseretrofit.models;


import android.media.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ImageListResponse {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    /**
     *
     * @return
     * The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }


}
