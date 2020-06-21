package com.pharm.smartprakhar.testapp.Common;

import android.app.Application;
import android.content.Context;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by poojanrathod on 6/29/17.
 */

public class MyApp extends Application {
    private static  String base_url ="http://www.maishainfotech.com/adinterview/";

    public static String getBase_url() {
        return base_url;
    }

    public static void setBase_url(String base_url) {
        MyApp.base_url = base_url;
    }

    private static Retrofit retrofit;
    private static final String STAGE_URL = "";




    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    private static String getURL(){
        return STAGE_URL;
    }

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(getBase_url())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }




}


