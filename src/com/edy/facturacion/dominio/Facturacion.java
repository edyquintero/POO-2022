package com.edy.facturacion.dominio;

import com.edy.facturacion.dominio.Persona;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class Facturacion {
    private static final double IVA_19 = 0.19;
    private static final double MORA = 0.03;
    private static final double DESCUENTO = 0.2;
    private List<Factura> facturas;

    public Facturacion() {
        this.facturas = new ArrayList<>();
    }

    public void crearFactura(Persona persona, double valor, LocalDateTime fecha) {
        Factura factura;

        if (diasVencidos(fecha, LocalDateTime.now()) != 0){
        //if (fecha.isBefore(LocalDateTime.now())){
            long diasVencidos = diasVencidos(fecha, LocalDateTime.now());
            factura = new FacturaVencida(valor, persona, diasVencidos, MORA);
        } else if (comienzaVocal(persona.getNombre())) {
            factura = new FacturaConDescuento(valor, persona, DESCUENTO);
        } else if (persona.getNombre().length()<5){
            factura = new FacturaSinIva(valor, persona);
        } else {
            factura = new FacturaConIva(valor,persona, IVA_19);
        }

        this.facturas.add(factura);
    }

    public List<String> obtenerInfoFacturas(){
        return this.facturas.stream().map(fac -> {
            return "Factura #" + fac.numero + " a nombre de " + fac.persona.getNombre() + " - $" + fac.calcularTotal() + "\n";
        }).collect(Collectors.toList());
    }

    public double obtenerTotalFacturas() {
        return this.facturas.stream().mapToDouble(fac -> fac.calcularTotal()).sum();
    }

    private boolean comienzaVocal(String nombre){
        return "aeiouAEIOU".indexOf(nombre.charAt(0))>=0;
    }

    public long diasVencidos(LocalDateTime inicio, LocalDateTime fin){
        return DAYS.between(inicio, fin);
    }
}