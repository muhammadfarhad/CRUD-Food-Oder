package com.example.crudfoododer.Models;

import android.widget.ImageView;

public class OderModal {

    int oderItemImage;
    String oderItemName,oderItemPrice,oderItemNumber;

    public OderModal() {
        this.oderItemImage = oderItemImage;
        this.oderItemName = oderItemName;
        this.oderItemPrice = oderItemPrice;
        this.oderItemNumber = oderItemNumber;

    }

    public int getOderImage() {
        return oderItemImage;
    }

    public void setOderImage(int oderImage) {
        this.oderItemImage = oderImage;
    }

    public String getOderName() {
        return oderItemName;
    }

    public void setOderName(String oderName) {
        this.oderItemName = oderName;
    }

    public String getOderPrice() {
        return oderItemPrice;
    }

    public void setOderPrice(String oderPrice) {
        this.oderItemPrice = oderPrice;
    }

    public String getOderNumber() {
        return oderItemNumber;
    }

    public void setOderNumber(String oderNumber) {
        this.oderItemNumber = oderNumber;
    }
}
