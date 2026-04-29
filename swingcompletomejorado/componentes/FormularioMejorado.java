package com.mycompany.swingcompletomejorado.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormularioMejorado extends JFrame {

    private JTextField txtNombre, txtApellido, txtDni, txtCP, txtDireccion;

    public FormularioMejorado() {
        setTitle("Formulario Completo");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2, 5, 5));

        // Campos
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("DNI:"));
        txtDni = new JTextField();
        add(txtDni);

        add(new JLabel("Código Postal:"));
        txtCP = new JTextField();
        add(txtCP);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        JCheckBox check = new JCheckBox("Aceptar términos");
        add(check);

        JButton btnSaludar = new JButton("Enviar");
        JButton btnLimpiar = new JButton("Limpiar");

        add(btnSaludar);
        add(btnLimpiar);

        // Validación: solo números en DNI
        txtDni.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        // Validación: solo números y máximo 4 en CP
        txtCP.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) || txtCP.getText().length() >= 4) {
                    e.consume();
                }
            }
        });

        // Botón Enviar
        btnSaludar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() ||
                txtApellido.getText().isEmpty() ||
                txtDni.getText().isEmpty() ||
                txtCP.getText().isEmpty() ||
                txtDireccion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            if (!check.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debe aceptar los términos");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Datos cargados:\n" +
                    "Nombre: " + txtNombre.getText() + "\n" +
                    "Apellido: " + txtApellido.getText() + "\n" +
                    "DNI: " + txtDni.getText() + "\n" +
                    "CP: " + txtCP.getText() + "\n" +
                    "Dirección: " + txtDireccion.getText()
            );
        });

        // Botón limpiar
        btnLimpiar.addActionListener(e -> {
            txtNombre.setText("");
            txtApellido.setText("");
            txtDni.setText("");
            txtCP.setText("");
            txtDireccion.setText("");
            check.setSelected(false);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioMejorado().setVisible(true);
        });
    }
}
