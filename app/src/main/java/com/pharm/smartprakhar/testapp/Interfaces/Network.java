package com.pharm.smartprakhar.testapp.Interfaces;

import com.pharm.smartprakhar.testapp.Model.Banner;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Network {

    @GET()
    Call<Banner> fetchCustomUI(@Url String URL);

    @GET()
    Call<ResponseBody> fetchImage(@Url String URL);



}
