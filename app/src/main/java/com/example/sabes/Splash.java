package com.example.sabes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

/*1 Splash: se creo la actividad y nos vamos a hacer el diseño*/
/*2 Splash: nos vamos al diseño del splash, pero en en el codigo*/
public class Splash extends AppCompatActivity {

    /*6 Splash: se Crear el atributo de vidoew*/
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*7 Splash: Esto hace que la barra de arriba desaparezca*/
        getSupportActionBar().hide();

        /*8 Splash: Para que se visualice en la ventana*/
        videoView = findViewById(R.id.videoView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*9 Splash: se crea la carpeta raw y se agrega el video*/

        /*10 Splash: En estas tres lineas se ubica el archivo como String cualquiernombre ="android.resource://aqui va el nombre del package y luego lo demas" */
        String videopath = "android.resource://com.example.sabes/" + R.raw.comp;
        /*11 Splash: uri se usa como extencion para buscar*/
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);


        /*12 Splash: Esto posibilita la reproduccion del video*/
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(isFinishing())
                    return;

                /*13 Splash: que se inicie la actividad cunado se termine*/
                startActivity( new Intent(Splash.this, MainActivity.class));
            }
        });

        videoView.start();

    }
}
