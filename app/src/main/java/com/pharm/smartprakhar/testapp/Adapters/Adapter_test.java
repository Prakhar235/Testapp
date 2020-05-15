package com.pharm.smartprakhar.testapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.R;

import java.util.ArrayList;
import java.util.List;




public class Adapter_test extends RecyclerView.Adapter<Adapter_test.ViewHolder> {

   private List<Banner> list_names;
    Context context;
    int currentpage;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private boolean isLoadingAdded = false;


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView sname;
        private TextView sheadline;
        private ImageView button_connect;
        private ImageView imageView_dp,btn_icon;
        ImageView sremove;
        RatingBar rate;
        private Button btn_tag;
        private TextView name, rating, review_text,ownername;
        private TextView fee;

        private Button btn_enquire;
        private ImageButton popup, share;

        private LinearLayout exams;
        private LinearLayout subject;


        public ViewHolder(View itemView) {
            super(itemView);


            name =  itemView.findViewById(R.id.name);


            imageView_dp =  itemView.findViewById(R.id.profile_photo);

            share = itemView.findViewById(R.id.btn_share);
            popup = itemView.findViewById(R.id.imgbutton_popup);
            exams=itemView.findViewById(R.id.exam_layout);


            subject=itemView.findViewById(R.id.sub_layout);




        }
    }
    int myresources=1;
    LinearLayoutManager mLayoutManager;
    public Adapter_test(ArrayList<Banner> list_names,Context context) {



       this.list_names = list_names;


        this.context = context;


    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_resource_demo, parent, false);

        return new ViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       holder.name.setText(list_names.get(position).getBanner_name());
        Glide
                .with(context)
                .load(MyApp.getBase_url()+list_names.get(position).getBanner_image())
                .into(holder.imageView_dp);




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
