package com.edy.juegoGuayabita.dominio;

public class Jugador {
    String nombre;
    double dineroActual;

    public Jugador(String nombre, double dineroActual) {
        this.nombre = nombre;
        this.dineroActual = dineroActual;
    }

    public byte tirarDado() {
        return (byte) (Math.random() * 6);
    }


    public void sederTurno(){

    }

    public void retirarse(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(double dineroActual) {
        this.dineroActual = dineroActual;
    }
}
