package com.edy.tienda.dominio;
import com.edy.tienda.dominio.Nomina;

public class Directo extends Empleado{
    public long salario;
    private final float DESC_SALUD = 0.05F;
    private final float DESC_PENSION = 0.065F;

    public Directo(String nombre, long salario) {
        super(nombre);
        this.salario = salario;
    }

    @Override
    protected long calcularSalario() {
        return salario-calcularSalud()-calcularPension()+calcularComision();
    }

    private long calcularSalud(){
        return (long) (salario*DESC_SALUD);
    }

    private long calcularPension(){
        return (long) (salario*DESC_PENSION);
    }

    private long calcularComision(){
        long gananciaMes = 0;
        if(salario<999999){
            return (long) (gananciaMes*4.5);
        } else {
            return (long) (gananciaMes*3.5);
        }
    }
}
