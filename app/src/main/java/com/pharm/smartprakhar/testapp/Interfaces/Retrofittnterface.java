package com.pharm.smartprakhar.testapp.Interfaces;

import com.pharm.smartprakhar.testapp.Model.Banner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Retrofittnterface {

    @GET()
    Call<ArrayList<Banner>> getBannerlist(@Url String params);



}
