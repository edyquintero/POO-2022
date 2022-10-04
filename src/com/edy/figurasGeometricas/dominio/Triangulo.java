package com.edy.figurasGeometricas.dominio;

public class Triangulo extends FiguraGeometrica{
    byte lado1;
    byte lado2;
    byte lado3;
    byte altura;

    public Triangulo(byte lado1, byte lado2, byte lado3, byte altura) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.altura = altura;
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("El perimetro del triagulo es "+ lado1 + lado2 + lado3);
    }

    @Override
    public void calcularArea() {
        System.out.println("El area del triangulo es "+(lado1*altura)/2);
    }
}
