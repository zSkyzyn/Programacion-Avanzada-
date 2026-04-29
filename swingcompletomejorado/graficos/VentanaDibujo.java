package com.mycompany.swingcompletomejorado.graficos;

import javax.swing.*;

public class VentanaDibujo extends JFrame {

    public VentanaDibujo() {
        setTitle("Dibujo");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new PanelDibujo());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaDibujo().setVisible(true);
        });
    }
}