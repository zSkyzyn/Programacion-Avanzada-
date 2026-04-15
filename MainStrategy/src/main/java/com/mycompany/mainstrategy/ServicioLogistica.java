
package com.mycompany.mainstrategy;

public class ServicioLogistica {
    private EstrategiaEnvio estrategia;

    public void setEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }

    public void calcular(double km) {
        System.out.println("Costo final: $" + estrategia.calcularCosto(km));
    }
}