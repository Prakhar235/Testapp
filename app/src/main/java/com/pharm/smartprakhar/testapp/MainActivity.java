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
    int layoutid=R.layout.layout_resource_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagemodel= new ViewModelProvider(this).get(Imageviewmodel.class);
        imagemodel.Bannerloader();
        container= findViewById(R.id.fragmentcontainer);
         recyclerView =findViewById(R.id.recycler_view);





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
                setrecyclerview(3);


                return true;
            case R.id.action_2:
                setrecyclerview(4);


                return true;
            case R.id.action_3:
                setrecyclerview(5);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




     public void setrecyclerview(final int gridcount)
     {

         GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),gridcount);
         mLayoutManager.setOrientation(RecyclerView.VERTICAL);
         testadapter = new

                 Adapter_test( imagemodel.getBannerlist().getValue(), MainActivity.this,container,layoutid);
         recyclerView.setAdapter(testadapter);



         recyclerView.setLayoutManager(mLayoutManager);
         imagemodel.getBannerlist().observe(this, new Observer<ArrayList<Banner>>() {
             @Override
             public void onChanged(ArrayList<Banner> banners) {
                 testadapter.notifyDataSetChanged();

             }
         });





     }

}
