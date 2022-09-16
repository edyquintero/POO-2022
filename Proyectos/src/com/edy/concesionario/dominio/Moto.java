package com.edy.concesionario.dominio;

public class Moto {
    private long serial;
    private String marca;
    private int precio;
    private int cilindraje;
    private boolean esNueva;

    public Moto(long serial, String marca, int precio, int cilindraje, boolean esNueva) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.esNueva = esNueva;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public boolean isEsNueva() {
        return esNueva;
    }

    public void setEsNueva(boolean esNueva) {
        this.esNueva = esNueva;
    }
}
