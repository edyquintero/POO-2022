package com.edy.dispensadorSnak.dominio;

import com.edy.dispensadorSnak.app.AppDispensadora;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDispensadora {
    private String marca;
    private byte codigo = 1;
    private byte cantidadDeSnaks = 0;
    List<Snak> snaks = new ArrayList<>();

    public MaquinaDispensadora() {

    }

    public void agregarSnak(Snak snak, byte cantidadDeSnaks){
        snaks.add(snak);
        System.out.println("Snak agregado exitosamente");
        this.cantidadDeSnaks+=1;
        this.codigo+=1;
    }

    public void sacarUnidadSnakCodigo(byte snakASacar){
            System.out.println("Se ha sacado una unidad del snak con codigo ("+snakASacar+ ") correctamente");
        } {
            System.out.println("El contacto a eliminar no esta presente en la lista de contactos");
        }


    public void sacarUnidadSnakNombre(){

    }

    public void aumentarCantidadSnakCodigoONombre(){

    }

    public void quitarSnak(){

    }

    public void cantidadActualSnak(){

    }

    public void snaksAgotados(){

    }

    public void nombreYUnidadesSnaks(){
        this.snaks.forEach(c -> System.out.println("("+c.getCodigo()+") "+c.getProducto()+": "+c.getCantidad()+" unidades"));
    }

    public void ordenarPrecioMayorAMenor(){

    }

    public void ordenarCantidadUnidadesMenorAmayor(){

    }

    //metodos auxiliares
    public boolean validarCantidadDeSnaks(byte cantidadDeSnaks){
        return (cantidadDeSnaks<=12);
    }

    //getter y setter

    public byte getCantidadDeSnaks() {
        return cantidadDeSnaks;
    }

    public void setCantidadDeSnaks(byte cantidadDeSnaks) {
        this.cantidadDeSnaks = cantidadDeSnaks;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }
}