package com.edy.interfaces2.dominio;

public abstract class Documento extends Archivo{
    private String nombre;

    public Documento(String nombre){
        super(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
