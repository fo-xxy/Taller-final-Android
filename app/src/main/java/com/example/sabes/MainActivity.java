package com.example.sabes;
/*1: Primero haré el diseño del menú principal*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
/*2 Despues creare un atributo para el boton*/
    Button calculoMatematico;
    Button culturaGeneral;
    Button notas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*3: HAre la asignacion del boton ya creado en el diseño y la varibale*/
        calculoMatematico = findViewById(R.id.btncalculoMatematico);
        culturaGeneral = findViewById(R.id.btnculturaGeneral);
        notas = findViewById(R.id.btnNootas);

        /*4: Creamos la actividad y se crea el metodo del boton*/
        calculoMatematico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*5: se crea el metodo de boton, para redireccionarnos a la otra actividad*/
                Intent ventanaCalculoMatematico = new Intent(MainActivity.this, CalculoMatematico.class);
                startActivity(ventanaCalculoMatematico);
                /*6: Empezamos con el diseño de la aotra activida, en este caso CalculoMatematico*/
            }
        });

        culturaGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventanaCulturaGeenral = new Intent(MainActivity.this, CulturaGeneral.class);
                startActivity(ventanaCulturaGeenral);
            }
        });

        notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventanaNotas = new Intent(MainActivity.this, CalificacionesAlumnos.class);
                startActivity(ventanaNotas);
            }
        });


    }
}
