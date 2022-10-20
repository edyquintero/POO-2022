package com.edy.juegoGuayabita3.dominio;

public class Player3 {
    String nombre;
    double dinero;

    public Player3(String nombre, double dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public byte tirarDado() {
        return (byte) (Math.random() * 6 + 1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}
