package com.edy.nomina.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<>();
    }

    public void añadirEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<String> calcularNomina(){
        List<String> nomina = new ArrayList<>();
        for (Empleado empleado : empleados) {
            nomina.add(empleado.toString());
        }
        return nomina;
    }

    public List<Directo> listarDirectos(){
        List<Directo> directos = new ArrayList<>();
        for (Empleado empleado: empleados){
            if(empleado instanceof Directo){
                directos.add((Directo)empleado);
            }
        }
        return directos;
    }

    public List<Freelance> listarFreelancer(){
        List<Freelance> freelancers = new ArrayList<>();
        for (Empleado empleado: empleados){
            if(empleado instanceof Freelance){
                freelancers.add((Freelance) empleado);
            }
        }
        return freelancers;
    }
}