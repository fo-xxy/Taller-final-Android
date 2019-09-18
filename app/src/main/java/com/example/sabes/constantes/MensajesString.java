package com.example.sabes.constantes;

public enum MensajesString {
    MENSAJE_FELICITACION(" Felicidades, Tu calculo es correcto."),
    MENSAJE_SUMA_CORRECTA("La Suma es correcta."),
    MENSAJE_RESTA_CORRECTA("La Resta es correcta."),
    MENSAJE_MULTIPLI_CORRECTA("La Multiplicación es correcta."),
    MENSAJE_DIVISION_CORRECTA("La División es correcta."),
    MENSAJE_SUMA_INCORRECTA("La Suma es incorrecta, vuelve a intentarlo."),
    MENSAJE_RESTA_INCORRECTA("La Resta es incorrecta, vuelve a intentarlo."),
    MENSAJE_MULTIPL_INCORRECTA("La Multiplicación es incorrecta, vuelve a intentarlo."),
    MENSAJE_DIVISION_INCORRECTA("La División es incorrecta, vuelve a intentarlo."),
    MENSAJE_CALCULO("Buena suerte para la próxima, el calculo es: "),
    MENSAJE_NO_PUDISTE_SUMA("No pudiste superar el reto de la Suma."),
    MENSAJE_NO_PUDISTE_RESTA("No pudiste superar el reto de la Resta."),
    MENSAJE_NO_PUDISTE_MULTIPLI("No pudiste superar el reto de la Multiplicación."),
    MENSAJE_NO_PUDISTE_DIVISION("No pudiste superar el reto de la División.");

    private String mensaje;

    MensajesString(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
