package com.pharm.smartprakhar.testapp.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.pharm.smartprakhar.testapp.MainActivity;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.R;
import com.pharm.smartprakhar.testapp.Recent;
import com.pharm.smartprakhar.testapp.classes.Transientbitmapsharer;

import java.util.ArrayList;
import java.util.List;




public class Adapter_test extends RecyclerView.Adapter<Adapter_test.ViewHolder> {

   private List<Banner> list_names;
    Context context;
     FrameLayout container;
     int layoutid;
     Layout layout;
    int currentpage;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private boolean isLoadingAdded = false;


    public static class ViewHolder extends RecyclerView.ViewHolder {



        private ImageView imageView_dp;





        public ViewHolder(View itemView) {
            super(itemView);





            imageView_dp =  itemView.findViewById(R.id.profile_photo);





        }
    }

    public Adapter_test(ArrayList<Banner> list_names, Context context, FrameLayout container, int layoutid) {



       this.list_names = list_names;
       this.container = container;
       this.layoutid=layoutid;


        this.context = context;


    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layoutid, parent, false);

        return new ViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        Glide
                .with(context)
                .load(list_names.get(position).getBanner_image())
                .into(holder.imageView_dp);
        holder.imageView_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openfragment((ImageView)view);

            }
        });




    }


   @Override
    public int getItemCount() {
        return list_names.size() ;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;

    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

    }
    private  void openfragment(ImageView imageview )
    {
        Bitmap bm=((BitmapDrawable)imageview.getDrawable()).getBitmap();
        Transientbitmapsharer sharer=Transientbitmapsharer.getsharer();
        sharer.setBitmap(bm);
        Recent recent=Recent.newInstance("fragment","recent");

      FragmentManager fragmentmanager = (( MainActivity) context).getSupportFragmentManager();

        if(recent!= null) {
            fragmentmanager.beginTransaction().remove(recent).commit();
        }
      FragmentTransaction  transaction=fragmentmanager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.animation1,R.anim.animation2,R.anim.animation1,R.anim.animation2);
      transaction.add(container.getId(),recent,"recent").commit();





    }


}
