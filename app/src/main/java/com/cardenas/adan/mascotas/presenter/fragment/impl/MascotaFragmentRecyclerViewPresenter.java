package com.cardenas.adan.mascotas.presenter.fragment.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.cardenas.adan.mascotas.dao.impl.MascotasManagerDAO;
import com.cardenas.adan.mascotas.model.Mascota;
import com.cardenas.adan.mascotas.presenter.fragment.IMascotaFragmentRecyclerViewPresenter;
import com.cardenas.adan.mascotas.view.fragment.IMascotaFragmentRecyclerView;

import java.util.List;

/**
 * Created by adan0adn on 12/11/16.
 */

public class MascotaFragmentRecyclerViewPresenter implements IMascotaFragmentRecyclerViewPresenter {
    private IMascotaFragmentRecyclerView iMascotaFragmentRecyclerView;
    private Context context;
    private MascotasManagerDAO mascotasManagerDAO;
    private List<Mascota> mascotas;

    public MascotaFragmentRecyclerViewPresenter(IMascotaFragmentRecyclerView iMascotaFragmentRecyclerView, Context context) {
        this.iMascotaFragmentRecyclerView=iMascotaFragmentRecyclerView;
        this.context=context;
        obtenerMascotas();
        mostrarMascotasReciclerView();
    }

    @Override
    public void obtenerMascotas() {
        mascotasManagerDAO = new MascotasManagerDAO(context);
        mascotas= mascotasManagerDAO.getPets();

    }

    @Override
    public void mostrarMascotasReciclerView() {
        if(mascotas!=null){
            Log.i("ReciclerView","Inicializando Adaptador / Layout");
            iMascotaFragmentRecyclerView.inicializarAdaptadorReciclerView(iMascotaFragmentRecyclerView.crearAdaptador(mascotas));
            iMascotaFragmentRecyclerView.generarLinearLayout(LinearLayoutManager.VERTICAL);
        }else{
            Log.e("ReciclerView","Lista de mascotas vacia...");
        }

    }
}
