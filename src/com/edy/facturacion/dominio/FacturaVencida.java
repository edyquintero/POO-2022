package com.edy.facturacion.dominio;

public class FacturaVencida extends Factura{
    long diasVencidos;
    double MORA;

    public FacturaVencida(double valor, Persona persona, long diasVencidos, double MORA) {
        super(valor, persona);
        this.diasVencidos = diasVencidos;
        this.MORA = MORA;
    }

    @Override
    public double calcularTotal() {
        return (valor + calcularAumento());
    }

    public double calcularAumento(){
        return diasVencidos * MORA;
    }
}