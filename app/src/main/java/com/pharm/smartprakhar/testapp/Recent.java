package com.pharm.smartprakhar.testapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharm.smartprakhar.testapp.Adapters.Adapter_Products;
import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.Model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Recent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Recent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Recent.
     */
    // TODO: Rename and change types and number of parameters
    public static Recent newInstance(String param1, String param2) {
        Recent fragment = new Recent();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recent, container, false);
        Productsetter(view);
        return view;

    }

    private void Productsetter(final View view)
    {
        Retrofittnterface retrofitinterface = MyApp.getRetrofitInstance().create(Retrofittnterface.class);
        Call<Product> retrofitcall = retrofitinterface.getRecentlist(MyApp.getBase_url()+"api/"+"recentselling");
        retrofitcall.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(response.isSuccessful())
                {
                    Adapter_Products Productadapter = new

                            Adapter_Products( response.body().getProductlist(), getContext());
                    RecyclerView recyclerView =view.findViewById(R.id.recycler_view);

                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                    mLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(Productadapter);

                }

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });

    }
}
