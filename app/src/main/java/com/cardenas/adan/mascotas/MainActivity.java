package com.cardenas.adan.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.cardenas.adan.mascotas.activities.ActivityAcerca;
import com.cardenas.adan.mascotas.activities.ActivityContacto;
import com.cardenas.adan.mascotas.adapter.MascotaPageAdapter;
import com.cardenas.adan.mascotas.dao.MascotasDAO;
import com.cardenas.adan.mascotas.fragment.MascotaPerfilFragmentRecyclerView;
import com.cardenas.adan.mascotas.fragment.MascotaFragmentRecyclerview;
import com.cardenas.adan.mascotas.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        ImageButton customBarImageView = (ImageButton) findViewById(R.id.action_bar_mascotas_image_button);
        customBarImageView.setVisibility(View.GONE);
        setSupportActionBar(customToolbar);
        tabLayout   = (TabLayout)findViewById(R.id.main_tablayout);
        viewPager   = (ViewPager)findViewById(R.id.main_viewpager);
        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal_mascotas,menu);
        return true;
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotaFragmentRecyclerview());
        fragments.add(new MascotaPerfilFragmentRecyclerView());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new MascotaPageAdapter(getSupportFragmentManager(),addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
        tabLayout.setSelectedTabIndicatorColor(R.color.cardview_dark_background);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_contacto:
                intent=new Intent(this,ActivityContacto.class);
                startActivity(intent);
                break;
            case R.id.menu_acerca:
                intent=new Intent(this,ActivityAcerca.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}