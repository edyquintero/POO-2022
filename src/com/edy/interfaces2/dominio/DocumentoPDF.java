package com.edy.interfaces2.dominio;

public class DocumentoPDF extends Documento{
    private int numeroPaginas;

    public DocumentoPDF(String nombre, int numeroPaginas) {
        super(nombre);
        this.numeroPaginas = numeroPaginas;
    }
}
