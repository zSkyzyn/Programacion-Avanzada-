package com.mycompany.swingcompletomejorado.ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaMejorada extends JFrame {

    public VentanaMejorada() {
        setTitle("Ventana Mejorada");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel label = new JLabel("Bienvenido a Swing");
        label.setFont(new Font("Arial", Font.BOLD, 16));

        add(label);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaMejorada().setVisible(true);
        });
    }
}