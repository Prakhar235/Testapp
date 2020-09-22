package com.pharm.smartprakhar.testapp.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

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



        private TextView commit_id;
        private TextView author;
        private TextView message;





        public ViewHolder(View itemView) {
            super(itemView);





           commit_id =  itemView.findViewById(R.id.commitid);
           author =  itemView.findViewById(R.id.authorname);
           message =  itemView.findViewById(R.id.commitmessage);









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


       Log.d("Authorname",list_names.get(position).getSha());
       holder.commit_id.setText("Commit id:   "+list_names.get(position).getSha());
       holder.author.setText(list_names.get(position).getCommit().getAuthor().getName());
       holder.message.setText(list_names.get(position).getCommit().getMessage());




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



}
