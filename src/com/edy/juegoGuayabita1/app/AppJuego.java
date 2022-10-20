package com.edy.juegoGuayabita1.app;

import com.edy.juegoGuayabita1.app.AppJuego;
import com.edy.juegoGuayabita1.dominio.JuegoGuayabita;
import com.edy.juegoGuayabita1.dominio.Jugador;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AppJuego {
    private static final ImageIcon guayaba = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("guayaba.jpg")));
    private static final ImageIcon dinero = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dinero.png")));
    private static final ImageIcon persona = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("persona.png")));
    private static final ImageIcon instrucciones = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("instrucciones.png")));
    private static final ImageIcon dado1 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_1.png")));
    private static final ImageIcon dado2 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_2.png")));
    private static final ImageIcon dado3 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_3.png")));
    private static final ImageIcon dado4 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_4.png")));
    private static final ImageIcon dado5 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_5.png")));
    private static final ImageIcon dado6 = new ImageIcon(Objects.requireNonNull(AppJuego.class.getResource("dado_6.png")));

    public static void main(String[] args) throws IOException {

        boolean eligiendoOpcion = true;
        boolean jugando = false;
        byte turno=0;
        byte opcionSeleccionada = 0;

        JuegoGuayabita juegoGuayabita = new JuegoGuayabita(0, 0);
        Jugador jugador1 = new Jugador("",0);
        Jugador jugador2 = new Jugador("",0);

        List<String> opcionJugarInstrucciones = Arrays.asList("Jugar", "Mostrar intrucciones");
        List<String> opcionesTirarSederSalir = Arrays.asList("Tirar dado", "Seder turno", "Retirarse");
        List<String> opcionesTirarSalir = Arrays.asList("Tirar dado", "Seder turno", "Retirarse");
        List<String> opcionesApostarSeder = Arrays.asList("Apostar", "Seder turno", "Retirarse");
        List<String> opcionesSederSalir = Arrays.asList("Seder turno", "Retirarse");

        while (eligiendoOpcion) {
            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Bienvenido al juego de la guayabita\n\n¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionJugarInstrucciones.toArray(),null);

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
                jugador2.setDineroActual(dineroJugador2);
                eligiendoOpcion = false;
                jugando = juegoGuayabita.iniciarJuego(jugador1, jugador2);
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

            while (turno == 1 && juegoGuayabita.getBote()!=0) {
                opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+"\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionesTirarSederSalir.toArray(),null);

                if (opcionSeleccionada==0){
                    byte dado = jugador1.tirarDado();
                    switch (dado) {
                        case 1:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre() + ", su dado ha sido 1\nDebera seder su turno\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, dado1, opcionesSederSalir.toArray(), null);
                            if (opcionSeleccionada == 0) {
                                turno = 2;
                            }
                            break;
                        case 2:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+", su dado ha sido 2\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado2, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador1);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador1.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador1.setDineroActual(jugador1.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 2;
                                            break;
                                        }
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+", su dado ha sido 3\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado3, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador1);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador1.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador1.setDineroActual(jugador1.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 2;
                                            break;
                                        }
                                    }
                                    if (juegoGuayabita.getBote()==0){
                                        mostrarMensaje("El juego ha terminado", guayaba);
                                        mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDineroActual()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDineroActual(), dinero);

                                        break;
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+", su dado ha sido 4\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado4, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador1);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador1.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador1.setDineroActual(jugador1.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 2;
                                            break;
                                        }
                                    }
                                    if (juegoGuayabita.getBote()==0){
                                        mostrarMensaje("El juego ha terminado", guayaba);
                                        mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDineroActual()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDineroActual(), dinero);
                                        break;
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre()+", su dado ha sido 5\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado5, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador1);
                                if (puedeApostar){
                                    jugador1.setDineroActual(jugador1.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador1.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador1.setDineroActual(jugador1.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 2;
                                            break;
                                        }
                                    }
                                    if (juegoGuayabita.getBote()==0){
                                        mostrarMensaje("El juego ha terminado", guayaba);
                                        mostrarMensaje(jugador1.getNombre()+" --> $"+jugador1.getDineroActual()+"\n\n"+jugador2.getNombre()+" --> $"+jugador2.getDineroActual(), dinero);

                                        break;
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre() + ", su dado ha sido 6\nDebera seder su turno\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, dado6, opcionesSederSalir.toArray(), null);
                            if (opcionSeleccionada == 0) {
                                turno = 2;
                            }
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
            
            while (turno == 2 && juegoGuayabita.getBote()!=0) {
                opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+"\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, guayaba, opcionesTirarSederSalir.toArray(),null);

                if (opcionSeleccionada==0){
                    byte dado = jugador2.tirarDado();
                    switch (dado) {
                        case 1:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre() + ", su dado ha sido 1\nDebera seder su turno\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, dado1, opcionesSederSalir.toArray(), null);
                            if (opcionSeleccionada == 0) {
                                turno = 1;
                            }
                            break;
                        case 2:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+", su dado ha sido 2\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado2, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador2);
                                if (puedeApostar){
                                    jugador2.setDineroActual(jugador2.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador2.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador2.setDineroActual(jugador2.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+", su dado ha sido 3\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado3, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador2);
                                if (puedeApostar){
                                    jugador2.setDineroActual(jugador2.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador2.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador2.setDineroActual(jugador2.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+", su dado ha sido 4\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado4, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador2);
                                if (puedeApostar){
                                    jugador2.setDineroActual(jugador2.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador2.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador2.setDineroActual(jugador2.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador2.getNombre()+", su dado ha sido 5\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, dado5, opcionesApostarSeder.toArray(),null);
                            if (opcionSeleccionada==0){
                                double cantidadApostada = Double.parseDouble((String) JOptionPane.showInputDialog(null, "¿Cuál es la cantidad de dinero que apostará?\n\n(debería ser inferior a <"+juegoGuayabita.getBote()+">)", "Guayabita", JOptionPane.YES_NO_OPTION, dinero, null, 0));
                                boolean puedeApostar = juegoGuayabita.apostar(cantidadApostada, jugador2);
                                if (puedeApostar){
                                    jugador2.setDineroActual(jugador2.getDineroActual()-cantidadApostada);
                                    byte opcion = (byte) JOptionPane.showOptionDialog(null, "Al tirar su dado debera sacar mas de "+dado+"\nde lo contrario, perdera la apuesta", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,guayaba , opcionesTirarSalir.toArray(), null);
                                    if (opcion == 0) {
                                        byte tiroDado = jugador2.tirarDado();
                                        switch (tiroDado) {
                                            case 1 -> mostrarMensaje("Su dado ha sido 1", dado1);
                                            case 2 -> mostrarMensaje("Su dado ha sido 2", dado2);
                                            case 3 -> mostrarMensaje("Su dado ha sido 3", dado3);
                                            case 4 -> mostrarMensaje("Su dado ha sido 4", dado4);
                                            case 5 -> mostrarMensaje("Su dado ha sido 5", dado5);
                                            case 6 -> mostrarMensaje("Su dado ha sido 6", dado6);
                                        }

                                        if (tiroDado>dado){
                                            mostrarMensaje("Ha ganado la apuesta", dinero);
                                            juegoGuayabita.setBote(juegoGuayabita.getBote()-cantidadApostada*2);
                                            jugador2.setDineroActual(jugador2.getDineroActual()+cantidadApostada*2);
                                            break;
                                        } else {
                                            mostrarMensaje("Ha perdido la apuesta", dinero);
                                            turno = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    mostrarMensaje("No puede apostar", dinero);
                                    break;
                                }
                            } else if (opcionSeleccionada==1){
                                mostrarMensaje("Sediendo turno...", guayaba);
                                turno = 2;
                                break;
                            } else {
                                break;
                            }                        case 6:
                            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, jugador1.getNombre() + ", su dado ha sido 6\nDebera seder su turno\n\n ¿Qué quieres hacer?", "Guayabita", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, dado6, opcionesSederSalir.toArray(), null);
                            if (opcionSeleccionada == 0) {
                                turno = 2;
                            }
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

            mostrarMensaje("Juego terminado...", guayaba);
            mostrarMensaje("Iniciando nuevo juego", guayaba);
            juegoGuayabita.iniciarJuego(jugador1, jugador2);
        }
    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "" + mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }
}