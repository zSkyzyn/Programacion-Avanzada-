package com.mycompany.swingcompletomejorado;

import javax.swing.*;

import com.mycompany.swingcompletomejorado.ventanas.VentanaMejorada;
import com.mycompany.swingcompletomejorado.componentes.FormularioMejorado;
import com.mycompany.swingcompletomejorado.layouts.CalculadoraUI;
import com.mycompany.swingcompletomejorado.eventos.EventosAvanzados;
import com.mycompany.swingcompletomejorado.graficos.VentanaDibujo;

public class SwingCompletoMejorado {

    public static void main(String[] args) {

        String opcion = JOptionPane.showInputDialog(
                "1 - Ventana\n" +
                "2 - Formulario\n" +
                "3 - Calculadora\n" +
                "4 - Eventos\n" +
                "5 - Dibujo"
        );

        switch(opcion){
            case "1": new VentanaMejorada().setVisible(true); break;
            case "2": new FormularioMejorado().setVisible(true); break;
            case "3": new CalculadoraUI().setVisible(true); break;
            case "4": new EventosAvanzados().setVisible(true); break;
            case "5": new VentanaDibujo().setVisible(true); break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
}