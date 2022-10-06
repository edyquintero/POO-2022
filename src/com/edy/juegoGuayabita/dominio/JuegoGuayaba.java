package com.edy.juegoGuayabita.dominio;

public class JuegoGuayaba {
    double apuestaInicial;
    double bote = 0;
    String instrucciones = """
                1. Posee dos jugadores, cada uno empieza con una determinada suma de dinero.
                
                2. Se establece una apuesta minima , denominada case.
                
                3. Cada jugador debe colocar el valor del case en la mesa.
                
                4. Se efectuaran turnos, en los que el jugador lanza el dado, segun el resultado
                se pueden dar las siguientes posibilidades. Al sacar 1 o 6, pierde, y debe colocar
                el valor del case en la mesa, cambio de turno. Al sacar 2,3,4,5 posee un segundo
                turno. En el segundo lanzamiento debe obtener un numero mayor al primer
                lanzamiento, si esto sucede, el jugador ganara el valor apostado, de lo 
                contrario perdera lo apostado, y se cambiara el turno.
                
                5. El juego termina cuando un jugador o la mesa no posee mas dinero.""";

    public JuegoGuayaba(double apuestaInicial) {
        this.apuestaInicial = apuestaInicial;
        this.bote = 0;
    }

    public boolean validarDinero(double dineroJugador) {
        return dineroJugador > apuestaInicial;
    }

    public double getApuestaInicial() {
        return apuestaInicial;
    }

    public void setApuestaInicial(double apuestaInicial) {
        this.apuestaInicial = apuestaInicial;
    }

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public String getInstrucciones() {
        return instrucciones;
    }
}
