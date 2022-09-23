package com.edy.agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaTelefonica {
    private byte cantidadDeContactos = 0;

    List<Contacto> contactos = new ArrayList<>();

    public AgendaTelefonica(){

    }

    public void crearContacto(Contacto contacto, byte cantidadDeContactos){
        contactos.add(contacto);
        System.out.println("\nEl contacto ha sido agregado exitosamente");

        this.cantidadDeContactos= (byte) (this.getCantidadDeContactos()+1);
    }

    public void eliminarContacto(long numeroAEliminar){
        if (contactos.removeIf(contacto ->contacto.getNumero()==numeroAEliminar)){
            System.out.println("El contacto se eliminó correctamente");
        } else {
            System.out.println("El contacto a eliminar no esta presente en la lista de contactos");
        }
        this.cantidadDeContactos= (byte) (this.getCantidadDeContactos()-1);
    }

    public List<Contacto> buscarContactoNombre(String nombreABuscar){
        List<Contacto> contactosBuscados = this.contactos.stream().filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombreABuscar)).collect(Collectors.toList());
        if (cantidadDeContactos!=0){
            System.out.println("Contactos encontrados: ");
            contactosBuscados.forEach(c -> System.out.println(c.getNombre()+" "+c.getApellido()+": "+c.getNumero()));
        } else {
            System.out.println("Su agenda aun se encuenta vacia");
        }
        return contactosBuscados;
    }

    public List<Contacto> buscarContactoApellido(String apellidoABuscar){
        List<Contacto> contactosBuscados = this.contactos.stream().filter(contacto -> contacto.getApellido().equalsIgnoreCase(apellidoABuscar)).collect(Collectors.toList());
        if (cantidadDeContactos!=0){
            System.out.println("Contactos encontrados: ");
            contactosBuscados.forEach(c -> System.out.println(c.getNombre()+" "+c.getApellido()+": "+c.getNumero()));
        } else {
            System.out.println("Su agenda aun se encuenta vacia");
        }
        return contactosBuscados;
    }

    public Contacto buscarContactoNumero(long numeroABuscar){
        Contacto contactoBuscado= this.contactos.stream()
                .filter(contacto -> contacto.getNumero()==numeroABuscar)
                .findFirst()
                .orElse(null);
        System.out.println("Contacto encontrado: ");
        System.out.println(contactoBuscado.getNombre()+" "+contactoBuscado.getApellido()+": "+contactoBuscado.getNumero());
        return contactoBuscado;
    }

    public void cambiarNumeroContacto(long numeroNuevo, long numeroViejo, Contacto contactoBuscado){
        buscarContactoNumero(numeroViejo);
        contactoBuscado.setNumero(numeroNuevo);
        System.out.println("Nuevo numero del contacto: ");
        System.out.println(contactoBuscado.getNombre()+" "+contactoBuscado.getApellido()+": "+contactoBuscado.getNumero());
    }

    public void ordenarContactos(){
        if (cantidadDeContactos!=0){
            this.contactos.sort(Comparator.comparing(Contacto::getNombre)
                    .thenComparing(Contacto::getApellido));
            System.out.println("Se ha ordenado la agenda en orden alfabetico.");
            this.contactos.forEach(c -> System.out.println(c.getNombre()+" "+c.getApellido()+": "+c.getNumero()));
        } else {
            System.out.println("Su agenda aun se encuenta vacia");
        }
    }

    public void mostrarContactos(){
        if (cantidadDeContactos!=0){
            this.contactos.forEach(c -> System.out.println(c.getNombre()+" "+c.getApellido()+": "+c.getNumero()));
        } else {
            System.out.println("Su agenda aun se encuenta vacia");
        }

    }

    //metodos auxiliares
    public boolean validarCantidadDeContactos (byte cantidadDeContactos){
        if (cantidadDeContactos<=50){
            return true;
        } else {
            return false;
        }
    }

    //setters y getters
    public byte getCantidadDeContactos() {
        return cantidadDeContactos;
    }
}