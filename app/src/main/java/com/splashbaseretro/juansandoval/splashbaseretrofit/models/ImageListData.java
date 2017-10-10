package com.splashbaseretro.juansandoval.splashbaseretrofit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageListData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("large_url")
    @Expose
    private String largeUrl;
    @SerializedName("source_id")
    @Expose
    private Object sourceId;


    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }
    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The id
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     *
     * @return
     * The LargeUrl
     */
    public String getLargeUrl() {
        return largeUrl;
    }

    /**
     *
     * @param largeUrl
     * The id
     */
    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    /**
     *
     * @return
     * The SourceId
     */
    public Object getSourceId() {
        return sourceId;
    }

    /**
     *
     * @param sourceId
     * The id
     */
    public void setSourceId(Object sourceId) {
        this.sourceId = sourceId;
    }

}
