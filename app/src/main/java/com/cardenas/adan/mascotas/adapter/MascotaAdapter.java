package com.cardenas.adan.mascotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.dao.impl.MascotasManagerDAO;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.List;

/**
 * Created by adan_ on 30/10/2016.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    private List<Mascota> mascotas;
    private Activity runningActivity;
    private Context runningContext;

    public MascotaAdapter(List<Mascota> mascotas){
        this.mascotas=mascotas;
    }

    public MascotaAdapter(List<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        runningActivity=activity;
    }

    public MascotaAdapter(List<Mascota> mascotas, Activity activity, Context context){
        this.mascotas=mascotas;
        runningActivity=activity;
        runningContext=context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final MascotasManagerDAO managerDAO = new MascotasManagerDAO(runningContext);
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.nombreMascota.setText(mascota.getName());
        mascotaViewHolder.fotoMascota.setImageResource(mascota.getImage());
        mascotaViewHolder.ratingMascota.setText(String.valueOf(mascota.getRating()));
        mascotaViewHolder.ratingIconoMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(runningActivity,"Diste rate a "+mascota.getName(), Toast.LENGTH_SHORT).show();
                mascota.setRating(mascota.getRating()+1);
                managerDAO.updateSinglePet(mascota);
                mascotaViewHolder.ratingMascota.setText(String.valueOf(managerDAO.getSinglePetById(mascota.getId()).getRating()));
            }
        });

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
        private ImageView ratingIconoMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoMascota         = (ImageView) itemView.findViewById(R.id.CV_Mascotas_ImageView);
            nombreMascota       = (TextView)  itemView.findViewById(R.id.CV_TextView_NombreMascota);
            ratingMascota       = (TextView)  itemView.findViewById(R.id.CV_TextView_Rating);
            ratingIconoMascota  = (ImageView) itemView.findViewById(R.id.CV_ImageView_Rating);
        }
    }
}

