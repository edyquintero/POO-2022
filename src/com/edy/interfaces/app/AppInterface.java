package com.edy.interfaces.app;

import com.edy.interfaces.dominio.Celular;
import com.edy.interfaces.dominio.CelularBasico;
import com.edy.interfaces.dominio.CelularInternedio;
import com.edy.interfaces.dominio.CelularSemiavanzado;
import com.edy.interfaces.dominio.Desbloqueable;
import com.edy.interfaces.dominio.Persona;

import java.util.Arrays;
import java.util.List;

public class AppInterface {
    public static void main(String[] args) {
        Persona alejandro = new Persona("Alejandro", "ASDFG", "hash123", 9999, "Fredy44");
        Persona sofia = new Persona("Sofia", "QWERTY", "hash678", 5421, "Fredy44");
        Persona daniel = new Persona("Daniel", "ZXCVB", "hash991", 1234, "Dibujo22+");

        CelularBasico nokia = new CelularBasico("Nokia 1100", daniel);
        CelularSemiavanzado xiaomi = new CelularSemiavanzado("Xiaomi", alejandro);
        CelularInternedio huawei = new CelularInternedio("Huawei P44", sofia);

        tratarDeDesbloquear(Arrays.asList(nokia, xiaomi, huawei), sofia);
    }

    public static void tratarDeDesbloquear(List<Desbloqueable> celulares, Persona persona) {
        celulares.forEach(celuco -> {
            String marca = ((Celular) celuco).getMarca();
            boolean puedeDesbloquear = celuco.desbloquear(persona);

            System.out.println(persona.getNombre() + " pudo desbloquear el " + marca + "? " + puedeDesbloquear);
        });
    }
}