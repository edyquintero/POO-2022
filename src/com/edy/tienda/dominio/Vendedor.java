package com.edy.tienda.dominio;

public class Vendedor extends Directo{
    public long ventasDelMes;
    public long salario;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }
}
