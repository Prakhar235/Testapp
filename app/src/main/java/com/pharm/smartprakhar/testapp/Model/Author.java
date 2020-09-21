package com.pharm.smartprakhar.testapp.Model;

import java.io.Serializable;

public class Author implements Serializable {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
