package com.edy.dispensadorSnack.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaquinaDispensadora {
    private String marca;
    private byte codigo = 1;
    private byte cantidadDeSnacks = 0;
    List<snack> snacks = new ArrayList<>();

    public MaquinaDispensadora() {

    }

    public void agregarSnack(snack snack, byte cantidadDeSnaks){
        snack.setCodigo(codigo);
        snacks.add(snack);
        System.out.println("Snak agregado exitosamente");
        this.cantidadDeSnacks+=1;
        this.codigo+=1;
    }

    public void sacarUnidadSnackCodigo(byte snackASacar){
        for(snack i: snacks){

            if(i.getCodigo() == snackASacar && i.getCantidad() != 0){
                i.setCantidad((byte) (i.getCantidad() - 1));
                System.out.println("Se ha sacado una unidad del snack con codigo ("+snackASacar+ ") correctamente");
                return;
            }
        }
        System.out.println("No se ha encontrado un snack con este codigo");
    }

        //this.snaks.forEach(snak -> {if(snak.getCodigo()==snakASacar);
        //                    snak.setCantidad((byte) (snak.getCantidad()-1));

      //  System.out.println("Se ha sacado una unidad del snak con codigo ("+snakASacar+ ") correctamente");
    //});



    public void sacarUnidadSnackNombre(String snackASacar){
        for(snack i: snacks){

            if(i.getProducto().equals(snackASacar) && i.getCantidad() != 0){
                i.setCantidad((byte) (i.getCantidad() - 1));
                System.out.println("Se ha sacado una unidad del snack con nombre: ("+snackASacar+ ") correctamente");
                return;
            }
        }
        System.out.println("No se ha encontrado un snack con este nombre");
    }

    public void aumentarCantidadSnackCodigoONombre(byte codigo, String producto){
        for(snack i: snacks){

            if(i.getCodigo()==codigo || i.getProducto().equalsIgnoreCase(producto)){
                i.setCantidad((byte) (i.getCantidad() + 1));
                System.out.println("Se ha aumentado una unidad del snack seleccionado correctamente");
                return;
            }
        }
        System.out.println("No se ha encontrado este snack");
    }

    public void quitarSnack(byte snackAEliminar){
        if (snacks.removeIf(contacto ->contacto.getCodigo()==snackAEliminar)){
            System.out.println("El snack se eliminó correctamente");
        } else {
            System.out.println("El snack a eliminar no esta presente en la lista de snaks");
        }
        this.cantidadDeSnacks= (byte) (this.getCantidadDeSnacks()-1);
    }

    public void cantidadActualSnack(byte codigo, String producto){
        for(snack i: snacks){

            if(i.getCodigo()==codigo || i.getProducto().equalsIgnoreCase(producto)){
                System.out.println("("+i.getCodigo()+") "+i.getProducto()+": "+i.getCantidad()+" unidades"+" --> "+i.getPrecio());
                return;
            }
        }
        System.out.println("No se ha encontrado este snack");
    }

    public void snacksAgotados(){
        for(snack i: snacks){

            if(i.getCantidad()==0){
                System.out.println("("+i.getCodigo()+") "+i.getProducto()+": "+i.getCantidad()+" unidades"+" --> "+i.getPrecio());
                return;
            }
        }
        System.out.println("No se ha encontrado un snack agotado");
    }

    public void nombreYUnidadesSnacks(){
        this.snacks.forEach(c -> System.out.println("("+c.getCodigo()+") "+c.getProducto()+": "+c.getCantidad()+" unidades"+" --> "+c.getPrecio()));
    }

    public void ordenarPrecioMayorAMenor(){
        if (cantidadDeSnacks!=0){
            this.snacks.sort(Comparator.comparing(snack::getPrecio)
                    .thenComparing(snack::getPrecio));
            System.out.println("Se han ordenado los snacks por su precio.");
            this.snacks.forEach(c -> System.out.println("("+c.getCodigo()+") "+c.getProducto()+": "+c.getCantidad()+" unidades"+" --> "+c.getPrecio()));
        } else {
            System.out.println("Su mauquina dispensadora aun se encuenta vacia");
        }
    }

    public void ordenarCantidadUnidadesMenorAmayor(){
        if (cantidadDeSnacks!=0){
            this.snacks.sort(Comparator.comparing(snack::getCantidad)
                    .thenComparing(snack::getCantidad));
            System.out.println("Se han ordenado los snacks por su cantidad de unidades.");
            this.snacks.forEach(c -> System.out.println("("+c.getCodigo()+") "+c.getProducto()+": "+c.getCantidad()+" unidades"+" --> "+c.getPrecio()));
        } else {
            System.out.println("Su mauquina dispensadora aun se encuenta vacia");
        }
    }

    //metodos auxiliares
    public boolean validarCantidadDeSnacks(byte cantidadDeSnacks){
        return (cantidadDeSnacks<12);
    }

    //getter y setter

    public byte getCantidadDeSnacks() {
        return cantidadDeSnacks;
    }

    public void setCantidadDeSnacks(byte cantidadDeSnaks) {
        this.cantidadDeSnacks = cantidadDeSnaks;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }
}