package com.edy.dispensadorSnack.app;

import com.edy.dispensadorSnack.dominio.MaquinaDispensadora;
import com.edy.dispensadorSnack.dominio.snack;

import java.util.Scanner;

public class AppDispensadora {
    public static void main(String[] args) {
        byte accion;

        Scanner in = new Scanner(System.in);

        MaquinaDispensadora dispensadora = new MaquinaDispensadora();

        System.out.println("-----------Bienvenido a su maquina dispensadora-----------");

        while (true) {

            System.out.println("\n\t1 - Agregar un nuevo snack\n\t2 - Sacar un snack por su codigo\n\t3 - Sacar un snack por su nombre\n\t" +
                    "4 - Aumentar la cantidad de unidades de un snack\n\t5 - Quitar un snack\n\t6 - Obtener cantidad de unidades de un snack\n\t" +
                    "7 - Obtener nombres snacks agotados\n\t8 - Obtener nombres y cantidad de snacks actuales\n\t"+
                    "9 - Ordenar la lista por precio\n\t10 - Ordenar la lista por cantidad\n\t11 - Salir\n\n--->");

            accion = in.nextByte();

            Scanner teclado = new Scanner(System.in);

            if (accion == 1) {
                if (dispensadora.validarCantidadDeSnacks(dispensadora.getCantidadDeSnacks())){
                    String nombreSnack;
                    int precio;

                    System.out.println("Nombre snack: ");
                    nombreSnack = teclado.next();
                    System.out.println("El precio del snack: ");
                    precio = teclado.nextInt();

                    snack snack = new snack(nombreSnack, dispensadora.getCodigo(), precio);
                    dispensadora.agregarSnack(snack, dispensadora.getCantidadDeSnacks());
                }
            } else if (accion == 2) {
                byte snackASacar;

                System.out.println("Codigo del snack: ");
                snackASacar = teclado.nextByte();

                dispensadora.sacarUnidadSnackCodigo(snackASacar);
            } else if (accion == 3) {
                String  snackASacar;

                System.out.println("Nombre del snack: ");
                snackASacar = teclado.next();

                dispensadora.sacarUnidadSnackNombre(snackASacar);
            } else if (accion == 4) {
                System.out.println("\n\t1 - Aumentar por codigo\n\t2 - Aumentar por nombre\n\t--->");
                byte decision;
                decision=teclado.nextByte();
                if (decision==1){
                    byte snackAAumentar;

                    System.out.println("Codigo del snack: ");
                    snackAAumentar = teclado.nextByte();
                    dispensadora.aumentarCantidadSnackCodigoONombre(snackAAumentar, null);
                } else if (decision==2) {
                    String  snackAAumentar;

                    System.out.println("Nombre del snack: ");
                    snackAAumentar = teclado.next();
                    dispensadora.aumentarCantidadSnackCodigoONombre((byte) 0, snackAAumentar);
                }else {
                    System.out.println("Opcion invalida");
                }
            } else if (accion == 5) {
                byte numeroAEliminar;

                System.out.println("Numero: ");
                numeroAEliminar = teclado.nextByte();
                dispensadora.quitarSnack(numeroAEliminar);
            } else if (accion == 6) {
                System.out.println("\n\t1 - Buscar por codigo\n\t2 - Buscar por nombre\n\t--->");
                byte decision;
                decision=teclado.nextByte();
                if (decision==1){
                    byte snackABuscar;

                    System.out.println("Codigo del snack: ");
                    snackABuscar = teclado.nextByte();
                    dispensadora.cantidadActualSnack(snackABuscar, null);
                } else if (decision==2) {
                    String  snackABuscar;

                    System.out.println("Nombre del snack: ");
                    snackABuscar = teclado.next();
                    dispensadora.cantidadActualSnack((byte) 0, snackABuscar);
                }else {
                    System.out.println("Opcion invalida");
                }
            } else if (accion == 7) {
                dispensadora.snacksAgotados();
            } else if (accion == 8) {
                dispensadora.nombreYUnidadesSnacks();
            } else if (accion == 9) {
                dispensadora.ordenarPrecioMayorAMenor();
            } else if (accion == 10) {
                dispensadora.ordenarCantidadUnidadesMenorAmayor();
            } else {
                break;
            }
            }
        }
    }
