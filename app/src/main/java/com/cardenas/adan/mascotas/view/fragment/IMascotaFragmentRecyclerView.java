package com.cardenas.adan.mascotas.view.fragment;

import com.cardenas.adan.mascotas.adapter.MascotaAdapter;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;

/**
 * Created by adan0adn on 12/11/16.
 */

public interface IMascotaFragmentRecyclerView {

    public void generarLinearLayout(int orientacion);

    public void generarGridLayout(int numeroGrids);

    public MascotaAdapter crearAdaptador(List<Mascota> mascotas);

    public void inicializarAdaptadorReciclerView(MascotaAdapter adaptador);
}
