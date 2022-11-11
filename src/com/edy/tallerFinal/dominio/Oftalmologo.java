package com.edy.tallerFinal.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Oftalmologo {
    List<Paciente> pacientesAOperar = new ArrayList<Paciente>();
    private String nombre;

    public Oftalmologo(String nombre) {
        this.nombre = nombre;
    }

    public Paciente revisarPaciente(String nombre, int edad){
        nombre.toUpperCase();
        if (nombre.startsWith("a")&&edad<40){
            return new PacienteApto(nombre, edad, true);
        } else {
            return new PacienteNoApto(nombre, edad, false);
        }
    }

    public void operarPacientes(){
        pacientesAOperar.forEach(paciente -> {if(paciente instanceof PacienteApto) {((PacienteApto) paciente).operar();}});
    }

    public List<Paciente> getPacientesAOperar() {
        return pacientesAOperar.stream().filter(paciente -> paciente.isNecesitaCirugia()).collect(Collectors.toList());
    }

    public void agregar(Paciente paciente) {
        this.pacientesAOperar.add(paciente);
    }
}
