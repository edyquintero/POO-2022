package com.edy.concesionario.app;

import com.edy.concesionario.dominio.Concesionario;
import com.edy.concesionario.dominio.Moto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppConcesionario {
    public static <Motos> void main(String[] args) {
        byte opcion;
        Concesionario conce = new Concesionario("UcoMotos");

        Scanner teclado = new Scanner(System.in);

        System.out.println("|---------------------------------------------------------|\n"+
                "|--------Bienvenido a su concecionario electronico--------|\n"+
                "|---------------------------------------------------------|");

        while (true){
            System.out.println("\n\t1 - Ingresar una moto al concesionario\n\t2 - Buscar moto\n\t3 - Vender Moto\n\t" +
                    "4 - Mostrar motos disponibles\n\t5 - Mostrar capacidad actual del concesionario\n\t6 - Salir\n\n--->");

            opcion = teclado.nextByte();

            switch (opcion){
                case 1:
                    long serial;
                    String marca, validacion;
                    int precio, cilindraje;
                    boolean esNueva, bienAgregada;

                    System.out.println("El serial de la moto es: ");
                    serial = teclado.nextLong();

                    System.out.println("La marca de la moto es: ");
                    marca = teclado.next();

                    System.out.println("El precio de la moto es: ");
                    precio = teclado.nextInt();

                    System.out.println("El cilindraje de la moto es: ");
                    cilindraje = teclado.nextInt();

                    System.out.println("¿La moto es nueva?: ");
                    validacion= teclado.next();
                    if (validacion.equalsIgnoreCase("si")){
                        esNueva = true;
                    } else {
                        esNueva = false;
                    }

                    bienAgregada = conce.ingresarNuevaMoto(serial, marca, precio, cilindraje, esNueva);
                    if (bienAgregada){
                        System.out.println("La moto ha sido agregada exitosamente");
                    } else {
                        System.out.println("No se ha podido agregar la moto al concesionario\n\tVerifique los datos suministrados e intente nuevamente");
                    }

                case 2:

                case 3:

                case 4:
                    //List<Moto> motosAMostrar = conce.mostrarMotosDisponibles();
                    //motosAMostrar.forEach(moto -> System.out.println("Moto "+moto.getMarca()+", serial: "+moto.getSerial()+", cc: "+moto.getCilindraje()));
                case 5:

                case 6:
            }

        }
    }
}
