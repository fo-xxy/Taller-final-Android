package com.example.sabes.modelo;



public class NotasNormal {
    /*6 BaseDeDatos: Se crean los atributos, los que mandaremos desde el diseño*/
    private String documento;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double notaFinal;

    /*7 BaseDeDatos: Se crea el constructor de la clase*/

    public NotasNormal() {
        this.documento = documento;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaFinal = notaFinal;

    }
    /*8 BaseDeDatos: Se crea los mtodo getter y setter de cada atributo*/

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public double notaF(){
        double not;
        return  not =(notaFinal =  this.nota1 + this.nota2 + this.nota3) /3;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /*9 BaseDeDatos: volvemos a la clase calificacionesAlumnos*/
}
