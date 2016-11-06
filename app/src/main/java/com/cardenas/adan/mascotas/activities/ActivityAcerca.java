package com.cardenas.adan.mascotas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.cardenas.adan.mascotas.R;

public class ActivityAcerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        ImageButton customBarImageView = (ImageButton) findViewById(R.id.action_bar_mascotas_image_button);
        customBarImageView.setVisibility(View.GONE);
        setSupportActionBar(customToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
