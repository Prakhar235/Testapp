package com.pharm.smartprakhar.testapp.classes;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.MainActivity;
import com.pharm.smartprakhar.testapp.Model.Banner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
  static   Repository obj;
  public ArrayList<Banner> bannerlist=new ArrayList<>();


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



    public  MutableLiveData<ArrayList<Banner>> Bannerextractor( final Imageviewmodel caller)
    {
   final     MutableLiveData<ArrayList<Banner>> list=new MutableLiveData<>();
        Retrofittnterface retrofitinterface = MyApp.getRetrofitInstance().create(Retrofittnterface.class);
        Call<Banner> retrofitcall = retrofitinterface.getBannerlist(MyApp.getBase_url()+"interviewandroid.php?email=interview@maishainfotech.com");
        retrofitcall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                if(response.isSuccessful())
                {
                   if(response.body().getErrormessage().isEmpty())
                   {
                       bannerlist=response.body().getBannerlist();

                       list.setValue(bannerlist);

                   }
                   else
                   {
                       new MainActivity().displayerrormessage(response.body().getErrormessage());
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
