package com.cardenas.adan.mascotas.presenter.fragment.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.cardenas.adan.mascotas.dao.RestEndpoint;
import com.cardenas.adan.mascotas.dao.impl.MascotasManagerDAO;
import com.cardenas.adan.mascotas.dao.impl.RestAdapapter;
import com.cardenas.adan.mascotas.model.Mascota;
import com.cardenas.adan.mascotas.model.MascotaResponse;
import com.cardenas.adan.mascotas.presenter.fragment.IMascotaFragmentRecyclerViewPresenter;
import com.cardenas.adan.mascotas.view.fragment.IMascotaFragmentRecyclerView;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerMascotas();
        obtenerMascotasInstagram();
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

    @Override
    public void obtenerMascotasInstagram() {
        RestAdapapter restAdapapter = new RestAdapapter();
        Gson gsonRecentMedia  = restAdapapter.buildDeserilizerGsonRecentMedia();
        RestEndpoint restEndpoint = restAdapapter.establishRestInstagramApiCon(gsonRecentMedia);
        Call<MascotaResponse> mascotaResponseCall = restEndpoint.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotasResponse();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context,"Error de conexión",Toast.LENGTH_LONG).show();
                Log.e("Error en la conexión: ",t.getMessage()+"Causa: "+t.getCause());
            }
        });

    }
}
