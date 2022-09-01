package com.edy.dispensadorSnak.app;

import com.edy.dispensadorSnak.dominio.MaquinaDispensadora;
import com.edy.dispensadorSnak.dominio.Snak;

import java.util.Scanner;

public class AppDispensadora {
    public static void main(String[] args) {
        byte accion;

        Scanner in = new Scanner(System.in);

        MaquinaDispensadora dispensadora = new MaquinaDispensadora();

        System.out.println("-----------Bienbenido a su maquina dispensadora-----------");

        while (true) {

            System.out.println("\n\t1 - Agregar un nuevo snak\n\t2 - Sacar un snak por su codigo\n\t3 - Sacar un snak por su nombre\n\t" +
                    "4 - Aumentar la cantidad de unidades de un snak\n\t5 - Quitar un snak\n\t6 - Obtener cantidad de unidades de un snak\n\t" +
                    "7 - Obtener nombres snaks agotados\n\t8 - Obtener nombres y cantidad de snaks actuales\n\t"+
                    "9 - Ordenar la lista por precio\n\t10 - Ordenar la lista por cantidad\n\t11 - Salir\n\n--->");

            accion = in.nextByte();

            Scanner teclado = new Scanner(System.in);

            if (accion == 1) {
                if (dispensadora.validarCantidadDeSnaks(dispensadora.getCantidadDeSnaks())){
                    String nombreSnak;
                    byte cantidad;

                    System.out.println("Nombre snak: ");
                    nombreSnak = teclado.next();
                    System.out.println("Cantidad snak: ");
                    cantidad = teclado.nextByte();

                    if(cantidad<7){
                        Snak snak = new Snak(nombreSnak, cantidad, dispensadora.getCodigo());
                        dispensadora.agregarSnak(snak, dispensadora.getCantidadDeSnaks());
                    } else {
                        System.out.println("La cantidad deseada a agregar es mayor a la permitida");
                    }
                } else {
                    System.out.println("\nLa candidad de snaks ya exedió el limite");
                }
            } else if (accion == 2) {
                byte snakASacar;

                System.out.println("Codigo del snak: ");

                snakASacar = teclado.nextByte();
                dispensadora.sacarUnidadSnakCodigo(snakASacar);
            } else if (accion == 3) {
                dispensadora.sacarUnidadSnakNombre();
            } else if (accion == 4) {
                dispensadora.aumentarCantidadSnakCodigoONombre();
            } else if (accion == 5) {
                dispensadora.quitarSnak();
            } else if (accion == 6) {
                dispensadora.cantidadActualSnak();
            } else if (accion == 7) {
                dispensadora.snaksAgotados();
            } else if (accion == 8) {
                dispensadora.nombreYUnidadesSnaks();
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