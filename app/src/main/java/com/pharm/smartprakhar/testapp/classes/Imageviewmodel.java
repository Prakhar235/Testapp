package com.pharm.smartprakhar.testapp.classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pharm.smartprakhar.testapp.Model.Banner;

public class Imageviewmodel extends ViewModel {
   Repository repo;



    public LiveData<Banner> getBanner() {

        return banner;
    }
    public void Bannerloader()
    {
        if(banner ==null)
        {
            banner =new MutableLiveData<>();
            repo=Repository.getRepository();
        banner =    repo.Bannerextractor(this);

        }



    }




    public MutableLiveData<Banner> banner;
}
