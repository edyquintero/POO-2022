package com.edy.agenda.app;

import com.edy.agenda.dominio.AgendaTelefonica;
import com.edy.agenda.dominio.Contacto;

import java.util.List;
import java.util.Scanner;

public class AppAgenda {
    public static void main(String[] args) {
        byte accion;

        Scanner in = new Scanner(System.in);

        AgendaTelefonica agenda = new AgendaTelefonica();

        System.out.println("|--------------------------------------------------------|\n"+
                "|-----------Bienbenido a su agenda electronica-----------|\n"+
                "|--------------------------------------------------------|");

        while (true){

            System.out.println("\n\t1 - Crear un nuevo contacto\n\t2 - Eliminar un contacto\n\t" +
                    "3 - Buscar un contacto por su nombre\n\t4 - Buscar un contacto por su apellido\n\t" +
                    "5 - Buscar un contacto por su numero\n\t6 - Cambiar numero de un contacto\n\t" +
                    "7 - Ordenar los contactos\n\t8 - Mostrar lista de contactos\n\t9 - Salir\n\n--->");

            accion = in.nextByte();


            Scanner teclado=new Scanner(System.in);


            if (accion==1){
                if (agenda.validarCantidadDeContactos(agenda.getCantidadDeContactos())){
                    String nombre, apellido;
                    long numero;

                    System.out.println("Nombre: ");
                    nombre = teclado.next();
                    System.out.println("Apellido: ");
                    apellido = teclado.next();
                    System.out.println("Numero: ");
                    numero = teclado.nextLong();

                    Contacto contacto = new Contacto(nombre, apellido, numero);
                    agenda.crearContacto(contacto, agenda.getCantidadDeContactos());
                } else {
                    System.out.println("\nLa candidad de contactos ya exedió el limite");
                }

            } else if (accion==2) {
                long numeroAEliminar;

                System.out.println("Numero: ");
                numeroAEliminar = teclado.nextLong();

                agenda.eliminarContacto(numeroAEliminar);
            }
            else if (accion==3) {
                String nombreABuscar;

                System.out.println("Ingrese el nombre del contacto a buscar: ");
                nombreABuscar = teclado.next();
                agenda.buscarContactoNombre(nombreABuscar);

            } else if (accion==4) {
                String apellidoABuscar;

                System.out.println("Ingrese el apellido del contacto a buscar: ");
                apellidoABuscar = teclado.next();

                agenda.buscarContactoApellido(apellidoABuscar);
            } else if (accion==5) {
                long numeroABuscar;

                System.out.println("Ingrese el numero del contacto a buscar: ");
                numeroABuscar = teclado.nextLong();
                agenda.buscarContactoNumero(numeroABuscar);
            } else if (accion==6) {
                long numeroViejo, numeroNuevo;
                System.out.println("Ingrese el numero que desea cambiar: ");
                numeroViejo = teclado.nextLong();
                System.out.println("Ingrese el numero por el cual lo desea cambiar: ");
                numeroNuevo = teclado.nextLong();
                agenda.cambiarNumeroContacto(numeroNuevo,numeroViejo,agenda.buscarContactoNumero(numeroViejo));

            } else if (accion==7) {
                agenda.ordenarContactos();
            } else if (accion==8) {
                agenda.mostrarContactos();
            } else if (accion==9) {
                break;
            } else {
                System.out.println("\nOpción invalida\n");
            }
        }
    }
}