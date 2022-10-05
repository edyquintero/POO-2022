package com.edy.juegoGuayabita.dominio;

public class JuegoGuayabita {
    double bote;
    double minimaCantidadInicial;

    String instructions;


    public JuegoGuayabita(double bote, double minimaCantidadInicial){
        this.bote = bote;
        this.minimaCantidadInicial = minimaCantidadInicial;
    }

    public boolean iniciarJuego(Jugador jugador1, Jugador jugador2){
        if(jugador1.getDineroActual()>minimaCantidadInicial && jugador2.getDineroActual()>minimaCantidadInicial){
            jugador1.setDineroActual(jugador1.dineroActual-minimaCantidadInicial);
            jugador2.setDineroActual(jugador2.dineroActual-minimaCantidadInicial);

            this.bote = this.minimaCantidadInicial*2;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean apostar(double cantidadApostada){
        if (cantidadApostada<=bote){
            bote = bote + cantidadApostada;
            return true;
        } else {
            return false;
        }
    }


    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public Object getMinimaCantidadInicial() {
        return minimaCantidadInicial;
    }

    public void setMinimaCantidadInicial(double minimaCantidadInicial) {
        this.minimaCantidadInicial = minimaCantidadInicial;
    }

    public String getInstructions() {
        return """
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
    }
}
