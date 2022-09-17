package centroComercial.dominio;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private long codigo;
    private String nombre;

    private List<Categoria> categorias=new ArrayList<>();


    public Tienda(long codigo, String nombre, List categorias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
