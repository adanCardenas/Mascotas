package com.cardenas.adan.mascotas.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cardenas.adan.mascotas.constants.DAOConstants;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.ArrayList;
import java.util.List;

import com.cardenas.adan.mascotas.R;

/**
 * Created by adan_ on 30/10/2016.
 */

public class MascotasManagerDAO {
    private Context context;
    private List<Mascota> mascotas=new ArrayList<>();


    public MascotasManagerDAO(Context context) {
        this.context = context;
    }

    public List<Mascota> inicializaMascotas(){
        //dao = new MascotasDAO(context);
        MascotasDAO dao = new MascotasDAO(context);
        mascotas=getPets();
        if(mascotas.isEmpty()){
            initPetDatabase(dao);
        }
        return mascotas;
        /*//Hardcoded values
        List<Mascota> mascotas=new ArrayList<>();
        mascotas.add(new Mascota(1,"Tom", R.drawable.tom,7));
        mascotas.add(new Mascota(2,"Peppy", R.drawable.peppy,7));
        mascotas.add(new Mascota(3,"Rafus", R.drawable.catty,6));
        mascotas.add(new Mascota(4,"Foxy", R.drawable.foxy,5));
        mascotas.add(new Mascota(5,"Ratata", R.drawable.raty,2));
        return mascotas;*/
        //return dao.getAllPets();
    }

    public List<Mascota> perfilMascota(){
        mascotas.add(new Mascota(101,"Tom", R.drawable.tom1,10));
        mascotas.add(new Mascota(102,"Tom", R.drawable.tom2,9));
        mascotas.add(new Mascota(104,"Tom", R.drawable.tom3,8));
        mascotas.add(new Mascota(105,"Tom", R.drawable.tom4,7));
        mascotas.add(new Mascota(106,"Tom", R.drawable.tom5,6));
        return  mascotas;
    }

    public List<Mascota> mascotasFavoritas(){
        mascotas=inicializaMascotas();
        if(!mascotas.isEmpty()){
            mascotas.get(0).setRating(12);
            mascotas.get(1).setRating(11);
        }
        return mascotas;
    }

    public void initPetDatabase(MascotasDAO dao){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_2,"Tom");
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_3,R.drawable.tom);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_4,0);
        dao.insertPet(contentValues);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_2,"Peppy");
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_3,R.drawable.peppy);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_4,0);
        dao.insertPet(contentValues);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_2,"Rafus");
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_3,R.drawable.catty);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_4,0);
        dao.insertPet(contentValues);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_2,"Foxy");
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_3,R.drawable.foxy);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_4,0);
        dao.insertPet(contentValues);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_2,"Ratata");
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_3,R.drawable.raty);
        contentValues.put(DAOConstants.TABLE_MASCOTA_POS_4,0);
        dao.insertPet(contentValues);
    }

    public List<Mascota> getPets(){
        MascotasDAO dao = new MascotasDAO(context);
        return dao.getAllPets();
    }

    public void updateSinglePet(Mascota mascota){
        MascotasDAO dao = new MascotasDAO(context);
        ContentValues newContentValue = new ContentValues();
        newContentValue.put(DAOConstants.TABLE_MASCOTA_POS_1,mascota.getId());
        newContentValue.put(DAOConstants.TABLE_MASCOTA_POS_2,mascota.getName());
        newContentValue.put(DAOConstants.TABLE_MASCOTA_POS_3,mascota.getImage());
        newContentValue.put(DAOConstants.TABLE_MASCOTA_POS_4,mascota.getRating());
        dao.updatePet(newContentValue);
    }

    public Mascota getSinglePetById(int id){
        MascotasDAO dao = new MascotasDAO(context);
        return dao.getPetById(id);
    }

}