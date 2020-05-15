package com.pharm.smartprakhar.testapp.Interfaces;

import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.Model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Retrofittnterface {

    @GET()
    Call<Banner> getBannerlist(@Url String params);

    @GET()
    Call<Product> getRecentlist(@Url String params);
    @GET()
    Call<Product> getWhatsnewlist(@Url String params);



    @POST()
    Call<Product> getProductlist(@Url String params);



}
