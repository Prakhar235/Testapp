package com.pharm.smartprakhar.testapp.Model;

import com.google.gson.annotations.SerializedName;

class Data {
    @SerializedName("Version")
    String Version;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @SerializedName("Image")
    String Image;
}
