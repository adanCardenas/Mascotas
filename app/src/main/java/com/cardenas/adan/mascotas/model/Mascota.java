package com.cardenas.adan.mascotas.model;

/**
 * Created by adan_ on 30/10/2016.
 */

public class Mascota {
    private int id;
    private String name;
    private int image;
    private int rating;


    public Mascota() {
    }

    public Mascota(int id, String name, int image, int rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public Mascota(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
