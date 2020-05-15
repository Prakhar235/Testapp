package com.pharm.smartprakhar.testapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product {
    @SerializedName("product_id")
String   product_id;

    @SerializedName("varients")
   ArrayList<Variants>   varients;

    public ArrayList<Variants> getVarients() {
        return varients;
    }

    public void setVarients(ArrayList<Variants> varients) {
        this.varients = varients;
    }

    public ArrayList<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(ArrayList<Product> productlist) {
        this.productlist = productlist;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @SerializedName("data")
    ArrayList<Product> productlist;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @SerializedName("product_name")
    String    product_name;
    @SerializedName("product_image")
       String    product_image;
}
