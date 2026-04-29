package com.mycompany.swingcompletomejorado.componentes;

import javax.swing.*;
import java.awt.*;

public class FormularioMejorado extends JFrame {

    private JTextField txtNombre;

    public FormularioMejorado() {
        setTitle("Formulario");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        add(txtNombre);

        JCheckBox check = new JCheckBox("Aceptar términos");
        add(check);

        JButton btnSaludar = new JButton("Saludar");
        JButton btnLimpiar = new JButton("Limpiar");

        add(btnSaludar);
        add(btnLimpiar);

        btnSaludar.addActionListener(e -> {
            if(txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese nombre");
            } else {
                JOptionPane.showMessageDialog(this, "Hola " + txtNombre.getText());
            }
        });

        btnLimpiar.addActionListener(e -> txtNombre.setText(""));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioMejorado().setVisible(true);
        });
    }
}