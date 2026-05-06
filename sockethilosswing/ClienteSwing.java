

package com.mycompany.sockethilosswing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class ClienteSwing extends JFrame {

    private JTextField txtUsuario;
    private JTextArea areaChat;
    private JTextField txtMensaje;
    private PrintWriter out;

    public ClienteSwing() {
        setTitle("Cliente Chat");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // 🔹 Panel usuario
        JPanel top = new JPanel();
        top.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField(10);
        JButton btnConectar = new JButton("Conectar");
        top.add(txtUsuario);
        top.add(btnConectar);

        add(top, BorderLayout.NORTH);

        // 🔹 Chat
        areaChat = new JTextArea();
        areaChat.setEditable(false);
        add(new JScrollPane(areaChat), BorderLayout.CENTER);

        // 🔹 Mensaje
        JPanel bottom = new JPanel(new BorderLayout());
        txtMensaje = new JTextField();
        JButton btnEnviar = new JButton("Enviar");

        bottom.add(txtMensaje, BorderLayout.CENTER);
        bottom.add(btnEnviar, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        // 🔌 Conectar
        btnConectar.addActionListener(e -> conectar());

        // 📤 Enviar
        btnEnviar.addActionListener(e -> enviarMensaje());
    }

    private void conectar() {
        try {
            String usuario = txtUsuario.getText();

            // VALIDACIONES
            if (!validarUsuario(usuario)) return;

            Socket socket = new Socket("127.0.0.1", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(usuario);

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        areaChat.append(msg + "\n");
                    }
                } catch (Exception e) {
                    areaChat.append("Desconectado\n");
                }
            }).start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar");
        }
    }

    private boolean validarUsuario(String u) {

        if (u == null || u.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Usuario obligatorio");
            return false;
        }

        if (u.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Sin espacios");
            return false;
        }

        if (u.length() < 3) {
            JOptionPane.showMessageDialog(this, "Mínimo 3 caracteres");
            return false;
        }

        if (!u.matches("[a-zA-Z0-9_-]+")) {
            JOptionPane.showMessageDialog(this, "Solo letras, números, _ y -");
            return false;
        }

        return true;
    }

    private void enviarMensaje() {
        String msg = txtMensaje.getText().trim();

        if (msg.isEmpty()) return;

        out.println(msg);
        txtMensaje.setText("");

        if (msg.equalsIgnoreCase("/SALIR")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ClienteSwing().setVisible(true);
    }
}
