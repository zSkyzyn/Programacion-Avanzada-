package com.mycompany.swingcompletomejorado.mvc;

public class MainMVC {

    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v = new Vista();

        new Controlador(m, v);

        v.setVisible(true);
    }
}