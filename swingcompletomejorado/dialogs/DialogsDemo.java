package com.mycompany.swingcompletomejorado.dialogs;

import javax.swing.*;

public class DialogsDemo {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if(opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Hola " + nombre,
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Cancelado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}