package com.edy.juegoGuayabita.app;

import com.edy.juegoGuayabita.dominio.JuegoGuayabita;
import com.edy.juegoGuayabita.dominio.Jugador;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AppJuego {
    public static void main(String[] args) throws IOException {
        ImageIcon guayaba = new ImageIcon(AppJuego.class.getResourceAsStream("guayaba.jpg").readAllBytes());
        ImageIcon dinero = new ImageIcon(AppJuego.class.getResourceAsStream("dinero.png").readAllBytes());
        ImageIcon persona = new ImageIcon(AppJuego.class.getResourceAsStream("persona.png").readAllBytes());
        ImageIcon instrucciones = new ImageIcon(AppJuego.class.getResourceAsStream("instrucciones.png").readAllBytes());
        ImageIcon dado1 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_1.png").readAllBytes());
        ImageIcon dado2 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_2.png").readAllBytes());
        ImageIcon dado3 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_3.png").readAllBytes());
        ImageIcon dado4 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_4.png").readAllBytes());
        ImageIcon dado5 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_5.png").readAllBytes());
        ImageIcon dado6 = new ImageIcon(AppJuego.class.getResourceAsStream("dado_6.png").readAllBytes());

        boolean eligiendoOpcion = true;
        boolean jugando = false;
        byte turno=0;
        byte opcionSeleccionada = 0;

        JuegoGuayabita juegoGuayabita = new JuegoGuayabita(0, 0);
        Jugador jugador1 = new Jugador("",0);
        Jugador jugador2 = new Jugador("",0);

        List<String> opcionJugarInstrucciones = Arrays.asList("Jugar", "Mostrar intrucciones");
        List<String> opcionesTirarSalir = Arrays.asList("Tirar dado", "Seder turno", "Retirarse");
        List<String> opcionesApostarSeder = Arrays.asList("Apostar", "Seder turno", "Retirarse");



        while (eligiendoOpcion) {
            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Bienvenidx al juego de la guayabita\n\n¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionJugarInstrucciones.toArray(),null);

            if (opcionSeleccionada==0){
                double valorMininoApuestaInicial = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es el valor minimo de apuesta incial", "Guayabita", JOptionPane.ERROR_MESSAGE, dinero, null, 0));
                juegoGuayabita.setMinimaCantidadInicial(valorMininoApuestaInicial);

                String nombreJugador1 = (String) JOptionPane.showInputDialog(null, "¿Cuál es el nombre del primer jugador?", "Guayabita", JOptionPane.YES_NO_OPTION, persona, null, "Nombre");
                jugador1.setNombre(nombreJugador1);
                double dineroJugador1 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero del jugador 1", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                jugador1.setDineroActual(dineroJugador1);

                String nombreJugador2 = (String) JOptionPane.showInputDialog(null, "¿Cuál es el nombre del segundo jugador?", "Guayabita", JOptionPane.YES_NO_OPTION, persona, null, "Nombre");
                jugador2.setNombre(nombreJugador2);
                double dineroJugador2 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero del jugador 2", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                jugador1.setDineroActual(dineroJugador2);
                eligiendoOpcion = false;
                jugando = true;
                turno = 1;
            }
            else if (opcionSeleccionada==1){
                String instruccionesTexto = juegoGuayabita.getInstructions();
                JOptionPane.showMessageDialog(null, instruccionesTexto, "Guayabita", JOptionPane.PLAIN_MESSAGE, instrucciones);
                }
            else {
                eligiendoOpcion = false;
            }
        }

        mostrarMensaje("Iniciando el juego", guayaba);

        while (jugando){
            while (turno == 1) {

                opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+"\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionesTirarSalir.toArray(),null);

                if (opcionSeleccionada==0){
                    byte dado = jugador1.tirarDado();
                    switch (dado) {
                        case 1:
                            mostrarMensaje("Su dado ha sido 1, debera seder su turno", dado1);
                            mostrarMensaje("Sediendo turno...", guayaba);
                            turno = 2;
                            break;
                        case 2:
                            mostrarMensaje("Su dado ha sido 2", dado2);
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+"\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostara?", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                }
                            }
                            break;
                        case 3:
                            mostrarMensaje("Su dado ha sido 3", dado3);
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre() + "\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, guayaba, opcionesApostarSeder.toArray(), null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostara?", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                }
                            }
                            break;
                        case 4:
                            mostrarMensaje("Su dado ha sido 4", dado4);
                            break;
                        case 5:
                            mostrarMensaje("Su dado ha sido 5", dado5);
                            break;
                        case 6:
                            mostrarMensaje("Su dado ha sido 6, debera seder su turno", dado6);
                            mostrarMensaje("Sediendo turno...", guayaba);
                            turno = 2;
                            break;
                    }

                } else if (opcionSeleccionada==1){
                    mostrarMensaje("Sediendo turno...", guayaba);
                    turno = 2;
                } else if (opcionSeleccionada==3) {
                    mostrarMensaje("El jugador 1 se ha rendido...", guayaba);
                } else {
                    break;
                }
            }

            while (turno == 2){

                opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+"\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionesTirarSalir.toArray(),null);

                if (opcionSeleccionada==0){
                    byte dado = jugador2.tirarDado();
                    switch (dado) {
                        case 1 -> {
                            mostrarMensaje("Su dado ha sido 1, debera seder su turno", dado1);
                            mostrarMensaje("Sediendo turno...", guayaba);
                            turno = 1;
                        }
                        case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                        case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                        case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                        case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                        case 6 -> {
                            mostrarMensaje("Su dado ha sido 6, debera seder su turno", dado6);
                            mostrarMensaje("Sediendo turno...", guayaba);
                            turno = 1;
                        }
                    }
                } else if (opcionSeleccionada==1){
                    mostrarMensaje("Sediendo turno...", guayaba);
                    turno = 1;
                } else if (opcionSeleccionada==3) {
                    mostrarMensaje("El jugador 2 se ha rendido...", guayaba);
                } else {
                    break;
                }
            }
        }
    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "" + mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }

}
