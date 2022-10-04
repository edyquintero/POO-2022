package com.edy.figurasGeometricas.dominio;

public class Cuadrado extends FiguraGeometrica{
    byte medidaLado;

    public Cuadrado(byte medidaLado) {
        this.medidaLado = medidaLado;
    }

    @Override
    public void calcularArea() {
        System.out.println("El area del cuadrado es "+medidaLado*medidaLado);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("El perimetro del cuadrado es "+4*medidaLado);
    }
}
