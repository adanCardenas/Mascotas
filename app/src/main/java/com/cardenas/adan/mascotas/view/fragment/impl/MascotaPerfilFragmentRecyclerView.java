package com.cardenas.adan.mascotas.view.fragment.impl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.dao.impl.MascotasManagerDAO;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaPerfilFragmentRecyclerView extends Fragment {
    MascotasManagerDAO mascotaDAO =new MascotasManagerDAO(getContext());
    List<Mascota> mascotas;
    private RecyclerView listaMascotasPerfil;

    public MascotaPerfilFragmentRecyclerView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascota_perfil,container,false);
        listaMascotasPerfil = (RecyclerView) view.findViewById(R.id.fragment_mascota_perfil_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        listaMascotasPerfil.setLayoutManager(gridLayoutManager);
        mascotas= mascotaDAO.perfilMascota();
        initAdaptador();
        return view;
    }

    public void initAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        listaMascotasPerfil.setAdapter(adapter);
    }
}