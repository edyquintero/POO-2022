package centroComercial.app;

import centroComercial.dominio.Categoria;
import centroComercial.dominio.CentroComercial;
import centroComercial.dominio.Tienda;

import java.util.ArrayList;
import java.util.List;

public class AppCentroComercial {
    public static void main(String[] args) {
        CentroComercial centroComercial = new CentroComercial("Centro comercial");
        List<Tienda> tiendas = new ArrayList<>();

        ArrayList<String> categorias1 = new ArrayList();
        ArrayList<String> categorias2 = new ArrayList();
        ArrayList<String> categorias3 = new ArrayList();

        categorias1.add("tecnologia");
        categorias2.add("tecnologia");
        categorias2.add("libros");
        categorias3.add("tecnologia");
        categorias3.add("libros");
        categorias3.add("electrodomesticos");



        centroComercial.abrirTienda(12345, "tienda1", categorias1);
        centroComercial.abrirTienda(54321, "tienda2", categorias2);
        centroComercial.abrirTienda(67890, "tienda3", categorias3);
        centroComercial.abrirTienda(19876, "tienda4", categorias1);
        centroComercial.abrirTienda(23456, "tienda5", categorias2);


        tiendas = centroComercial.obtenerTodasLasTiendas();
        tiendas.forEach(tienda -> System.out.println(tienda.getNombre()+" ("+tienda.getCodigo()+")"+tienda.getCategorias()));

        System.out.println("\n");

    }
}
