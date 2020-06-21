package com.pharm.smartprakhar.testapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class BData {

    @SerializedName("Model")
   String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Data> getDatalist() {
        return datalist;
    }

    public void setDatalist(ArrayList<Data> datalist) {
        this.datalist = datalist;
    }

    @SerializedName("Data")
    ArrayList<Data> datalist;
}
