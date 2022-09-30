package com.edy.centroComercial.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CentroComercial {
    public static final byte CAPACIDAD = 100;
    private String nombre;
    private List<Tienda> tiendas = new ArrayList<>();

    public CentroComercial(String nombre) {
        this.nombre = nombre;
    }

    public boolean abrirTienda(long codigo, String nombre, List categorias){
         if (buscarTienda(codigo)==null&&buscarTienda(nombre)==null&&cantidadDeTiendas()<CAPACIDAD){
             Tienda tienda = new Tienda(codigo, nombre, categorias);
             tiendas.add(tienda);
             return true;
         }
         return false;
    }

    public void cerrarTienda(long codigo){
        tiendas.removeIf(tienda -> tienda.getCodigo()==codigo);
    }

    public Tienda buscarTienda(String nombre){
        return tiendas.stream().filter(tienda -> tienda.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public Tienda buscarTienda(long codigo){
        return tiendas.stream().filter(tienda -> tienda.getCodigo()==codigo).findFirst().orElse(null);
    }

    public List buscarTiendas(String categoria ){
        return tiendas.stream().filter(tienda -> tienda.getCategorias().contains(categoria)).collect(Collectors.toList());
    }

    public List obtenerTiendasConMasDeDosCategorias(){
        return tiendas.stream().filter(tienda -> tienda.getCategorias().size()>1).collect(Collectors.toList());
    }

    public void ordenarTiendasPorNombre(){
        this.tiendas.sort(Comparator.comparing(Tienda::getNombre));
    }

    public List obtenerTodasLasTiendas(){
        return tiendas;
    }

    public int cantidadDeTiendas(){
        return tiendas.size();
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }
}
