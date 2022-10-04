package com.edy.figurasGeometricas.app;

import com.edy.figurasGeometricas.dominio.Circulo;
import com.edy.figurasGeometricas.dominio.Cuadrado;
import com.edy.figurasGeometricas.dominio.FiguraGeometrica;
import com.edy.figurasGeometricas.dominio.Triangulo;

import java.util.ArrayList;
import java.util.List;

public class AppFigurasGeometricas {
    public static void main(String[] args) {
        List<FiguraGeometrica> listaFiguras = new ArrayList<FiguraGeometrica>();

        listaFiguras.add(new Triangulo((byte) 2, (byte) 2, (byte) 2, (byte) 3));
        listaFiguras.add(new Circulo((byte) 3));
        listaFiguras.add(new Cuadrado((byte) 4));

        listaFiguras.forEach(figura -> figura.calcularArea());
        listaFiguras.forEach(figura -> figura.calcularPerimetro());
    }
}
