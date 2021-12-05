package com.pharm.smartprakhar.testapp.classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.MutableLiveData;

import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Network;
import com.pharm.smartprakhar.testapp.Model.Banner;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
  static   Repository obj;
  private Banner bannerlist;


   private Repository() {
    }
    static  Repository getRepository()
    {
        if(obj==null)
        {
            obj=new Repository();

        }
        return obj;
    }
    MutableLiveData<Banner> list=new MutableLiveData<>();
    Bitmap bitmap=null;

    public  Bitmap imageLoader(String URL, final Banner body)
    {

        Network retrofitinterface = MyApp.getRetrofitInstance().create(Network.class);
        Call<ResponseBody> retrofitcall = retrofitinterface.fetchImage(URL);
        retrofitcall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    try {
                        byte[] bytes =  response.body().bytes();
                        bitmap=BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        body.setLoadedImage(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


        return bitmap;




    }


    public  MutableLiveData<Banner> Bannerextractor( final Imageviewmodel caller)
    {
        Network retrofitinterface = MyApp.getRetrofitInstance().create(Network.class);
        Call<Banner> retrofitcall = retrofitinterface.fetchCustomUI("https://demo.ezetap.com/mobileapps/android_assignment.json");
        retrofitcall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                if(response.isSuccessful())
                {
                    bannerlist=response.body();
                    list.setValue(bannerlist);
                    if (response.body() != null && response.body().getLogo_url()!=null) {
                       imageLoader(response.body().getLogo_url(),response.body());

                    }


                }

            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });

        return list;




    }
}
