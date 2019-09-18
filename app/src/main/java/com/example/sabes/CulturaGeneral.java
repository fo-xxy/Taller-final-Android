package com.example.sabes;
/*14: Cuando ya se haya creado la segunda actividad, iremos a la actividad principal y crearemos el boton, para que nos redireccione a esta*/
/*15: se hace el diseño de esta actividad*/
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CulturaGeneral extends AppCompatActivity {

    /*16: Se crean las variables*/
    TextView preguntaView;
    EditText respuestaView;
    int preguntasR;
    Button validar;

    Button cargar;

    String preguntasV[];
    String respuestaV[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura_general);

        /*18: Se asignan las variables o los campos del diseño*/
        preguntaView = findViewById(R.id.lblpregunta);
        respuestaView = findViewById(R.id.txtrespuesta);
        validar = findViewById(R.id.btnvalidarRes);
        cargar = findViewById(R.id.btncargar);

        Random r = new Random();


         preguntasV = new String[5];
         respuestaV = new String[5];

        preguntasV[0] = "Cuantas patas tiene un gato? copia el numero.";
        respuestaV[0] = "4";

        preguntasV[1] = "Cuando nacio cristobal colon? copia solo el año en números";
        respuestaV[1] = "1451";

        preguntasV[2] = "En total cuantos dedos tiene una persona? copie en numeros";
        respuestaV[2] = "20";

        preguntasV[3] = "Cuantos huesos tiene una paersona adulta? copie en numeros";
        respuestaV[3] = "206";

        preguntasV[4] = "Cuantos dias tiene un año? copie en numeros";
        respuestaV[4] = "365";




        preguntasR=r.nextInt(preguntasV.length);


        if(preguntasR ==0){
            preguntaView.setText(String.valueOf(preguntasV[0]));
        }
        else if(preguntasR == 1){
            preguntaView.setText(String.valueOf(preguntasV[1]));
        }
        else if(preguntasR == 2){
            preguntaView.setText(String.valueOf(preguntasV[2]));
        }
        else if(preguntasR == 3){
            preguntaView.setText(String.valueOf(preguntasV[3]));
        }
        else if(preguntasR == 4){
            preguntaView.setText(String.valueOf(preguntasV[4]));
        }



        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (preguntasR){

                    case 0:
                        condicionreguntaUno();
                        break;

                    case 1:
                        condicionPreguntaDos();
                        break;

                    case 2:
                        condicionPreguntaTres();
                        break;

                    case 3:
                        condicionPreguntaCuatro();
                        break;

                    case 4:
                        condicionPreguntaCinco();
                        break;

                        default:
                            Toast.makeText(CulturaGeneral.this, "No hay", Toast.LENGTH_LONG).show();
                            break;
                }



            }
        });




        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });



    }


    public void condicionreguntaUno(){
        if(preguntaView.getText().toString().equals(preguntasV[0]) && respuestaView.getText().toString().equals(respuestaV[0]) ){
            Toast.makeText(CulturaGeneral.this, "Felicidades es correcto", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(CulturaGeneral.this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
    public void condicionPreguntaDos(){
        if(preguntaView.getText().toString().equals(preguntasV[1]) && respuestaView.getText().toString().equals(respuestaV[1]) ){
            Toast.makeText(CulturaGeneral.this, "Felicidades es correcto", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(CulturaGeneral.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void condicionPreguntaTres(){
        if(preguntaView.getText().toString().equals(preguntasV[2]) && respuestaView.getText().toString().equals(respuestaV[2]) ){
            Toast.makeText(CulturaGeneral.this, "Felicidades es correcto", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(CulturaGeneral.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void condicionPreguntaCuatro(){
        if(preguntaView.getText().toString().equals(preguntasV[3]) && respuestaView.getText().toString().equals(respuestaV[3]) ){
            Toast.makeText(CulturaGeneral.this, "Felicidades es correcto", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(CulturaGeneral.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void condicionPreguntaCinco(){
        if(preguntaView.getText().toString().equals(preguntasV[4]) && respuestaView.getText().toString().equals(respuestaV[4]) ){
            Toast.makeText(CulturaGeneral.this, "Felicidades es correcto", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(CulturaGeneral.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
