package com.edy.concesionario.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Concesionario {
    private String nombre;
    public static final int CAPACIDAD_TOTAL = 15;
    private  int capacidadActual = 0;
    List<Moto> motos = new ArrayList<>();


    public Concesionario(String nombre) {
        this.nombre = nombre;
    }

    public boolean ingresarNuevaMoto(long serial, String  marca, int precio, int cilindraje, boolean esNueva){
        if (buscarSerial(serial) == null && capacidadActual<CAPACIDAD_TOTAL){
            Moto moto = new Moto(serial, marca, precio, cilindraje, esNueva);
            this.motos.add(moto);
            capacidadActual++;
            return true;
        } else {
            return false;
        }
    }

    public Moto buscarSerial(long serialABuscar){
        Moto motoBuscada = this.motos.stream().filter(moto -> moto.getSerial()==serialABuscar).findFirst().orElse(null);
        return motoBuscada;
    }

    public List buscarMarca(String marca){
        return this.motos.stream().filter(moto -> moto.getMarca().equalsIgnoreCase(marca)).collect(Collectors.toList());
    }

    public List buscarMotosNuevas(boolean soloNuevas){
        return this.motos.stream().filter(Moto::isEsNueva).collect(Collectors.toList());
    }

    public List buscarMotoCilindraje(int cilindraje){
        return this.motos.stream().filter(moto -> moto.getCilindraje()>cilindraje).collect(Collectors.toList());
    }

    public boolean venderMoto(long serial){
        return this.motos.removeIf(moto -> moto.getSerial()==buscarSerial(serial).getSerial());
    }

    public List mostrarMotosDisponibles(){
        return motos;
    }

    public int mostrarCapacidadConcesionario(){
        return this.CAPACIDAD_TOTAL - this.capacidadActual;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }
}
