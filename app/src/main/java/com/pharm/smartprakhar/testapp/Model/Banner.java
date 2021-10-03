package com.pharm.smartprakhar.testapp.Model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Banner {
    @SerializedName("status")
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


    @SerializedName("message")
    String banner_image;
}
