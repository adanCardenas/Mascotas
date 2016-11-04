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
 * Created by adan_ on 02/11/2016.
 */

public class MascotaFavoritaAdapter extends RecyclerView.Adapter<MascotaFavoritaAdapter.MascotaFavoritaViewHolder>{
    private List<Mascota> mascotas;

    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaFavoritaAdapter.MascotaFavoritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaFavoritaViewHolder mascotaFavoritaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaFavoritaViewHolder.nombreMascota.setText(mascota.getName());
        mascotaFavoritaViewHolder.fotoMascota.setImageResource(mascota.getImage());
        mascotaFavoritaViewHolder.ratingMascota.setText(mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView fotoMascota;
        private TextView nombreMascota;
        private TextView ratingMascota;


        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            fotoMascota     = (ImageView) itemView.findViewById(R.id.CV_Mascotas_ImageView);
            nombreMascota   = (TextView) itemView.findViewById(R.id.CV_TextView_NombreMascota);
            ratingMascota   = (TextView) itemView.findViewById(R.id.CV_TextView_Rating);
        }
    }
}
