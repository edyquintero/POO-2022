package com.edy.dispensadorCerveza.app;

import com.edy.dispensadorCerveza.dominio.DispensadorCerveza;
import com.edy.dispensadorCerveza.dominio.Cerveza;
import com.edy.dispensadorCerveza.dominio.Tamaño;

import java.util.Scanner;

public class AppDispensador {
    public static void main(String[] args) {
        byte accion;

        Cerveza cerveza = new Cerveza("Aguila",3);
        //Cerveza cerveza2 = new Cerveza("Corona", 5);
        //Cerveza cerveza3 = new Cerveza("Redds", 7);


        Tamaño tamañoVaso = new Tamaño();
        DispensadorCerveza dispensador = new DispensadorCerveza(cerveza.marca, cerveza,0,6000,5,tamañoVaso);

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("---------DISPENSADOR CERVEZA---------\n 1 = Servir\n 2 = Cambiar temperatura\n 3 = Vaciar\n 4 = Llenar\n 5 = Consultar cantidad actual\n 6 = Salir \n--->");
            accion = in.nextByte();
            if (accion==1){
                dispensador.servir();
            } else if (accion==2) {
                dispensador.cambiarTemperatura();
            } else if (accion==3) {
                dispensador.vaciar();
            } else if (accion==4) {
                dispensador.llenar();
            } else if (accion==5) {
                dispensador.consultarCantidad();
            } else if (accion==6) {
                break;
            } else {
                System.out.println("No es una opcion valida, intente de nuevo");
            }
        }
    }
}