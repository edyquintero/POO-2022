package com.edy.facturacion.dominio;

public class FacturaConDescuento extends Factura{
    private double descuento;

    public FacturaConDescuento(double valor, Persona persona, double descuento) {
        super(valor, persona);
        this.descuento = descuento;
    }

    @Override
    public double calcularTotal() {
        return super.valor - calcularDescuento();
    }

    private double calcularDescuento() {
        return (super.valor * this.descuento);
    }
}