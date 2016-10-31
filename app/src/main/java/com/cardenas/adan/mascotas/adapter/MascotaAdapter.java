package com.cardenas.adan.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;

/**
 * Created by adan_ on 30/10/2016.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    private List<Mascota> mascotas;

    public MascotaAdapter(List<Mascota> mascotas){
        this.mascotas=mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.nombreMascota.setText(mascota.getName());
        mascotaViewHolder.fotoMascota.setImageResource(mascota.getImage());
        mascotaViewHolder.ratingMascota.setText(mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView fotoMascota;
        private TextView nombreMascota;
        private TextView ratingMascota;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoMascota     = (ImageView) itemView.findViewById(R.id.CV_Mascotas_ImageView);
            nombreMascota   = (TextView) itemView.findViewById(R.id.CV_TextView_NombreMascota);
            ratingMascota   = (TextView) itemView.findViewById(R.id.CV_TextView_Rating);
        }
    }
}

