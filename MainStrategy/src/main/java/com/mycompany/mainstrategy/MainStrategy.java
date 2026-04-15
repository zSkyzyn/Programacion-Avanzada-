

package com.mycompany.mainstrategy;

public class MainStrategy {
    public static void main(String[] args) {
        ServicioLogistica logistica = new ServicioLogistica();
        
        // Cliente elige Moto
        logistica.setEstrategia(new EnvioMoto());
        logistica.calcular(10.5);
        
        // Cliente elige Camión
        logistica.setEstrategia(new EnvioCamion());
        logistica.calcular(10.5);
    }
}