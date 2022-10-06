package com.edy.juegoGuayabitaImperfecto.app;

import com.edy.juegoGuayabitaImperfecto.dominio.JuegoGuayabita;
import com.edy.juegoGuayabitaImperfecto.dominio.Jugador;

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

            mostrarMensaje("Juego terminado...", guayaba);
            mostrarMensaje("Iniciando nuevo juego", guayaba);
            juegoGuayabita.iniciarJuego(jugador1, jugador2);
        }
    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "" + mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }
}