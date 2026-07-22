package org.danielcatalan.controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;

    public CalculadoraController() {
    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        if (entrada.equals("C")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pantalla.setText("");
        }
        //si ya se completo un calculo //reiniciar
        if (calculoTerminado && entrada.matches("[0-9]")){
            opcion1 = "";
            operador = "";
            opcion2 = "";
        }
        calculoTerminado = false;
        if  (entrada.matches("[0-9]")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            }else {
                opcion2 += entrada;
            }

            actualizarPantalla(pantalla);
        }else if(entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("÷")) {
            operador = entrada;
            actualizarPantalla(pantalla);

        }else if(entrada.equals("√")) {
            // misma secuencia que la entrada de digitos:
            // si no hay operador, afecta a opcion1; si ya hay operador, afecta a opcion2
            if (operador.isEmpty()) {
                opcion1 = resultadoRaiz(opcion1);
            } else {
                opcion2 = resultadoRaiz(opcion2);
            }
            actualizarPantalla(pantalla);

        }else if(entrada.equals("=")) {
            if(operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("÷")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
            actualizarPantalla(pantalla);
        }
    }

    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + "" + operador + "" + opcion2);
        }
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int suma = datoUno + datoDos;
        return String.valueOf(suma);
    }

    private String resultadoResta(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int resta = datoUno - datoDos;
        return String.valueOf(resta);
    }

    private String resultadoMultiplicacion(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int multi = datoUno * datoDos;
        return String.valueOf(multi);
    }

    private String resultadoDivision(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);
        if (datoDos == 0) {
            return "Error";
        }
        double division = datoUno / datoDos;
        return String.valueOf(division);
    }

    private String resultadoRaiz(String numero) {
        if (numero.isEmpty()) {
            return "0";
        }
        double dato = Double.parseDouble(numero);
        if (dato < 0) {
            return "Error";
        }
        double resultado = Math.sqrt(dato);
        if (resultado == (long) resultado) {
            return String.valueOf((long) resultado);
        }
        return String.valueOf(resultado);
    }
}