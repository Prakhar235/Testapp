package com.pharm.smartprakhar.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.pharm.smartprakhar.testapp.Adapters.Adapter_Pager;
import com.pharm.smartprakhar.testapp.Adapters.Adapter_test;
import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.classes.SlidingTabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bannerextractor();
       ViewPager vpPager =  findViewById(R.id.vpPager);



      Adapter_Pager adapter_pager = new Adapter_Pager(((AppCompatActivity)this).getSupportFragmentManager(),getApplicationContext());
    SlidingTabLayout tabLayout =  findViewById(R.id.sliding_tabs);

        tabLayout.setDistributeEvenly(true);
        vpPager.setAdapter(adapter_pager);
        vpPager.setOffscreenPageLimit(0);
        tabLayout.setViewPager(vpPager);


    }
     private void Bannerextractor()
    {
        Retrofittnterface retrofitinterface = MyApp.getRetrofitInstance().create(Retrofittnterface.class);
        Call<Banner> retrofitcall = retrofitinterface.getBannerlist(MyApp.getBase_url()+"api/"+"banner");
        retrofitcall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                if(response.isSuccessful())
                {

             Adapter_test testadapter = new

                     Adapter_test( response.body().getBannerlist(), getApplicationContext());
               RecyclerView recyclerView =findViewById(R.id.recycler_view);

                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(testadapter);

                }

            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });




    }
}
