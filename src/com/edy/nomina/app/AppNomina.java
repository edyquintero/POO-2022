package com.edy.nomina.app;

import com.edy.nomina.dominio.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppNomina {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();
        Empleado juan = new Directo("Juan", 4840000);
        Empleado julian = new Vendedor("Julian", 2050000, 45510000);
        Empleado carolina = new Vendedor("Carolina", 980000, 35989000);
        Empleado johanna = new Freelance("Johanna", 71000, 89);
        Empleado david = new Directo("David", 3975000);
        Empleado pedro = new Promotor("Pedro", 1200, 300, 62);
        Empleado gustavo = new Freelance("Gustavo", 42500, 65);
        nomina.añadirEmpleado(juan);
        nomina.añadirEmpleado(julian);
        nomina.añadirEmpleado(carolina);
        nomina.añadirEmpleado(johanna);
        nomina.añadirEmpleado(david);
        nomina.añadirEmpleado(pedro);
        nomina.añadirEmpleado(gustavo);

        System.out.println(nomina.calcularNomina());
        List<Directo> directos = nomina.listarDirectos();
        directos.forEach(directo -> System.out.println(directo.toString()));

        System.out.println("\n");

        List<Freelance> freelances = nomina.listarFreelancer();
        freelances.forEach(freelance -> System.out.println(freelance.toString()));






        /*final int DIRECTO = 0;
        final int FREELANCE = 1;
        final int VENDEDOR = 2;

        int eleccion, horasTrabajadas, valorHora, ventasDelMes, tipoEmpleado;
        long salario;
        String nombre;
        Empleado empleado;
        List<String> opciones = Arrays.asList("Agregar Empleado", "Mostrar Nomina", "Listar Directos", "Listar Freelancers");
        List<String> opcionesEmpleados = Arrays.asList("Directo", "Freelance", "Vendedor");

        Nomina nomina = new Nomina();
        while (true) {
            eleccion = JOptionPane.showOptionDialog(null, "", "Nomina de empleados", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones.toArray(), null);
            if (eleccion == 0) {
                nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                tipoEmpleado = JOptionPane.showOptionDialog(null, "Ingrese el tipo de contrato", "Nomina de empleados", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opcionesEmpleados.toArray(), null);

                switch (tipoEmpleado) {
                    case DIRECTO -> {
                        salario = Long.parseLong(JOptionPane.showInputDialog("Ingrese el salario"));
                        empleado = new Directo(nombre, salario);
                        nomina.añadirEmpleado(empleado);
                    }
                    case FREELANCE -> {
                        horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas"));
                        valorHora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la hora"));
                        empleado = new Freelance(nombre, valorHora, horasTrabajadas);
                        nomina.añadirEmpleado(empleado);
                    }
                    case VENDEDOR -> {
                        salario = Long.parseLong(JOptionPane.showInputDialog("Ingrese el salario"));
                        ventasDelMes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ventas del mes"));
                        empleado = new Vendedor(nombre, salario, ventasDelMes);
                        nomina.añadirEmpleado(empleado);
                    }
                }
            } else if (eleccion == 1) {
                JOptionPane.showMessageDialog(null,nomina.calcularNomina());
            } else if (eleccion == 2) {
                JOptionPane.showMessageDialog(null,nomina.listarDirectos());
            } else if (eleccion == 3) {

            } else if (eleccion == 4) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }*/
    }
}