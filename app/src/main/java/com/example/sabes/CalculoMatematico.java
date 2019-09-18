package com.example.sabes;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
/*importar la clase enumeradas*/
import static com.example.sabes.constantes.MensajesString.*;


public class CalculoMatematico extends AppCompatActivity {

    /*7: Creamos las variables para los numeros random*/
    double rNum1;
    double rNum2;
    int rOpr;
    TextView num1;
    TextView num2;
    TextView operacion;
    TextView aux;
    TextView mensaje;
    EditText resultado;
    Button calcular;
    Button siguiente;

    /*12: creacion de contador para las caritas cuando es correcto o incorrecto*/
    int contador = 0;



    /*9: Este es parte del 9 de abajo, se crea la funcion de random*/
    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_matematico);

        /*8: se hace la asignacion de las variables*/
        num1 = findViewById(R.id.lblnumero1);
        num2  = findViewById(R.id.lblnumero2);
        operacion = findViewById(R.id.lbloperacion);
        aux = findViewById(R.id.lblresultadoAu);
        mensaje = findViewById(R.id.lblmensajeRes);
        resultado = findViewById(R.id.txtresultado);
        calcular = findViewById(R.id.btncalcular);
        siguiente = findViewById(R.id.btnsiguiente);


        /*9: Se llama el metodo de numerorandom*/
        nRandom();

        /*10: Se crea el boton de calcular*/
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion();
            }
        });

        /*opcional, boton de reintentar
        intentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
                limpiarTex();
            }
        });*/

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nRandom();
                aux.setText("");
                mensaje.setText("");
                resultado.setEnabled(true);
                calcular.setEnabled(true);
                limpiarTex();

            }
        });
    }

    /*9: se crea el metodo random*/
    public void nRandom(){
        rNum1 = r.nextInt(10);
        rNum2 = r.nextInt(10);
        rOpr = r.nextInt(4);

        /*9.1: asigno los numero random a los textview del diseño*/
        num1.setText(String.valueOf(rNum1));
        num2.setText(String.valueOf(rNum2));

        /*9.2: se crea una condicion para mostrar los operadores*/
        if(rOpr == 0){
            operacion.setText("+");
        }
        else if(rOpr == 1){
            operacion.setText("-");
        }
        else if(rOpr == 2){
            operacion.setText("x");
        }
        else{
            operacion.setText("/");
        }
    }

    /*11: se crea un metodo con las operaciones para mostrar*/

    public void operacion(){
        switch (rOpr){
            case 0:
                suma();
                break;

            case 1:
                resta();
                break;

            case 2:
                multiplicacion();
                break;

            case 3:
                division();
                break;

                default:
                    break;
        }
    }

    public void suma(){
        double auxiliarOp = Double.parseDouble(resultado.getText().toString());
        double suma = rNum1 + rNum2;
        if(auxiliarOp == suma){
            mensaje.setVisibility(View.VISIBLE);
            mensaje.setText(MENSAJE_FELICITACION.getMensaje());
            aux.setVisibility(View.VISIBLE);
            aux.setText(rNum1 + " " + "+" + " " + rNum2 + " = " + (suma));
            limpiarTex();
            Toast.makeText(CalculoMatematico.this, MENSAJE_SUMA_CORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            contador =0;
            bloqueoTexBut();
        }
        else{
            if(contador < 3){
                contador++;
                Toast.makeText(CalculoMatematico.this, MENSAJE_SUMA_INCORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            }
            else {
                contador=0;
                mensaje.setVisibility(View.VISIBLE);
                aux.setVisibility(View.VISIBLE);
                mensaje.setText(MENSAJE_CALCULO.getMensaje());
                aux.setText(rNum1 + " " + "+" + " " + rNum2 + " = " + (suma));
                limpiarTex();
                Toast.makeText(CalculoMatematico.this, MENSAJE_NO_PUDISTE_SUMA.getMensaje(), Toast.LENGTH_LONG).show();
                bloqueoTexBut();
            }
        }
    }

    public void resta(){
        double auxiliarOp = Double.parseDouble(resultado.getText().toString());
        double resta = rNum1 - rNum2;
        if(auxiliarOp == resta){
            mensaje.setVisibility(View.VISIBLE);
            aux.setVisibility(View.VISIBLE);
            mensaje.setText(MENSAJE_FELICITACION.getMensaje());
            aux.setText(rNum1 + " " + "-" + " " + rNum2 + " = " +(resta));
            limpiarTex();
            Toast.makeText(CalculoMatematico.this,MENSAJE_RESTA_CORRECTA.getMensaje() , Toast.LENGTH_LONG).show();
            contador = 0;
            bloqueoTexBut();
        }
        else{
            if(contador < 3){
                contador++;
                Toast.makeText(CalculoMatematico.this,MENSAJE_RESTA_INCORRECTA.getMensaje() , Toast.LENGTH_LONG).show();
            }
            else {
                contador = 0;
                mensaje.setVisibility(View.VISIBLE);
                aux.setVisibility(View.VISIBLE);
                mensaje.setText("Buena suerte para la próxima, el calculo es: ");
                aux.setText(rNum1 + " " + "-" + " " + rNum2 + " = " +(resta));
                limpiarTex();
                Toast.makeText(CalculoMatematico.this,MENSAJE_NO_PUDISTE_RESTA.getMensaje() , Toast.LENGTH_LONG).show();
                bloqueoTexBut();
            }
        }
    }

    public void multiplicacion(){
        double auxiliarOp = Double.parseDouble(resultado.getText().toString());
        double multiplicacion = rNum1 * rNum2;
        if(auxiliarOp == multiplicacion){
            mensaje.setVisibility(View.VISIBLE);
            aux.setVisibility(View.VISIBLE);
            mensaje.setText(MENSAJE_FELICITACION.getMensaje());
            aux.setText(rNum1 + " " + "*" + " " + rNum2 + " = " +(multiplicacion));
            limpiarTex();
            Toast.makeText(CalculoMatematico.this, MENSAJE_MULTIPLI_CORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            contador = 0;
            bloqueoTexBut();
        }
        else {
            if(contador < 3){
                contador++;
                Toast.makeText(CalculoMatematico.this, MENSAJE_MULTIPL_INCORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            }
            else{
                contador = 0;
                mensaje.setVisibility(View.VISIBLE);
                aux.setVisibility(View.VISIBLE);
                mensaje.setText(MENSAJE_CALCULO.getMensaje());
                aux.setText(rNum1 + " " + "*" + " " + rNum2 + " = " +(multiplicacion));
                limpiarTex();
                Toast.makeText(CalculoMatematico.this, MENSAJE_NO_PUDISTE_MULTIPLI.getMensaje(), Toast.LENGTH_LONG).show();
                bloqueoTexBut();
            }
        }
    }

    public void division(){
        double auxiliarOp = Double.parseDouble(resultado.getText().toString());
        double division = rNum1 / rNum2;
        if(auxiliarOp == division){
            mensaje.setVisibility(View.VISIBLE);
            aux.setVisibility(View.VISIBLE);
            mensaje.setText(MENSAJE_FELICITACION.getMensaje());
            aux.setText(rNum1 + " " + "/" + " " + rNum2 + " = " + (division));
            limpiarTex();
            Toast.makeText(CalculoMatematico.this, MENSAJE_DIVISION_CORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            contador = 0;
            bloqueoTexBut();
        }
        else{
            if(contador < 3){
                contador++;
                Toast.makeText(CalculoMatematico.this, MENSAJE_DIVISION_INCORRECTA.getMensaje(), Toast.LENGTH_LONG).show();
            }
            else{
                contador = 0;
                mensaje.setVisibility(View.VISIBLE);
                aux.setVisibility(View.VISIBLE);
                mensaje.setText(MENSAJE_CALCULO.getMensaje());
                aux.setText(rNum1 + " " + "/" + " " + rNum2 + " = " + (division));
                limpiarTex();
                Toast.makeText(CalculoMatematico.this, MENSAJE_NO_PUDISTE_DIVISION.getMensaje(), Toast.LENGTH_LONG).show();
                bloqueoTexBut();
            }
        }
    }

    /*Metodo para bloquear*/
    public void bloqueoTexBut(){
        resultado.setEnabled(false);
        calcular.setEnabled(false);
    }

    /*Metodo para limpiar*/
    public void limpiarTex(){
        resultado.setText("");
    }

    /*12: Se crea otra actividad, en este caso CulturaGeneral*/
}
