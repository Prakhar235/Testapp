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
import com.pharm.smartprakhar.testapp.Model.Product;
import com.pharm.smartprakhar.testapp.R;

import java.util.ArrayList;
import java.util.List;


public class Adapter_Products extends RecyclerView.Adapter<Adapter_Products.ViewHolder> {

   private List<Product> list_names;
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
        private TextView quality,quantity,price,descreption;

        private Button btn_enquire;
        private ImageButton popup, share;

        private LinearLayout exams;
        private LinearLayout subject;


        public ViewHolder(View itemView) {
            super(itemView);


            name =  itemView.findViewById(R.id.name);


            imageView_dp =  itemView.findViewById(R.id.profile_photo);

           quantity=itemView.findViewById(R.id.varientquantityvalue);
          price=itemView.findViewById(R.id.varientpricevalue);
          quality=itemView.findViewById(R.id.varientnamevalue);
          descreption=itemView.findViewById(R.id.descreption);



        }
    }
    int myresources=1;
    LinearLayoutManager mLayoutManager;
    public Adapter_Products(ArrayList<Product> list_names, Context context) {



       this.list_names = list_names;


        this.context = context;


    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_product, parent, false);

        return new ViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        try
        {
            holder.name.setText(list_names.get(position).getProduct_name());


        }
        catch(Exception e)
        {

        }

        try
        {
            Glide
                    .with(context)
                    .load(MyApp.getBase_url()+list_names.get(position).getProduct_image())
                    .into(holder.imageView_dp);



        }
        catch(Exception e)
        {

        }

        try
        {
            holder.quantity.setText(Integer.toString(list_names.get(position).getVarients().get(0).getQuantity()));

        }
        catch(Exception e)
        {

        }

        try
        {
            holder.price.setText(Integer.toString(list_names.get(position).getVarients().get(0).getPrice()));

        }
        catch(Exception e)
        {

        }

        try
        {
            holder.descreption.setText((list_names.get(position).getVarients().get(0).getDescription()));

        }
        catch(Exception e)
        {

        }











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
