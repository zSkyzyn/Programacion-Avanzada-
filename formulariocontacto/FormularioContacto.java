

package com.mycompany.formulariocontacto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class FormularioContacto extends JFrame {

    private JTextField txtNombre, txtApellido, txtDni, txtPasaporte, txtTelefono, txtCP;
    private JTextField txtDomicilio;
    private JButton btnValidar, btnLimpiar, btnCerrar;

    public FormularioContacto() {
        setTitle("Carga de Contacto");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        // Campos
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtDni = new JTextField();
        txtPasaporte = new JTextField();
        txtTelefono = new JTextField();
        txtCP = new JTextField();
        txtDomicilio = new JTextField();

        // Limitar caracteres
        limitarTexto(txtNombre, 20);
        limitarTexto(txtApellido, 20);
        limitarTexto(txtDomicilio, 50);

        soloLetras(txtNombre);
        soloLetras(txtApellido);

        soloNumeros(txtDni, 8);
        soloNumeros(txtCP, 4);

        // Labels + campos
        add(new JLabel("Nombre:"));
        add(txtNombre);

        add(new JLabel("Apellido:"));
        add(txtApellido);

        add(new JLabel("DNI:"));
        add(txtDni);

        add(new JLabel("Pasaporte:"));
        add(txtPasaporte);

        add(new JLabel("Teléfono:"));
        add(txtTelefono);

        add(new JLabel("Código Postal:"));
        add(txtCP);

        add(new JLabel("Domicilio:"));
        add(txtDomicilio);

        // Botones
        btnValidar = new JButton("Validar");
        btnLimpiar = new JButton("Limpiar");
        btnCerrar = new JButton("Cerrar");

        add(btnValidar);
        add(btnLimpiar);
        add(btnCerrar);

        // Eventos
        btnValidar.addActionListener(e -> validarFormulario());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnCerrar.addActionListener(e -> System.exit(0));
    }

    // 🔹 Validación final
    private void validarFormulario() {

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String dni = txtDni.getText();
        String pasaporte = txtPasaporte.getText();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y Apellido obligatorios");
            return;
        }

        // DNI rango
        if (!dni.isEmpty()) {
            int valor = Integer.parseInt(dni);
            if (valor < 10000000 || valor > 60000000) {
                JOptionPane.showMessageDialog(this, "DNI fuera de rango");
                return;
            }
        }

        // Pasaporte formato
        if (!pasaporte.isEmpty()) {
            if (!pasaporte.matches("[A-Z][0-9]{8}")) {
                JOptionPane.showMessageDialog(this, "Formato de pasaporte inválido");
                return;
            }
        }

        // DNI o Pasaporte (solo uno)
        if (!dni.isEmpty() && !pasaporte.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Solo DNI o Pasaporte, no ambos");
            return;
        }

        JOptionPane.showMessageDialog(this, "Formulario válido ✅");
    }

    // 🔹 Limpiar
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtPasaporte.setText("");
        txtTelefono.setText("");
        txtCP.setText("");
        txtDomicilio.setText("");
    }

    // 🔹 Restricciones

    private void limitarTexto(JTextField campo, int max) {
        campo.setDocument(new PlainDocument() {
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if ((getLength() + str.length()) <= max) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    private void soloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });
    }

    private void soloNumeros(JTextField campo, int max) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || campo.getText().length() >= max) {
                    e.consume();
                }
            }
        });
    }

    // 🔹 MAIN
    public static void main(String[] args) {
        new FormularioContacto().setVisible(true);
    }
}