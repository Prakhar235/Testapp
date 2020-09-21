package com.pharm.smartprakhar.testapp.classes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.Model.Banner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
  static   Repository obj;
  private ArrayList<Banner> bannerlist=new ArrayList<>();


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
    MutableLiveData<ArrayList<Banner>> list=new MutableLiveData<>();


    public  MutableLiveData<ArrayList<Banner>> Bannerextractor( final Imageviewmodel caller)
    {
        Retrofittnterface retrofitinterface = MyApp.getRetrofitInstance().create(Retrofittnterface.class);
        Call<ArrayList<Banner>> retrofitcall = retrofitinterface.getBannerlist(MyApp.getBase_url()+"repos/square/retrofit/commits");
       retrofitcall.enqueue(new Callback<ArrayList<Banner>>() {
           @Override
           public void onResponse(Call<ArrayList<Banner>> call, Response<ArrayList<Banner>> response) {
               if(response.isSuccessful())
               {
                   bannerlist=response.body();
                   list.setValue(bannerlist);








               }

           }

           @Override
           public void onFailure(Call<ArrayList<Banner>> call, Throwable t) {

           }
       });

        return list;




    }
}
