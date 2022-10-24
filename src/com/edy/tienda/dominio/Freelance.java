package com.edy.tienda.dominio;

public class Freelance extends Empleado{
    public long valorHora;
    public int horasTrabajadas;

    public Freelance(String nombre, long valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    protected long calcularSalario() {
        return valorHora*horasTrabajadas;
    }
}
