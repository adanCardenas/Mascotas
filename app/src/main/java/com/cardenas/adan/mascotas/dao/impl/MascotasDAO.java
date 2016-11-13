package com.cardenas.adan.mascotas.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cardenas.adan.mascotas.constants.DAOConstants;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adan0adn on 12/11/16.
 */

public class MascotasDAO extends SQLiteOpenHelper{
    private Context context;

    public MascotasDAO(Context context) {
        super(context, DAOConstants.DATABASE_NAME,null,DAOConstants.DATABASE_VERSION);
        this.context=context;
    }

    public MascotasDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable = "CREATE TABLE "+ DAOConstants.TABLE_MASCOTA+"("+
                DAOConstants.TABLE_MASCOTA_POS_1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DAOConstants.TABLE_MASCOTA_POS_2+ " TEXT, "+
                DAOConstants.TABLE_MASCOTA_POS_3+ " INTEGER, "+
                DAOConstants.TABLE_MASCOTA_POS_4+ " INTEGER"+
                ")";
        try{
            sqLiteDatabase.execSQL(createTable);
        }catch (SQLiteException sqlex){
            Log.e("SQLite Create","Error el crear la tabla, Mensaje de error: "+sqlex.getMessage());
        }catch (Exception ex){
            Log.e("SQLite Create","Excepción general, Mensaje de error:"+ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+DAOConstants.TABLE_MASCOTA);
            onCreate(sqLiteDatabase);
        }catch (SQLiteException sqlex){
            Log.e("SQLite OnUpgrade","Error al actualizar la tabla, Mensaje de error: "+sqlex.getMessage());
        }catch (Exception ex){
            Log.e("SQLite OnUpgrade","Excepción general, Mensaje de error:"+ex.getMessage());
        }
    }

    public List<Mascota> getAllPets(){
        List<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db=null;
        String sqlString= "SELECT * FROM "+DAOConstants.TABLE_MASCOTA;
        try{
            db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery(sqlString,null);
            while(cursor.moveToNext()){
                Mascota mascotaCursor=new Mascota();
                mascotaCursor.setId(cursor.getInt(0));
                mascotaCursor.setName(cursor.getString(1));
                mascotaCursor.setImage(cursor.getInt(2));
                mascotaCursor.setRating(cursor.getInt(3));
                mascotas.add(mascotaCursor);
            }
        }catch(SQLiteException sqlexc){
            Log.e("SQLite getAllPets","Error en la tabla, Mensaje de error: "+sqlexc.getMessage());
            return null;
        }catch (Exception ex){
            Log.e("SQLite getAllPets","Excepcion general, Mensaje de error: "+ex.getMessage());
            return  null;
        }finally {
            if(db!=null && db.isOpen()){
                db.close();
            }
            return mascotas;
        }
    }

    public Mascota getPetById(int id){
        Mascota mascotaDAO=new Mascota();
        SQLiteDatabase db=null;
        try{
            db=this.getWritableDatabase();
            Cursor cursor=db.query(DAOConstants.TABLE_MASCOTA,null,DAOConstants.TABLE_MASCOTA_POS_1+"="+String.valueOf(id),null,null,null,null);
            if(cursor.moveToNext()){
                mascotaDAO.setId(cursor.getInt(0));
                mascotaDAO.setName(cursor.getString(1));
                mascotaDAO.setImage(cursor.getInt(2));
                mascotaDAO.setRating(cursor.getInt(3));
            }else if(cursor.isNull(0)){
                Log.i("SQLite getPetById","No se encontro ningun registro con el id "+id);
                throw new Exception("No se encontro ningun registro con el id "+id);
            }
        }catch(SQLiteException sqlexc){
            Log.e("SQLite getPetById","Error en la tabla, Mensaje de error: "+sqlexc.getMessage());
            return null;
        }catch (Exception ex){
            Log.e("SQLite getPetById","Excepcion general, Mensaje de error: "+ex.getMessage());
            return  null;
        }finally {
            if(db!=null && db.isOpen()){
                db.close();
            }
            return mascotaDAO;
        }

    }

    public void insertPet(ContentValues contentValues) {
        SQLiteDatabase db = null;
        try {
            if (contentValues != null) {
                if (contentValues.size() == 0) {
                    throw new Exception("ContentValue no tiene parametros, no se inserto el registro");
                }
                db = this.getWritableDatabase();
                db.insert(DAOConstants.TABLE_MASCOTA, null, contentValues);
            } else {
                throw new Exception("ContenValue no esta inicializado, no se inserto el registro");
            }
        } catch (SQLiteException sqlexc) {
            Log.e("SQLite insertPet", "Error en la tabla, Mensaje de error: " + sqlexc.getMessage());
        } catch (Exception ex) {
            Log.e("SQLite insertPet", "Excepcion general, Mensaje de error: " + ex.getMessage());
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }

    public void updatePet(ContentValues contentValues){
        SQLiteDatabase db=null;
        try{
            if(contentValues!=null){
                if(contentValues.size()==0){
                    throw new Exception("ContentValue no tiene parametros, no se actualizao el registro");
                }
                String updateId = String.valueOf(contentValues.get(DAOConstants.TABLE_MASCOTA_POS_1));
                db=this.getWritableDatabase();
                int result=db.update(DAOConstants.TABLE_MASCOTA,contentValues,DAOConstants.TABLE_MASCOTA_POS_1+"="+updateId,null);
                Log.i("SQLite updatePet", "Resultado del update: "+result);
            }else{
                throw  new Exception("ContenValue no esta inicializado, no se actualizo el registro");
            }
        }catch(SQLiteException sqlexc){
            Log.e("SQLite updatePet","Error en la tabla, Mensaje de error: "+sqlexc.getMessage());
        }catch(Exception ex){
            Log.e("SQLite updatePet","Excepcion general, Mensaje de error: "+ex.getMessage());
        }finally {
            if(db!=null && db.isOpen()){
                db.close();
            }
        }
    }

}
