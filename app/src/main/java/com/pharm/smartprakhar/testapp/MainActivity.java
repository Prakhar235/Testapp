package com.pharm.smartprakhar.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pharm.smartprakhar.testapp.Adapters.Adapter_test;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.classes.Imageviewmodel;

public class MainActivity extends AppCompatActivity {
    Imageviewmodel imagemodel;
    RecyclerView recyclerView;
    FrameLayout container;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagemodel= new ViewModelProvider(this).get(Imageviewmodel.class);
        imagemodel.Bannerloader();
         recyclerView =findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
       container= findViewById(R.id.fragmentcontainer);
       imageView=findViewById(R.id.imageView);

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




     public void setrecyclerview(final int layoutid)
     {
         imagemodel.getBanner().observe(this, new Observer<Banner>() {
             @Override
             public void onChanged(Banner banner) {
                imageView.setImageBitmap(banner.getLoadedImage());
                 testadapter = new

                         Adapter_test( banner.getBannerlist(), MainActivity.this,container,layoutid);
                 recyclerView.setAdapter(testadapter);

             }

         });





     }

}
