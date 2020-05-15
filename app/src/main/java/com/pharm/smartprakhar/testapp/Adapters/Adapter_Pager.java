package com.pharm.smartprakhar.testapp.Adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pharm.smartprakhar.testapp.Popular;
import com.pharm.smartprakhar.testapp.Recent;
import com.pharm.smartprakhar.testapp.WhatsNew;

public class Adapter_Pager extends FragmentStatePagerAdapter {



    Context context;

    public Adapter_Pager(FragmentManager fragmentManager,Context context) {
        super(fragmentManager);

        this.context = context;



    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();


        switch (position) {

            case 0:
               Popular popular = new Popular();
                popular.setArguments(bundle);
                return popular;
            case 1:
                Recent recent = new Recent();
                recent.setArguments(bundle);
                return recent;

            case 2:
               WhatsNew whatsnew = new WhatsNew();
                whatsnew.setArguments(bundle);
                return whatsnew;




            default:
                Popular defaultfragment = new Popular();
                defaultfragment.setArguments(bundle);
                return defaultfragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
         switch (position) {
            case 0:
                return "Popular";
            case 1:
                return "Recent";
            case 2:
                return "Whats New";
            default:
                return "Popular";
        }




    }
}
