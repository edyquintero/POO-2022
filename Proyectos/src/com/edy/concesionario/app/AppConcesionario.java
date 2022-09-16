package com.edy.concesionario.app;

import com.edy.concesionario.dominio.Concesionario;
import com.edy.concesionario.dominio.Moto;

import java.util.List;
import java.util.Scanner;

public class AppConcesionario {
    public static void main(String[] args) {
        byte opcion;
        Concesionario concesionario = new Concesionario("UcoMotos");

        Scanner teclado = new Scanner(System.in);

        System.out.println("|---------------------------------------------------------|\n"+
                "|--------Bienvenido a su concecionario electronico--------|\n"+
                "|---------------------------------------------------------|");

        while (true){
            System.out.println("\n\t1 - Ingresar una moto al concesionario\n\t2 - Buscar moto\n\t3 - Vender Moto\n\t" +
                    "4 - Mostrar motos disponibles\n\t5 - Mostrar capacidad actual del concesionario\n\t6 - Salir\n\n--->");

            opcion = teclado.nextByte();

            if (opcion==1){
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

                bienAgregada = concesionario.ingresarNuevaMoto(serial, marca, precio, cilindraje, esNueva);
                if (bienAgregada){
                    System.out.println("La moto ha sido agregada exitosamente");
                } else {
                    System.out.println("No se ha podido agregar la moto al concesionario\n\tVerifique los datos suministrados e intente nuevamente");
                }
            } else if (opcion==2) {
                System.out.println("|---------------------BUSCAR---------------------|\n\t1 - Buscar por el serial\n\t2 - Buscar por la marca\n\t" +
                        "3 - Buecar las motos nuevas\n\t4 - Mostrar motos con silindraje mayor a --->");
                opcion = teclado.nextByte();
                if (opcion==1){
                    long serial;
                    System.out.println("El serial de la moto a buscar es: ");
                    serial = teclado.nextLong();
                    Moto motoBuscada = concesionario.buscarSerial(serial);
                    if (motoBuscada!= null){
                        System.out.println("La moto encontrada fue: \n\n\t"+motoBuscada.getMarca()+" ("+motoBuscada.getCilindraje()+") serial --> "+
                                motoBuscada.getSerial()+", precio --> $"+motoBuscada.getPrecio()+" (nueva = "+motoBuscada.isEsNueva()+")");
                    } else {
                        System.out.println("Ninguna moto fue encontrada con este serial");
                    }
                } else if (opcion==2) {
                    String marca;
                    System.out.println("La marca de la moto es: ");
                    marca = teclado.next();
                    List<Moto> motosEncontradas = concesionario.buscarMarca(marca);
                    if (motosEncontradas!=null){
                        System.out.println("Las motos encontradas fueron: ");
                        motosEncontradas.forEach(moto -> System.out.println("\n\t"+moto.getMarca()+" ("+moto.getCilindraje()+") serial --> "+
                                moto.getSerial()+", precio --> $"+moto.getPrecio()+" (nueva = "+moto.isEsNueva()+")"));
                    } else {
                        System.out.println("No se han encontrado motos de esta marca");
                    }
                } else if (opcion==3) {
                    List<Moto> motosEncontradas = concesionario.buscarMotosNuevas(true);
                    if (motosEncontradas!=null){
                        System.out.println("Las motos encontradas fueron: ");
                        motosEncontradas.forEach(moto -> System.out.println("\n\t"+moto.getMarca()+" ("+moto.getCilindraje()+") serial --> "+
                                moto.getSerial()+", precio --> $"+moto.getPrecio()+" (nueva = "+moto.isEsNueva()+")"));
                    } else {
                        System.out.println("No se han encontrado motos nuevas");
                    }
                } else if (opcion==4) {
                    int cilindraje;
                    System.out.println("El cilindraje minimo a encontrar es: ");
                    cilindraje = teclado.nextInt();
                    List<Moto> motosEncontradas = concesionario.buscarMotoCilindraje(cilindraje);
                    if (motosEncontradas!=null){
                        System.out.println("Las motos encontradas fueron: ");
                        motosEncontradas.forEach(moto -> System.out.println("\n\t"+moto.getMarca()+" ("+moto.getCilindraje()+") serial --> "+
                                moto.getSerial()+", precio --> $"+moto.getPrecio()+" (nueva = "+moto.isEsNueva()+")"));
                    } else {
                        System.out.println("No se han encontrado motos con cilindrame mayor al ingresado");
                    }
                } else {
                    System.out.println("Opcion invalida");
                }
            } else if (opcion==3) {
                long serial;
                boolean vendida;
                System.out.println("Ingrese el serial de la moto a vender: ");
                serial = teclado.nextLong();
                Moto motoAVender = concesionario.buscarSerial(serial);
                vendida = concesionario.venderMoto(serial);
                if (vendida){
                    concesionario.setCapacidadActual(concesionario.getCapacidadActual()-1);;
                    System.out.println("La moto vendida ha sido:\n\t"+motoAVender.getMarca()+" ("+motoAVender.getCilindraje()+") serial --> "+
                            motoAVender.getSerial()+", precio --> $"+motoAVender.getPrecio()+" (nueva = "+motoAVender.isEsNueva()+")");
                } else {
                    System.out.println("La moto no se ha podido vender");
                }

            } else if (opcion==4) {
                List<Moto> motosAMostrar = concesionario.mostrarMotosDisponibles();
                System.out.println("Las motos encontradas fueron: ");
                motosAMostrar.forEach(moto -> System.out.println("\n\t"+moto.getMarca()+" ("+moto.getCilindraje()+") serial --> "+
                        moto.getSerial()+", precio --> $"+moto.getPrecio()+" (nueva = "+moto.isEsNueva()+")"));

            } else if (opcion==5) {
                int capacidad = concesionario.mostrarCapacidadConcesionario();
                System.out.println("La capacidad actual del concesionario es: "+capacidad);
            } else if (opcion==6) {
                break;
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }
}
