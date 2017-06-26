package com.cardenas.adan.mascotas.activities;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardenas.adan.mascotas.R;
import com.cardenas.adan.mascotas.services.MailService;

import org.w3c.dom.Text;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class ActivityContacto extends AppCompatActivity {
    TextView nombre;
    TextView correo;
    TextView comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_custom_actionbar);
        ImageButton customBarImageView = (ImageButton) findViewById(R.id.action_bar_mascotas_image_button);
        customBarImageView.setVisibility(View.GONE);
        setSupportActionBar(customToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre      = (TextView) findViewById(R.id.activity_contacto_textinputedit_nombre);
        correo      = (TextView) findViewById(R.id.activity_contacto_textinputedit_correo_electronico);
        comentario  = (TextView) findViewById(R.id.activity_contacto_textinputedit_comentario);

        Button buttonEnviar= (Button) findViewById(R.id.activity_contacto_button_enviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Mail", "Se ha dado click en el boton de envio de correo");
                String correoOrigen = correo.getText().toString();
                String cuerpoCorreo = comentario.getText().toString();
                String nombreE = nombre.getText().toString();

                try {
                    new MailService(correoOrigen, nombreE, cuerpoCorreo).sendEmail();
                }catch (AddressException aex){
                    Log.v("Mail Error","AddresException. Error: "+aex.getMessage()+" Code: "+aex.getLocalizedMessage());
                }catch (MessagingException mex){
                    Log.v("Mail Error","MessagingException. Error: "+mex.getMessage()+" Code: "+mex.getLocalizedMessage());
                }
                catch (Exception ex){
                    Log.v("Mail Error","Error al enviar el correo, Error: "+ex.getMessage()+" Code: "+ex.getLocalizedMessage());
                }
            }
        });
    }
}