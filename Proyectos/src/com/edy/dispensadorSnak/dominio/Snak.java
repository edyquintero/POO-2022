package com.edy.dispensadorSnak.dominio;

public class Snak {
    private String producto;
    private String marca;
    private byte cantidad;
    private byte codigo;
    private int peso;
    private byte temperatura;

    public Snak(String producto, byte cantidad, byte codigo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public byte getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }
}