package com.edy.dispensadorCerveza.dominio;

public class Cerveza {
    public String marca;
    public double añoFabricacion;
    public String apariencia;
    public String sabor;
    public double cantidadC02;
    //public double porcentajeAlcohol;
    public double temperaturaRecomendada;

    public Cerveza(String marca, double temperaturaRecomendada) {
        this.marca = marca;
        //this.porcentajeAlcohol = porcentajeAlcohol;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }
    //public String marca1 = "aguila";
    //public String marca2 = "corona";
    //public String marca3 = "redds";
}