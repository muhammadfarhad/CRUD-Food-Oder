package com.example.crudfoododer.Models;

public class MainModel {
    int Image;
    String name,price,description;

    public MainModel(int image, String name, String price, String description) {
        Image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
