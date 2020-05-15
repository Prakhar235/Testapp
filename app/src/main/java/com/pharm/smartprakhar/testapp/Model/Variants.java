package com.pharm.smartprakhar.testapp.Model;

import com.google.gson.annotations.SerializedName;

public class Variants {
    @SerializedName("varient_id")
    int   varient_id;
    @SerializedName("product_id")
           int   product_id;
    @SerializedName("quantity")
           int  quantity;
    @SerializedName("unit")
             String  unit;
    @SerializedName("mrp")
               int mrp;
    @SerializedName("price")
              int price;

    public int getVarient_id() {
        return varient_id;
    }

    public void setVarient_id(int varient_id) {
        this.varient_id = varient_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVarient_image() {
        return varient_image;
    }

    public void setVarient_image(String varient_image) {
        this.varient_image = varient_image;
    }

    @SerializedName("description")
             String  description;
    @SerializedName("varient_image")
            String   varient_image;

}
