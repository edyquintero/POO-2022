package com.edy.nomina.dominio;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    protected abstract long calcularSalario();

    public String getNombre() {
        return nombre;
    }

}
