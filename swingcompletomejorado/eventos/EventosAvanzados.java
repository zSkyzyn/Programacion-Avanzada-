package com.mycompany.swingcompletomejorado.eventos;

import javax.swing.*;
import java.awt.*;

public class EventosAvanzados extends JFrame {

    int contador = 0;

    public EventosAvanzados() {
        setTitle("Eventos");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JButton btn = new JButton("Click");
        JLabel label = new JLabel("Clicks: 0");

        add(btn);
        add(label);

        btn.addActionListener(e -> {
            contador++;
            label.setText("Clicks: " + contador);
            btn.setBackground(Color.CYAN);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EventosAvanzados().setVisible(true);
        });
    }
}