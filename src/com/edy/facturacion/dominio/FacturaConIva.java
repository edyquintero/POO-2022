package com.edy.facturacion.dominio;

public class FacturaConIva extends Factura {
    private double iva;

    public FacturaConIva(double valor, Persona persona, double iva) {
        super(valor, persona);
        this.iva = iva;
    }

    @Override
    public double calcularTotal() {
        return super.valor + this.calcularIva();
    }

    public double calcularIva() {
        return super.valor * this.iva;
    }
}