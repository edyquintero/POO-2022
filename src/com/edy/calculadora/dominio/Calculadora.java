package com.edy.calculadora.dominio;

public class Calculadora {
    private String nombre;

    public Calculadora(String nombre) {
        this.nombre = nombre;
    }

    public double sumar(double numero1, double numero2){
        return numero1 + numero2;
    }
    public double restar(double numero1, double numero2){
        return numero1 - numero2;
    }
    public double multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }
    public double dividir(double numero1, double numero2){
        return numero1 / numero2;
    }

}
