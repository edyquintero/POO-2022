package com.edy.tienda.dominio;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    protected abstract long calcularSalario();
}
