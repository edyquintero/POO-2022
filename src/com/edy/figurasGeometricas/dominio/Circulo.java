package com.edy.figurasGeometricas.dominio;

public class Circulo extends FiguraGeometrica{
    byte radio;

    public Circulo(byte radio) {
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        System.out.println("El area del circulo es " +Math.PI*radio*radio);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("El perimetro del circulo es "+Math.PI*radio*2);
    }
}
