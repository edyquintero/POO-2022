package com.edy.nomina.dominio;

public class Promotor extends Empleado {
    public int volantesRepartidos;
    public int comprasVolante;
    public long valorVolante;

    public Promotor(String nombre, int volantesRepartidos, long valorVolante, int comprasVolante) {
        super(nombre);
        this.valorVolante = valorVolante;
        this.volantesRepartidos = volantesRepartidos;
        this.comprasVolante = comprasVolante;
    }

    @Override
    protected long calcularSalario() {
        return valorVolante*volantesRepartidos + comprasVolante*15000;
    }

    public String toString() {
        return getNombre()+" empleado promotor gana "+calcularSalario()+"\n";
    }
}