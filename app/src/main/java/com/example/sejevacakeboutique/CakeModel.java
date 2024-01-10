package com.example.sejevacakeboutique;

import java.io.Serializable;

public class CakeModel  implements Serializable {

    private  static final long serialVersionUID = 1L;
    private String name; //name of cakes
    private String price; //price of cakes
    private String rating; //rating of cakes

    private String descriptions; // description of cakes
    private String flavor; //flavor of cakes
    private int img; // cake images


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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
