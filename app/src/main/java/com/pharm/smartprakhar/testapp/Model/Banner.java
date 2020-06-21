package com.pharm.smartprakhar.testapp.Model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Banner {

    @SerializedName("BData")
    ArrayList<BData> bdatalist;



    public ArrayList<BData> getBdatalist() {
        return bdatalist;
    }

    public void setBdatalist(ArrayList<BData> bdatalist) {
        this.bdatalist = bdatalist;
    }

    public ArrayList<Banner> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(ArrayList<Banner> bannerlist) {
        this.bannerlist = bannerlist;
    }

    @SerializedName("Categories")
    ArrayList<Banner> bannerlist;
    @SerializedName("errormessage")
   String errormessage="";

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    @SerializedName("Brand")
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


    @SerializedName("Image")
    String banner_image;
}
