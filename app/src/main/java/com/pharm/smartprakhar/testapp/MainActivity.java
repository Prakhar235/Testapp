package com.pharm.smartprakhar.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.pharm.smartprakhar.testapp.Adapters.Adapter_test;
import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.classes.Imageviewmodel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Imageviewmodel imagemodel;
    RecyclerView recyclerView;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagemodel= new ViewModelProvider(this).get(Imageviewmodel.class);
        imagemodel.Bannerloader();
         recyclerView =findViewById(R.id.recycler_view);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
       container= findViewById(R.id.fragmentcontainer);

        recyclerView.setLayoutManager(mLayoutManager);




        setrecyclerview(R.layout.layout_resource_demo);













     }
    Adapter_test testadapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_1:
                setrecyclerview(R.layout.layout_resource_demo);


                return true;
            case R.id.action_2:
                setrecyclerview(R.layout.layout_resource_demo2);


                return true;
            case R.id.action_3:
                setrecyclerview(R.layout.layout_resource_demo3);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




     public void setrecyclerview(final int layoutid)
     {
         imagemodel.getBannerlist().observe(this, new Observer<ArrayList<Banner>>() {
             @Override
             public void onChanged(ArrayList<Banner> banners) {

                 testadapter = new

                         Adapter_test( banners, MainActivity.this,container,layoutid);







                 recyclerView.setAdapter(testadapter);


             }
         });





     }

}
