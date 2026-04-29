package com.mycompany.swingcompletomejorado.mvc;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    JTextField campo = new JTextField(15);
    JButton boton = new JButton("Guardar");
    JLabel resultado = new JLabel("Resultado");

    public Vista() {
        setLayout(new FlowLayout());

        add(campo);
        add(boton);
        add(resultado);

        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}