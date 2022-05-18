package com.example.aklny.objects;

public class user {
    private String username;
    private String password;
    private String location;
    private String phone;
    private int favourite;
    private int img;

    public user(String username, String password, String location, String phone, int favourite, int img) {
        this.username = username;
        this.password = password;
        this.location = location;
        this.phone = phone;
        this.favourite = favourite;
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
