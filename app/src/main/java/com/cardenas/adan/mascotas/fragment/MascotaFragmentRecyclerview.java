package com.cardenas.adan.mascotas.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardenas.adan.mascotas.activities.MascotasFavoritas;
import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.dao.MascotasDAO;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragmentRecyclerview extends Fragment {
    MascotasDAO initialDAO=new MascotasDAO();
    List<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public MascotaFragmentRecyclerview() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascota,container,false);

        listaMascotas = (RecyclerView) view.findViewById(R.id.Main_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        mascotas=initialDAO.inicializaMascotas();
        initAdaptador();
        return view;
    }


    public void initAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adapter);
    }

    public void mascotasFavoritas(View view){
        Intent intent = new Intent(getActivity(),MascotasFavoritas.class);
        startActivity(intent);

    }

}
