/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Socket;


    import java.io.*;
    import java.net.*;
    import java.util.Scanner;

    public class Cliente {
        public static void main(String[] args) {
            String direccion = "127.0.0.1";
            int puerto = 5000;

            try (Socket miSocket = new Socket(direccion, puerto);
                 BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
                 PrintWriter salidaServidor = new PrintWriter(miSocket.getOutputStream(), true);
                 Scanner inputTeclado = new Scanner(System.in)) {

                System.out.println("=== TERMINAL DE ENLACE ESTABLECIDA ===");
                // Leemos el mensaje de bienvenida del servidor
                System.out.println("STATUS: " + entradaServidor.readLine());

                while (true) {
                    System.out.print("Escribir comando >> ");
                    String comando = inputTeclado.nextLine();

                    // Enviamos al servidor
                    salidaServidor.println(comando);

                    // Esperamos y mostramos respuesta
                    String respuesta = entradaServidor.readLine();
                    System.out.println("SERVIDOR responde >> " + respuesta);

                    if (comando.equalsIgnoreCase("FIN")) {
                        System.out.println("Cerrando aplicación cliente...");
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error: No se pudo establecer el enlace con el servidor.");
            }
        }
    }
