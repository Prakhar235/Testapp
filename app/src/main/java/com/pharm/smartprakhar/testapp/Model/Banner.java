package com.pharm.smartprakhar.testapp.Model;
import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Banner {
    @SerializedName("uitype")
    String banner_id;
    @SerializedName("logo-url")
    String logo_url;

    public Bitmap getLoadedImage() {
        return loadedImage;
    }

    public void setLoadedImage(Bitmap loadedImage) {
        this.loadedImage = loadedImage;
    }

    Bitmap loadedImage;

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public ArrayList<Banner> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(ArrayList<Banner> bannerlist) {
        this.bannerlist = bannerlist;
    }

    @SerializedName("uidata")
    ArrayList<Banner> bannerlist;
    @SerializedName("value")
    String banner_name;

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }
    @SerializedName("key")
    String key;
    @SerializedName("hint")
    String hint;
}
