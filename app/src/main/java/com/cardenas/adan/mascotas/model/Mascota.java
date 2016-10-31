package com.cardenas.adan.mascotas.model;

/**
 * Created by adan_ on 30/10/2016.
 */

public class Mascota {
    private String id;
    private String name;
    private int image;
    private String rating;

    public Mascota(String id, String name, int image, String rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public Mascota(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
