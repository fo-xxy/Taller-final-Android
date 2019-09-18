package com.example.sabes;
/*1 BaseDeDatos: primero se creo el proyecto en firebase, y se grego el poyecto, se siguió las instrucciones,
y se agrego la linea para el internet, ahora se hará el diseño*/

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.RadioGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.example.sabes.modelo.NotasNormal;
import com.example.sabes.modelo.NotasPorcentaje;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CalificacionesAlumnos extends AppCompatActivity {

    /*2 BaseDeDatos: Se crearon dos radiobutton en el diseño, ahora se crearan dos variables para ellos, y se crea un grupo de radibutton*/
    RadioGroup group;
    RadioButton notas;
    Button validar;
    Button notasProcenatejeEnviar;
    Button notasNormalEnviar;
    EditText nota1;
    EditText nota2;
    EditText nota3;
    EditText nombre;
    EditText documento;
    TextView porciento1;
    TextView porciento2;
    TextView porciento3;
    TextView notafinal;
    TextView lbldocumento;
    TextView lblnombre;
    TextView lblnota1;
    TextView lblnota2;
    TextView lblnota3;

    /*13 BaseDeDatos: Se agregan estas*/
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones_alumnos);

        /*3 BaseDeDatos: Se asignan las variables a los radiobuttons del diseño, y las otros campos que necesitemos*/
        group = findViewById(R.id.rg);
        validar = findViewById(R.id.btnvalidar);
        nota1 = findViewById(R.id.txtnota1);
        nota2 = findViewById(R.id.txtnota2);
        nota3 = findViewById(R.id.txtnota3);
        nombre = findViewById(R.id.txtnombre);
        documento = findViewById(R.id.txtdocumento);
        porciento1= findViewById(R.id.lblporciento1);
        porciento2 = findViewById(R.id.lblporiceinto2);
        porciento3 = findViewById(R.id.lblporicento3);
        notafinal = findViewById(R.id.lblnotaFinal);

        lbldocumento = findViewById(R.id.lbldocumento);
        lblnombre = findViewById(R.id.lblnombre);
        lblnota1 = findViewById(R.id.lblnota1);
        lblnota2 = findViewById(R.id.lblnota2);
        lblnota3 = findViewById(R.id.lblnota3);





        notasProcenatejeEnviar = findViewById(R.id.btnnotasPorcentaje);
        notasNormalEnviar = findViewById(R.id.btnnotasNormal);
        inicializarFirebase();


        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckButton(view);


            }
        });

        /*10 BaseDeDatos: Se creo el metodo del primer boton, se llaman las variables*/
        notasNormalEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doc = documento.getText().toString();
                String nom =nombre.getText().toString();
                double n1 = Double.parseDouble(nota1.getText().toString());
                double n2 = Double.parseDouble(nota2.getText().toString());
                double n3 = Double.parseDouble(nota3.getText().toString());



                if(doc.equals("")||nom.equals("") || nota1.equals("") || nota2.equals("") || nota3.equals("")){
                    validacion();
                    Toast.makeText(CalificacionesAlumnos.this, "llene los campos", Toast.LENGTH_LONG).show();
                }
                else{

                    /*15 BaseDeDatos: Se crea un objeto de la clase de modelo*/
                    NotasNormal notasNormal = new NotasNormal();
                    notasNormal.setDocumento(doc);
                    notasNormal.setNombre(nom);
                    notasNormal.setNota1(n1);
                    notasNormal.setNota2(n2);
                    notasNormal.setNota3(n3);
                    notasNormal.setNotaFinal(notasNormal.notaF());

                    /*16 BaseDeDatos: Accedemos a nuestra variable databaseReference*/
                    databaseReference.child("Notas Normal").child(notasNormal.getDocumento()).setValue(notasNormal);

                    limpiar();
                    Toast.makeText(CalificacionesAlumnos.this, "Agregado", Toast.LENGTH_LONG).show();
                    notafinal.setVisibility(View.VISIBLE);
                    notafinal.setText(("Su nota final es: " + notasNormal.notaF()));
                }
            }
        });

        notasProcenatejeEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doc = documento.getText().toString();
                String nom =nombre.getText().toString();
                double n1 = Double.parseDouble(nota1.getText().toString());
                double n2 = Double.parseDouble(nota2.getText().toString());
                double n3 = Double.parseDouble(nota3.getText().toString());

                if(doc.equals("")||nom.equals("") || nota1.equals("") || nota2.equals("") || nota3.equals("")){
                    validacion();
                    Toast.makeText(CalificacionesAlumnos.this, "llene los campos", Toast.LENGTH_LONG).show();
                }
                else{

                    /*BaseDeDatos: Se crea un objeto de la clase de modelo*/
                    NotasPorcentaje notasPorcentaje = new NotasPorcentaje();
                    notasPorcentaje.setDocumento(doc);
                    notasPorcentaje.setNombre(nom);
                    notasPorcentaje.setNota1(n1);
                    notasPorcentaje.setNota2(n2);
                    notasPorcentaje.setNota3(n3);
                    notasPorcentaje.setNotaFinal(notasPorcentaje.notaFPor());

                    /* BaseDeDatos: Accedemos a nuestra variable databaseReference*/
                    databaseReference.child("Notas Con Porcentaje").child(notasPorcentaje.getDocumento()).setValue(notasPorcentaje);

                    limpiar();
                    Toast.makeText(CalificacionesAlumnos.this, "Se ha agregado correctamente", Toast.LENGTH_LONG).show();
                    notafinal.setVisibility(View.VISIBLE);
                    notafinal.setText(("Su nota final es: " + notasPorcentaje.notaFPor()));


                }
            }
        });
    }

    /*14 BaseDeDatos: Creamos un metodo para inicializar firebase y despes lo llamamos desde el metodo princiapl de esta clase*/
    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    /*11 BaseDeDatos: se crea un metodo para validar que los campos tengan datos*/
    private void validacion() {
        String doc = documento.getText().toString();
        String nom =nombre.getText().toString();
        String n1 = nota1.getText().toString();
        String n2 = nota2.getText().toString();
        String n3 = nota3.getText().toString();

        if(doc.equals("")){
            documento.setError("Required");
        }
        else if(nom.equals("")){
            nombre.setError("Required");
        }
        else if(n1.isEmpty()){
            nota1.setError("Required");
        }
        else if(n2.isEmpty()){
            nota2.setError("Required");
        }
        else if(n3.isEmpty()){
            nota3.setError("Required");
        }

    }

    /*12 BaseDedatos: Se crea un metodo para limpiar los campos de texto*/
    public void limpiar(){
        documento.setText("");
        nombre.setText("");
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
    }

    /*4 BaseDeDatos: se crea un metodo para los radiobutton*/
    public void CheckButton(View view){
        int radioId = group.getCheckedRadioButtonId();
         notas =findViewById(radioId);

        int radioButtonId = group.getCheckedRadioButtonId();
        /*obtendrías una referencia del elemento por medio del id:*/

        View notas = group.findViewById(radioButtonId);
        /*y obtendrías el indice del RadioButton dentro del RadioGroup:*/

        int indice = group.indexOfChild(notas);

         if(indice ==0){
             porciento1.setVisibility(View.VISIBLE);
             porciento2.setVisibility(View.VISIBLE);
             porciento3.setVisibility(View.VISIBLE);
             mostrar();

             notasProcenatejeEnviar.setVisibility(View.VISIBLE);
             notasNormalEnviar.setVisibility(View.INVISIBLE);
             Toast.makeText(CalificacionesAlumnos.this, "Notas porcentaje" , Toast.LENGTH_LONG).show();

         }
         else if(indice ==1){
             porciento1.setVisibility(View.INVISIBLE);
             porciento2.setVisibility(View.INVISIBLE);
             porciento3.setVisibility(View.INVISIBLE);
             mostrar();
             notasNormalEnviar.setVisibility(View.VISIBLE);
             notasProcenatejeEnviar.setVisibility(View.INVISIBLE);
             Toast.makeText(CalificacionesAlumnos.this, "Notas sin Porcentaje", Toast.LENGTH_LONG).show();
         }


    }
    /*5 BaseDeDatos: Se crea un nuevo package y se crea una clase, en este caso NotasNormal, y trabajaremos desde ahi*/


    /*metodo para mostrar los campos*/
    public void mostrar(){
        lbldocumento.setVisibility(View.VISIBLE);
        lblnombre.setVisibility(View.VISIBLE);
        lblnota1.setVisibility(View.VISIBLE);
        lblnota2.setVisibility(View.VISIBLE);
        lblnota3.setVisibility(View.VISIBLE);
        documento.setVisibility(View.VISIBLE);
        nombre.setVisibility(View.VISIBLE);
        nota1.setVisibility(View.VISIBLE);
        nota2.setVisibility(View.VISIBLE);
        nota3.setVisibility(View.VISIBLE);


    }




}
