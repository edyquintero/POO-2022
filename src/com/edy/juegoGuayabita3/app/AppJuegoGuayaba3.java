package com.edy.juegoGuayabita3.app;

import com.edy.juegoGuayabita3.dominio.Player3;
import com.edy.juegoGuayabita3.dominio.JuegoGuayaba3;


import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AppJuegoGuayaba3 {
    private static final byte SI = 0;
    private static final byte NO = 1;
    private static final ImageIcon guayaba = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("guayaba.png")));
    private static final ImageIcon dinero = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dinero.png")));
    private static final ImageIcon persona = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("persona.png")));
    private static final ImageIcon instrucciones = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("instrucciones.png")));
    private static final ImageIcon dado1 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_1.png")));
    private static final ImageIcon dado2 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_2.png")));
    private static final ImageIcon dado3 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_3.png")));
    private static final ImageIcon dado4 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_4.png")));
    private static final ImageIcon dado5 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_5.png")));
    private static final ImageIcon dado6 = new ImageIcon(Objects.requireNonNull(AppJuegoGuayaba3.class.getResource("dado_6.png")));

    public static void main(String[] args) throws IOException {
        byte opcionSeleccionada;
        boolean asignandoDinero;
        boolean dineroAsignado = true;
        boolean jugando = false;


        JuegoGuayaba3 juegoGuayabita = new JuegoGuayaba3(0);
        Player3 jugador1 = new Player3("",0);
        Player3 jugador2 = new Player3("",0);

        List<String> opcionJugarInstrucciones = Arrays.asList("Jugar", "Mostrar intrucciones");

        while (true) {

            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Bienvenido al juego de la guayabita\n\n¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionJugarInstrucciones.toArray(),"Jugar");

            if (opcionSeleccionada==0){
                double apuestaInicial = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es el valor minimo de apuesta incial?", "Guayabita", JOptionPane.ERROR_MESSAGE, dinero, null, 0));
                juegoGuayabita.setApuestaInicial(apuestaInicial);

                String nombreJugador1 = (String) JOptionPane.showInputDialog(null, "¿Cuál es el nombre del primer jugador?", "Guayabita", JOptionPane.YES_NO_OPTION, persona, null, "Nombre");
                jugador1.setNombre(nombreJugador1);
                while (dineroAsignado) {
                    double dineroJugador1 = Double.parseDouble((String) JOptionPane.showInputDialog(null, jugador1.getNombre()+"\n\n¿Cuánto dinero tienes para jugar?", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                    asignandoDinero = juegoGuayabita.validarDinero(dineroJugador1);
                    if (asignandoDinero) {
                        jugador1.setDinero(dineroJugador1);
                        break;
                    } else {
                        mostrarMensaje(jugador1.getNombre()+", tu dinero es menor o igual\na la minima apuesta inicial", dinero);
                    }
                }

                String nombreJugador2 = (String) JOptionPane.showInputDialog(null, "¿Cuál es el nombre del segundo jugador?", "Guayabita", JOptionPane.YES_NO_OPTION, persona, null, "Nombre");
                jugador2.setNombre(nombreJugador2);
                while (true) {
                    double dineroJugador2 = Double.parseDouble((String) JOptionPane.showInputDialog(null, jugador2.getNombre()+"\n\n¿Cuánto dinero tienes para jugar?", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                    asignandoDinero = juegoGuayabita.validarDinero(dineroJugador2);
                    if (asignandoDinero) {
                        jugador2.setDinero(dineroJugador2);
                        break;
                    } else {
                        mostrarMensaje(jugador2.getNombre()+", tu dinero es menor o igual\na la minima apuesta inicial", dinero);
                    }
                }
                jugando = true;
                break;
            }
            else if (opcionSeleccionada==1){
                String instruccionesTexto = juegoGuayabita.getInstrucciones();
                JOptionPane.showMessageDialog(null, instruccionesTexto, "Guayabita", JOptionPane.PLAIN_MESSAGE, instrucciones);
            }
            else {
                mostrarMensaje("Saliendo del juego", guayaba);
                break;
            }
        }

        if (jugando){
            juegoGuayabita.iniciarJuego(jugador1, jugador2);
            mostrarMensaje("Inciando juego", guayaba);
        }


        while (jugando) {
            int si = turno(jugador1, jugador1, jugador2, juegoGuayabita, guayaba);
            if (si == 1 ) {
                boolean boteVacio = juegoGuayabita.validarPote();
                if (boteVacio) {
                    if (jugador1.getDinero()==0 || jugador2.getDinero()==0){
                        mostrarMensaje("El juego ha terminado, uno de los dos jugadores no \ntiene el suficiente dinero para continuar", guayaba);
                        mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDinero()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDinero(), dinero);
                        jugando = false;
                    }
                    juegoGuayabita.iniciarJuego(jugador1, jugador2);
                }
            } else if (si == 2) {
                int jugo = turno(jugador2, jugador1, jugador2, juegoGuayabita, guayaba);
                if (jugo==1) {
                    boolean boteVacio = juegoGuayabita.validarPote();
                    if (boteVacio) {
                        juegoGuayabita.iniciarJuego(jugador1, jugador2);
                        if (jugador1.getDinero()==0 || jugador2.getDinero()==0){
                            mostrarMensaje("El juego ha terminado, uno de los dos jugadores no \ntiene el suficiente dinero para continuar", guayaba);
                            mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDinero()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDinero(), dinero);
                            jugando = false;
                        }
                    }
                }
            } else if (si == 3) {
                mostrarMensaje("juego terminado, uno de los dos se ha rendido", guayaba);
                mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDinero()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDinero(), dinero);
                jugando = false;
            }
        }

    }

    public static int turno(Player3 jugador, Player3 jugador1, Player3 jugador2, JuegoGuayaba3 juegoGuayaba, ImageIcon icon) throws IOException {

        ImageIcon guayaba = new ImageIcon(AppJuegoGuayaba3.class.getResourceAsStream("guayaba.png").readAllBytes());

        List<ImageIcon> icons = Arrays.asList(dado1, dado2, dado3, dado4, dado5, dado6);

        byte tiro1;
        byte tiro2;

        int opcion = JOptionPane.showConfirmDialog(null, jugador.getNombre()+", el pote actual es de $"+juegoGuayaba.getBote()+" ¿desea lanzar el dado?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        switch (opcion) {
            case SI:
                tiro1 = jugador.tirarDado();
                if (tiro1 == 1 || tiro1 == 6) {
                    mostrarMensaje(jugador.getNombre() + ", este ha sido su dado, no podras apostar ("+tiro1+")", icons.get(tiro1-1));
                    return 2;
                }
                opcion = JOptionPane.showConfirmDialog(null, jugador.getNombre() + ", este es tu dado.\n¿Deseas hacer una apuesta?("+tiro1+")", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icons.get(tiro1-1));
                switch (opcion) {
                    case SI:
                        boolean apostar;
                        double cantidadApostada;
                        do{
                            cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, jugador.getNombre()+", ¿cuánto deseas apostar?\n\n(el bote está en $"+juegoGuayaba.getBote()+")\n(dinero actual --> $"+jugador.getDinero()+")", "Guayabita", JOptionPane.ERROR_MESSAGE, icon, null, 0));
                            apostar = juegoGuayaba.validarApostar(jugador, cantidadApostada);
                            if (apostar == false){
                                mostrarMensaje("Debe apostar una cantidad igual o menor al bote", dinero);
                            }
                        }while(!apostar);

                        mostrarMensaje("Tirando dado", guayaba);
                        tiro2 = jugador.tirarDado();
                        if (tiro1<tiro2){
                            mostrarMensaje(jugador.getNombre()+", este es tu dado\n\n¡HAS GANADO!", icons.get(tiro2-1));
                            jugador.setDinero(jugador.getDinero()+(cantidadApostada));
                            juegoGuayaba.setBote(juegoGuayaba.getBote()-cantidadApostada);
                            mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDinero()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDinero(), dinero);
                            if (juegoGuayaba.getBote()==0){
                                mostrarMensaje("Iniciando nuevo juego", guayaba);
                                juegoGuayaba.iniciarJuego(jugador1,jugador2);
                            }
                            return 1;
                        } else {
                            jugador.setDinero(jugador.getDinero()-cantidadApostada);
                            juegoGuayaba.setBote(juegoGuayaba.getBote()+cantidadApostada);
                            mostrarMensaje(jugador.getNombre()+", este es tu dado\n\nHas perdido...\n\n(Tu dinero es --> $"+jugador.getDinero()+")", icons.get(tiro2-1));
                            if (Objects.equals(jugador.getNombre(), jugador2.getNombre())){
                                turno(jugador1, jugador1, jugador2, juegoGuayaba, guayaba);
                            }
                            return 2;
                        }
                    case NO:
                        mostrarMensaje("Sediendo turno", guayaba);
                        if (Objects.equals(jugador.getNombre(), jugador1.getNombre())){
                            turno(jugador2, jugador1, jugador2,juegoGuayaba, guayaba);
                        } else {
                            turno(jugador1, jugador1, jugador2, juegoGuayaba, guayaba);
                        }
                        return 2;
                    default:
                        return 2;
                }
            case NO:
                if (Objects.equals(jugador.getNombre(), jugador1.getNombre())) {
                    jugador2.setDinero(jugador2.getDinero() + juegoGuayaba.getBote());
                } else {
                    jugador1.setDinero((jugador1.getDinero() + juegoGuayaba.getBote()));
                }
                juegoGuayaba.setBote(0);
                return 3;
            default:
                break;
        }
        return 3;
    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "" + mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }
}
