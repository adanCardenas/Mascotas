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
 * Created by adan_ on 05/11/2016.
 */

public class MascotaPerfilAdapter extends RecyclerView.Adapter<MascotaPerfilAdapter.MascotaPerfilViewHolder>{
    private List<Mascota> mascotas;

    public MascotaPerfilAdapter(List<Mascota> mascotas){
        this.mascotas=mascotas;
    }

    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_perfil,parent,false);
        return new MascotaPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaPerfilViewHolder mascotaPerfilViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaPerfilViewHolder.fotoPerfilMascota.setImageResource(mascota.getImage());
        mascotaPerfilViewHolder.ratingPerfilMascota.setText(mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaPerfilViewHolder extends  RecyclerView.ViewHolder{
        private ImageView fotoPerfilMascota;
        private TextView ratingPerfilMascota;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            fotoPerfilMascota   = (ImageView)   itemView.findViewById(R.id.cardview_perfil_mascotas_imageview);
            ratingPerfilMascota = (TextView)    itemView.findViewById(R.id.cardview_perfil_textview_rating);
        }
    }
}
