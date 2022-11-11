package com.edy.interfaces2.dominio;

public class DocumentoWord extends Documento implements Viruseable{
    private boolean protegido;

    public DocumentoWord(String nombre, boolean protegido) {
        super(nombre);
        this.protegido = protegido;
    }

    @Override
    public boolean tieneVirus() {
        return this.protegido == false;
    }

    @Override
    public String nombre() {
        return this.getNombre();
    }
}
