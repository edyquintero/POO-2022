package com.edy.dispensadorCerveza.dominio;

import java.util.Scanner;

public class DispensadorCerveza {
    public String marca;
    public double capacidad;
    public double cantidadActual;
    public double temperatura;
    public Cerveza cervezaActual;
    public Tamaño tamañoVaso;

    double cantidadALlenar;
    byte eleccionVaso;
    //String nuevaCerveza="";

    public DispensadorCerveza(String marca, Cerveza cervezaActual, double cantidadActual, double capacidad, double temperatura, Tamaño tamañoVaso){
        this.marca =marca;
        this.capacidad = 6000;
        this.cantidadActual = cantidadActual;
        this.temperatura = 0;
        this.tamañoVaso = tamañoVaso;
    }

    public boolean servir(){
        Scanner in = new Scanner(System.in);
        System.out.println("Elige el tamaño del vaso\n1 = 50 ml\n2 = 250 ml\n3 = 500 ml\n4 = 1000 ml\n--->");
        this.eleccionVaso = in.nextByte();

        if (eleccionVaso==1){
            if (tamañoVaso.tamaño1<cantidadActual){
                cantidadActual -= tamañoVaso.tamaño1;
                System.out.println("Se sirvio: "+ tamañoVaso.tamaño1);
                return true;
            } else {
                System.out.println("El tamaño deseado es menor a la cantidad actual");
                return false;
            }

        } else if (eleccionVaso==2){
            if (tamañoVaso.tamaño2<cantidadActual){
                cantidadActual -= tamañoVaso.tamaño2;
                System.out.println("Se sirvio: "+ tamañoVaso.tamaño2);
                return true;
            } else {
                System.out.println("El tamaño deseado es menor a la cantidad actual");
                return false;
            }

        } else if (eleccionVaso==3){
            if (tamañoVaso.tamaño3<cantidadActual){
                cantidadActual -= tamañoVaso.tamaño3;
                System.out.println("Se sirvio: "+ tamañoVaso.tamaño3);
                return true;
            } else {
                System.out.println("El tamaño deseado es menor a la cantidad actual");
                return false;
            }

        } else if (eleccionVaso==4){
            if (tamañoVaso.tamaño4<cantidadActual){
                cantidadActual -= tamañoVaso.tamaño4;
                System.out.println("Se sirvio: "+ tamañoVaso.tamaño4);
                return true;
            } else {
                System.out.println("El tamaño deseado es menor a la cantidad actual");
                return false;
            }
        }
        else {
            System.out.println("No es una opcion valida");
            return false;
        }
    }

    public boolean cambiarTemperatura(){

        System.out.println("Ingrese la temperatura deseada");
        Scanner in = new Scanner(System.in);
        double nuevaTemperatura = in.nextDouble();

        if (nuevaTemperatura<=10 && nuevaTemperatura>=-10){
            temperatura = nuevaTemperatura;
            System.out.println("Se ha cambiado la temperatura a: "+ temperatura);
            return true;
        }
        else {
            System.out.println("La temperatura deseada no es permitida");
            return false;
        }
    }

    public boolean llenar(){
        cantidadALlenar = capacidad - cantidadActual;

        if (cantidadALlenar==0){
            System.out.println("El dispensador ya se encuentra al maximo");
            return false;
        }

        else {
            System.out.println("Se llenaron: "+cantidadALlenar+" mililitros");
            cantidadActual = capacidad;
            return true;
        }
    }

    public boolean vaciar(){
        if (cantidadActual==0){
            System.out.println("El dispensador ya se encuentra vacio");
            return false;
        }
        else {
            System.out.println("Se vaciaron: "+cantidadActual+" mililitros");
            cantidadActual = 0;
            return true;
        }
    }

    public void consultarCantidad(){
        System.out.println("La cantidad actual es: "+this.cantidadActual);
    }
}
