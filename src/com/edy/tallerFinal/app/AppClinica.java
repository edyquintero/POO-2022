package com.edy.tallerFinal.app;

import com.edy.tallerFinal.dominio.Oftalmologo;

public class AppClinica {
    public static void main(String[] args) {
        Oftalmologo edy = new Oftalmologo("Edy");

        edy.agregar(edy.revisarPaciente("alex", 20));
        edy.agregar(edy.revisarPaciente("camilo", 20));
        edy.agregar(edy.revisarPaciente("andrea", 29));
        edy.agregar(edy.revisarPaciente("andres", 59));

        edy.getPacientesAOperar().forEach(paciente -> System.out.println(paciente.getNombre()+" - "+paciente.getEdad()+", operar --> "+ paciente.isNecesitaCirugia()));
        System.out.println("\nOperando\n");
        edy.operarPacientes();
        edy.getPacientesAOperar().forEach(paciente -> System.out.println(paciente.getNombre()+" - "+paciente.getEdad()+", operar --> "+ paciente.isNecesitaCirugia()));
        System.out.println("fin");
    }
}
