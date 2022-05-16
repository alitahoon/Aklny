package com.example.aklny.objects;

import java.io.Serializable;

public class meals implements Serializable {
   private String name;
   private int img;
   private String details;
   private int rate;
   private int id ;
   private String component;

    public meals(String name, int img, String details, int rate, int id, String component) {
        this.name = name;
        this.img = img;
        this.details = details;
        this.rate = rate;
        this.id = id;
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
