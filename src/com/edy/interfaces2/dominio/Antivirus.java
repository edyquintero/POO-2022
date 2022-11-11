/*package com.edy.interfaces2.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Antivirus {
    private List<Archivo> archivosAExaminar;

    public Antivirus(){
        this.archivosAExaminar = new ArrayList<>();
    }

    public void agregar(Archivo arch) {
        this.archivosAExaminar.add(arch);
    }

    public void scanear(){
        System.out.println("Iniciando la busqueda de virus");
        AtomicInteger vitusEncontrados = new AtomicInteger();
        this.archivosAExaminar.forEach(elemento -> {
            if ((elemento.tieneVirus())) {
                System.out.println("'"+elemento.nombre()+ "' tiene virus");
                vitusEncontrados.getAndIncrement();
            }
        });
        System.out.println("Terminando la busqueda de virus, se encontraron "+vitusEncontrados +" virus");
    }
}
*/