package com.mycompany.swingcompletomejorado.layouts;

import javax.swing.*;
import java.awt.*;

public class CalculadoraUI extends JFrame {

    public CalculadoraUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4,4,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        String botones[] = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","=","+","C"
        };

        for(String txt : botones){
            JButton b = new JButton(txt);
            b.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraUI().setVisible(true);
        });
    }
}