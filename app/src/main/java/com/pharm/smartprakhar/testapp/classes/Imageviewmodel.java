package com.pharm.smartprakhar.testapp.classes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pharm.smartprakhar.testapp.MainActivity;
import com.pharm.smartprakhar.testapp.Model.Banner;

import java.util.ArrayList;
import java.util.List;

public class Imageviewmodel extends ViewModel {
   Repository repo;



    public LiveData<ArrayList<Banner>> getBannerlist() {

        return bannerlist;
    }
    public void Bannerloader()
    {
        if(bannerlist==null)
        {
            bannerlist=new MutableLiveData<>();
            repo=Repository.getRepository();
        bannerlist=    repo.Bannerextractor(this);

        }



    }




    public MutableLiveData<ArrayList<Banner>> bannerlist;
}
