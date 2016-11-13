package com.cardenas.adan.mascotas.view.fragment.impl;


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
import com.cardenas.adan.mascotas.model.Mascota;
import com.cardenas.adan.mascotas.presenter.fragment.IMascotaFragmentRecyclerViewPresenter;
import com.cardenas.adan.mascotas.presenter.fragment.impl.MascotaFragmentRecyclerViewPresenter;
import com.cardenas.adan.mascotas.view.fragment.IMascotaFragmentRecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragmentRecyclerview extends Fragment implements IMascotaFragmentRecyclerView{

    private List<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotaFragmentRecyclerViewPresenter presenter;

    public MascotaFragmentRecyclerview() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascota,container,false);

        listaMascotas = (RecyclerView) view.findViewById(R.id.Main_RecyclerView);
        presenter = new MascotaFragmentRecyclerViewPresenter(this,getContext());
        return view;
    }




    public void mascotasFavoritas(View view){
        Intent intent = new Intent(getActivity(),MascotasFavoritas.class);
        startActivity(intent);
    }


    @Override
    public void generarLinearLayout(int orientacion) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(orientacion);
        listaMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void generarGridLayout(int numeroGrids) {

    }

    @Override
    public MascotaAdapter crearAdaptador(List<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas,getActivity(),getContext());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorReciclerView(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
