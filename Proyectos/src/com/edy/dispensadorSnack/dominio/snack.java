package com.edy.dispensadorSnack.dominio;

public class snack {
    private String producto;
    private String marca;
    private byte cantidad=6;
    private byte codigo;
    private int precio;
    private int peso;
    private byte temperatura;

    public snack(String producto, byte codigo, int precio) {
        this.producto = producto;
        this.codigo = codigo;
        this.precio = precio;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}