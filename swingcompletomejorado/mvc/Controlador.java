package com.mycompany.swingcompletomejorado.mvc;

public class Controlador {

    public Controlador(Modelo m, Vista v) {

        v.boton.addActionListener(e -> {
            m.setTexto(v.campo.getText());
            v.resultado.setText(m.getTexto());
        });
    }
}