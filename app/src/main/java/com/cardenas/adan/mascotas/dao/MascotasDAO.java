package com.cardenas.adan.mascotas.dao;

import com.cardenas.adan.mascotas.model.Mascota;

import java.util.ArrayList;
import java.util.List;

import com.cardenas.adan.mascotas.R;

/**
 * Created by adan_ on 30/10/2016.
 */

public class MascotasDAO {
    private List<Mascota> mascotas=new ArrayList<>();

    public List<Mascota> inicializaMascotas(){
        List<Mascota> mascotas=new ArrayList<>();
        mascotas.add(new Mascota("01","Tom", R.drawable.tom,"7"));
        mascotas.add(new Mascota("02","Peppy", R.drawable.peppy,"7"));
        mascotas.add(new Mascota("03","Rafus", R.drawable.catty,"6"));
        mascotas.add(new Mascota("04","Foxy", R.drawable.foxy,"5"));
        mascotas.add(new Mascota("05","Ratata", R.drawable.raty,"2"));
        return mascotas;
    }

    public List<Mascota> perfilMascota(){
        mascotas.add(new Mascota("01","Tom", R.drawable.tom1,"10"));
        mascotas.add(new Mascota("011","Tom", R.drawable.tom2,"9"));
        mascotas.add(new Mascota("012","Tom", R.drawable.tom3,"8"));
        mascotas.add(new Mascota("013","Tom", R.drawable.tom4,"7"));
        mascotas.add(new Mascota("014","Tom", R.drawable.tom5,"6"));
        return  mascotas;
    }

    public List<Mascota> mascotasFavoritas(){
        mascotas=inicializaMascotas();
        if(!mascotas.isEmpty()){
            mascotas.get(0).setRating("12");
            mascotas.get(1).setRating("11");
        }
        return mascotas;
    }
}
