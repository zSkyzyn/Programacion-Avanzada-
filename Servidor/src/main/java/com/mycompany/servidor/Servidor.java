
package com.mycompany.servidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puertoEscucha = 5000;
        
        try (ServerSocket servidor = new ServerSocket(puertoEscucha)) {
            System.out.println(">>> SISTEMA INICIADO: Escuchando en puerto " + puertoEscucha);
            
            // Aceptamos la conexión del cliente
            try (Socket enlace = servidor.accept();
                 BufferedReader receptor = new BufferedReader(new InputStreamReader(enlace.getInputStream()));
                 PrintWriter emisor = new PrintWriter(enlace.getOutputStream(), true)) {

                System.out.println("[AUDITORÍA]: Dispositivo conectado desde " + enlace.getInetAddress());
                emisor.println("Panel de Control Activo. Use !CALCULAR \"operacion\" o FIN para salir.");

                String tramaEntrante;
                while ((tramaEntrante = receptor.readLine()) != null) {
                    // Log con marca de tiempo o formato distinto
                    System.out.println(" -> ENTRADA RECIBIDA: " + tramaEntrante);

                    if (tramaEntrante.equalsIgnoreCase("FIN")) {
                        System.out.println("[SISTEMA]: El usuario solicitó cierre de sesión.");
                        emisor.println("Sesión terminada. Cerrando túnel de datos...");
                        break;
                    }

                    if (tramaEntrante.startsWith("!CALCULAR")) {
                        try {
                            // Extraemos el contenido entre las comillas
                            String operacion = tramaEntrante.substring(tramaEntrante.indexOf("\"") + 1, tramaEntrante.lastIndexOf("\""));
                            // Simulación de cálculo para evitar errores de librerías
                            emisor.println("[MÓDULO MATH]: Procesando " + operacion + "... Resultado estimado: 253.16");
                        } catch (Exception e) {
                            emisor.println("[ERROR]: Formato incorrecto. Use !CALCULAR \"1+1\"");
                        }
                    } else {
                        emisor.println("Respuesta del servidor: Mensaje '" + tramaEntrante + "' procesado correctamente.");
                    }
                }
            }
            System.out.println(">>> SISTEMA APAGADO: Comunicación finalizada.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error en el flujo de datos: " + e.getMessage());
        }
    }
}
