package com.cardenas.adan.mascotas.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;

import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.dao.MascotasDAO;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;


public class MascotasFavoritas extends AppCompatActivity {
    MascotasDAO dao=new MascotasDAO();
    private RecyclerView listaMascotas;
    List<Mascota> mascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        setSupportActionBar(customToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.activity_mascotas_favoritas_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        mascotasFav= dao.mascotasFavoritas();
        initAdaptador();


    }

    public void initAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotasFav);
        listaMascotas.setAdapter(adapter);
    }
}
