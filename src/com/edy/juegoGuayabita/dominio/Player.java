package com.edy.juegoGuayabita.dominio;

public class Player {
    String nombre;
    double dinero;

    public Player(String nombre, double dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
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
