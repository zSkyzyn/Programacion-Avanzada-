package Socket;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        int puertoEscucha = 5000;

        try (ServerSocket servidor = new ServerSocket(puertoEscucha)) {
            System.out.println(">>> SISTEMA INICIADO: Escuchando en puerto " + puertoEscucha);

            try (Socket enlace = servidor.accept();
                 BufferedReader receptor = new BufferedReader(new InputStreamReader(enlace.getInputStream()));
                 PrintWriter emisor = new PrintWriter(enlace.getOutputStream(), true)) {

                System.out.println("[AUDITORÍA]: Dispositivo conectado desde " + enlace.getInetAddress());
                emisor.println("Panel de Control Activo. Use !CALCULAR \"operacion\" o FIN para salir.");

                String tramaEntrante;
                while ((tramaEntrante = receptor.readLine()) != null) {
                    System.out.println(" -> ENTRADA RECIBIDA: " + tramaEntrante);

                    if (tramaEntrante.equalsIgnoreCase("FIN")) {
                        emisor.println("Sesión terminada. Cerrando túnel de datos...");
                        break;
                    }

                    if (tramaEntrante.startsWith("!CALCULAR")) {
                        try {
                            // Extraer contenido entre comillas
                            int inicio = tramaEntrante.indexOf("\"") + 1;
                            int fin = tramaEntrante.lastIndexOf("\"");
                            String operacion = tramaEntrante.substring(inicio, fin);

                            // Ejecutar el Algoritmo de Ascenso Recursivo
                            double resultado = new CalculadoraParser(operacion).parse();
                            emisor.println("[MÓDULO MATH]: Resultado de '" + operacion + "' = " + resultado);
                            
                        } catch (Exception e) {
                            emisor.println("[ERROR]: Error al procesar expresión: " + e.getMessage());
                        }
                    } else {
                        emisor.println("Respuesta del servidor: Mensaje '" + tramaEntrante + "' procesado.");
                    }
                }
            }
            System.out.println(">>> SISTEMA APAGADO.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Clase que implementa un Analizador Sintáctico de Ascenso Recursivo
     */
    static class CalculadoraParser {
        private String str;
        private int pos = -1;
        private int ch;

        public CalculadoraParser(String str) {
            this.str = str;
        }

        private void proximoChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        private boolean comer(int charParaComer) {
            while (ch == ' ') proximoChar();
            if (ch == charParaComer) {
                proximoChar();
                return true;
            }
            return false;
        }

        public double parse() {
            proximoChar();
            double x = parseExpresion();
            if (pos < str.length()) throw new RuntimeException("Carácter inesperado: " + (char) ch);
            return x;
        }

        // Gramática: Expresion = Termino | Expresion '+' Termino | Expresion '-' Termino
        private double parseExpresion() {
            double x = parseTermino();
            for (;;) {
                if      (comer('+')) x += parseTermino(); // Suma
                else if (comer('-')) x -= parseTermino(); // Resta
                else return x;
            }
        }

        // Gramática: Termino = Factor | Termino '*' Factor | Termino '/' Factor
        private double parseTermino() {
            double x = parseFactor();
            for (;;) {
                if      (comer('*')) x *= parseFactor(); // Multiplicación
                else if (comer('/')) x /= parseFactor(); // División
                else return x;
            }
        }

        // Gramática: Factor = '+' Factor | '-' Factor | '(' Expresion ')' | Numero
        private double parseFactor() {
            if (comer('+')) return parseFactor(); 
            if (comer('-')) return -parseFactor(); 

            double x;
            int startPos = this.pos;
            if (comer('(')) { // Paréntesis
                x = parseExpresion();
                comer(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Números
                while ((ch >= '0' && ch <= '9') || ch == '.') proximoChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else {
                throw new RuntimeException("Error de sintaxis en: " + (char) ch);
            }
            return x;
        }
    }
}