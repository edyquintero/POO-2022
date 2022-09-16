package com.edy.concesionario.dominio;

import com.edy.agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.List;

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
            return true;
        } else {
            return false;
        }
    }

    public Moto buscarSerial(long serialABuscar){
        Moto motoBuscada = this.motos.stream().filter(moto -> moto.getSerial()==serialABuscar).findFirst().orElse(null);
        return motoBuscada;
    }

    public void buscarMarca(String marca){
        return;
    }

    public void buscarMotosNuevas(boolean soloNuevas){
        return;
    }

    public void buscarMotoCilindraje(int cilindraje){
        return;
    }

    public void venderMoto(Moto moto){
        return;
    }

    public List mostrarMotosDisponibles(){
        return motos;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }
}
