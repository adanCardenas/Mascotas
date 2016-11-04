package com.cardenas.adan.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.dao.CargaInicialMascotas;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    CargaInicialMascotas initialDAO=new CargaInicialMascotas();
    List<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        customToolbar.setLogo(R.drawable.logo);
        setSupportActionBar(customToolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.Main_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        mascotas=initialDAO.inicializaMascotas();
        initAdaptador();

    }

    public void initAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adapter);
    }

    public void mascotasFavoritas(View view){
        Intent intent = new Intent(this,MascotasFavoritas.class);
        startActivity(intent);

    }
}
