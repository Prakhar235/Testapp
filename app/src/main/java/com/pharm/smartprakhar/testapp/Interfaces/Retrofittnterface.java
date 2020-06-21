package com.pharm.smartprakhar.testapp.Interfaces;

import com.pharm.smartprakhar.testapp.Model.Banner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Retrofittnterface {

    @POST()
    Call<Banner> getBannerlist(@Url String params);



}
