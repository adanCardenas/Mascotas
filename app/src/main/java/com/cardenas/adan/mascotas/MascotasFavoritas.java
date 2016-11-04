package com.cardenas.adan.mascotas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;

import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.dao.CargaInicialMascotas;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;


public class MascotasFavoritas extends AppCompatActivity {
    CargaInicialMascotas dao=new CargaInicialMascotas();
    private RecyclerView listaMascotas;
    List<Mascota> mascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        customToolbar.setLogo(R.drawable.logo);
        setSupportActionBar(customToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.Favoritos_RecyclerView);
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
