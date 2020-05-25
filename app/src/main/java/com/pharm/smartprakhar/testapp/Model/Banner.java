package com.pharm.smartprakhar.testapp.Model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Banner {
    @SerializedName("position")
    int banner_id;

    public ArrayList<Banner> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(ArrayList<Banner> bannerlist) {
        this.bannerlist = bannerlist;
    }

    @SerializedName("images_results")
    ArrayList<Banner> bannerlist;
    @SerializedName("title")
    String banner_name;

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }
    @SerializedName("original")
    String banner_image;
}
