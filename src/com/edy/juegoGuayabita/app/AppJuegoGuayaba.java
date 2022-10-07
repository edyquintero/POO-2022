package com.edy.juegoGuayabita.app;

import com.edy.juegoGuayabita.dominio.JuegoGuayaba;
import com.edy.juegoGuayabita.dominio.Player;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AppJuegoGuayaba {
    public static final byte SI = 0;
    public static final byte NO = 1;
    public static void main(String[] args) throws IOException {

        ImageIcon guayaba = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("guayaba.png").readAllBytes());
        ImageIcon dinero = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dinero.png").readAllBytes());
        ImageIcon persona = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("persona.png").readAllBytes());
        ImageIcon instrucciones = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("instrucciones.png").readAllBytes());

        byte opcionSeleccionada;
        boolean asignandoDinero;
        boolean dineroAsignado = true;

        JuegoGuayaba juegoGuayabita = new JuegoGuayaba(0);
        Player jugador1 = new Player("",0);
        Player jugador2 = new Player("",0);

        List<String> opcionJugarInstrucciones = Arrays.asList("Jugar", "Mostrar intrucciones");

        while (true) {
            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Bienvenido al juego de la guayabita\n\n¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionJugarInstrucciones.toArray(),null);

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
                while (dineroAsignado) {
                    double dineroJugador2 = Double.parseDouble((String) JOptionPane.showInputDialog(null, jugador2.getNombre()+"\n\n¿Cuánto dinero tienes para jugar?", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                    asignandoDinero = juegoGuayabita.validarDinero(dineroJugador2);
                    if (asignandoDinero) {
                        jugador2.setDinero(dineroJugador2);
                         break;
                    } else {
                        mostrarMensaje(jugador2.getNombre()+", tu dinero es menor o igual\na la minima apuesta inicial", dinero);
                    }
                }
            }
            else if (opcionSeleccionada==1){
                String instruccionesTexto = juegoGuayabita.getInstrucciones();
                JOptionPane.showMessageDialog(null, instruccionesTexto, "Guayabita", JOptionPane.PLAIN_MESSAGE, instrucciones);
            }
            else {
                mostrarMensaje("Saliendo del juego", guayaba);
                break;
            }

            break;
        }
        juegoGuayabita.iniciarJuego(jugador1, jugador2);
        mostrarMensaje("Inciando juego", guayaba);
        turno(jugador1, juegoGuayabita, guayaba);


    }

    public static void turno(Player jugador, JuegoGuayaba juegoGuayaba, ImageIcon icon) throws IOException {

        ImageIcon guayaba = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("guayaba.png").readAllBytes());

        ImageIcon dado1 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_1.png").readAllBytes());
        ImageIcon dado2 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_2.png").readAllBytes());
        ImageIcon dado3 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_3.png").readAllBytes());
        ImageIcon dado4 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_4.png").readAllBytes());
        ImageIcon dado5 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_5.png").readAllBytes());
        ImageIcon dado6 = new ImageIcon(AppJuegoGuayaba.class.getResourceAsStream("dado_6.png").readAllBytes());

        List<ImageIcon> icons = Arrays.asList(dado1, dado2, dado3, dado4, dado5, dado6);

        byte tiro1;
        byte tiro2;

        int opcion = JOptionPane.showConfirmDialog(null, jugador.getNombre()+", el pote actual es de $"+juegoGuayaba.getBote()+" ¿desea lanzar el dado?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        switch (opcion) {
            case SI:
                 tiro1 = jugador.tirarDado();
                if (tiro1 == 1 || tiro1 == 6) {
                    mostrarMensaje(jugador.getNombre() + ", este ha sido su dado, no podras apostar ("+tiro1+")", icons.get(tiro1-1));
                }
                opcion = JOptionPane.showConfirmDialog(null, jugador.getNombre() + ", este es tu dado.\n¿Deseas hacer una apuesta?("+tiro1+")", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icons.get(tiro1-1));
                switch (opcion) {
                    case SI:
                        double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, jugador.getNombre()+", ¿cuánto deseas apostar?\n\n(el bote está en $"+juegoGuayaba.getBote()+")", "Guayabita", JOptionPane.ERROR_MESSAGE, icon, null, 0));
                        boolean apostar = juegoGuayaba.validarApostar(cantidadApostada);
                        if (apostar) {
                            mostrarMensaje("Tirando dado", guayaba);
                            tiro2 = jugador.tirarDado();
                            if (tiro1<tiro2){
                                mostrarMensaje(jugador.getNombre()+", este es tu dado\n\n¡HAS GANADO!", icons.get(tiro2));
                                jugador.setDinero(jugador.getDinero()+cantidadApostada);
                                juegoGuayaba.setBote(juegoGuayaba.getBote()-cantidadApostada);
                                break;
                            } else {
                                mostrarMensaje(jugador.getNombre()+", este es tu dado\n\nHas perdido...", icons.get(tiro2));
                                jugador.setDinero(jugador.getDinero()-cantidadApostada);
                                juegoGuayaba.setBote(juegoGuayaba.getBote()+cantidadApostada);
                                break;
                            }
                        } else {
                            mostrarMensaje(jugador.getNombre()+", no puedes apostar esta cantidad", guayaba);
                        }
                    case NO:
                        mostrarMensaje("Sediendo turno", guayaba);
                        turno(jugador, juegoGuayaba, guayaba);
                        break;
                    default:
                        break;
                }
            case NO:
                turno(jugador,juegoGuayaba, guayaba);
            default:
                break;
        }
    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "" + mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }
}
