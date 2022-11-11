package com.edy.nomina.dominio;

public class Vendedor extends Directo{
    long ventasDelMes;
    private static final float MENOS_MINIMO = 0.045f;
    private static final float MAS_MINIMO = 0.035f;
    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    @Override
    protected long calcularSalario() {
        return super.calcularSalario() + calcularComisionVendedor();
    }
    @Override
    public String toString() {
        return getNombre()+" vendedor gana "+calcularSalario()+"\n";
    }

    private long calcularComisionVendedor(){
        if(salario<999999){
            return (long) (ventasDelMes*MENOS_MINIMO);
        } else {
            return (long) (ventasDelMes*MAS_MINIMO);
        }
    }

}
