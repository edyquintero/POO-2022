package com.edy.calculadora.app;
import com.edy.calculadora.dominio.Calculadora;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AppCalculadora {
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;
    private static final int REDONDEAR = 4;

    public static void main(String[] args) throws IOException {
        Calculadora calculadora = new Calculadora("Calculadora");
        boolean continuar = true;
        JCheckBox box = new JCheckBox("Redondear");
        boolean redondear = false;

        ImageIcon iconCalculadora = new ImageIcon(AppCalculadora.class.getResourceAsStream("calculadora.png").readAllBytes());
        ImageIcon iconRedondear = new ImageIcon(AppCalculadora.class.getResourceAsStream("Redondear_Icon.png").readAllBytes());
        ImageIcon iconSumar = new ImageIcon(AppCalculadora.class.getResourceAsStream("Sumar_Icon.png").readAllBytes());
        ImageIcon iconRestar = new ImageIcon(AppCalculadora.class.getResourceAsStream("Restar_Icon.png").readAllBytes());
        ImageIcon iconMultiplicar = new ImageIcon(AppCalculadora.class.getResourceAsStream("Multiplicar_Icon.png").readAllBytes());
        ImageIcon iconDividir = new ImageIcon(AppCalculadora.class.getResourceAsStream("Dividir_Icon.png").readAllBytes());

        List<ImageIcon> icons = Arrays.asList(iconSumar, iconRestar, iconMultiplicar, iconDividir, iconRedondear);

        while (continuar){
            int operacion = JOptionPane.showOptionDialog(null, "¿Qué operacion deseas realizar?", "Calculadora", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, iconCalculadora, icons.toArray(),null);

            switch (operacion){
                case REDONDEAR ->
                    redondear = !redondear;

                case SUMAR -> {
                    double numero1 = ingreseDato1(iconSumar);
                    double numero2 = ingreseDato2(iconSumar);
                    double resultado = calculadora.sumar(numero1, numero2);
                    mostrarMensaje(String.valueOf(pruebaRedondear(redondear, resultado)), iconSumar);
                }
                case RESTAR -> {
                    double numero1 = ingreseDato1(iconRestar);
                    double numero2 = ingreseDato2(iconRestar);
                    double resultado = calculadora.restar(numero1, numero2);
                    mostrarMensaje(String.valueOf(pruebaRedondear(redondear, resultado)), iconRestar);
                }
                case MULTIPLICAR -> {
                    double numero1 = ingreseDato1(iconMultiplicar);
                    double numero2 = ingreseDato2(iconMultiplicar);
                    double resultado = calculadora.multiplicar(numero1, numero2);
                    mostrarMensaje(String.valueOf(pruebaRedondear(redondear, resultado)), iconMultiplicar);
                }
                case DIVIDIR -> {
                    double numero1 = ingreseDato1(iconDividir);
                    double numero2 = ingreseDato2(iconDividir);
                    double resultado = calculadora.dividir(numero1, numero2);
                    mostrarMensaje(String.valueOf(pruebaRedondear(redondear, resultado)), iconDividir);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Seleccionó salir", "Saliendo...", JOptionPane.PLAIN_MESSAGE,iconMultiplicar);
                    continuar = false;
                }
            }
        }
    }

    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null, "El resultado es: " + mensaje, "Resultado", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public static double ingreseDato1(ImageIcon icon){
        return Double.parseDouble((String) JOptionPane.showInputDialog(null,"Ingrese el primer numero","Ingreso de datos", JOptionPane.QUESTION_MESSAGE, icon, null,0));
    }
    public static double ingreseDato2(ImageIcon icon){
        return Double.parseDouble((String) JOptionPane.showInputDialog(null,"Ingrese el segundo numero","Ingreso de datos",JOptionPane.QUESTION_MESSAGE, icon, null, 0));
    }
    public static double pruebaRedondear(boolean redondear, double num){
        if(redondear){
            return Math.round(num);
        }
        return num;
    }
}
