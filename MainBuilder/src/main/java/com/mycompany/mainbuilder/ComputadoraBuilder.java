
package com.mycompany.mainbuilder;

public class ComputadoraBuilder {
    private String procesador;
    private int ram;
    private boolean tieneGPU;
    private int almacenamiento;

    public ComputadoraBuilder setProcesador(String procesador) {
        this.procesador = procesador;
        return this;
    }

    public ComputadoraBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public ComputadoraBuilder setTieneGPU(boolean tieneGPU) {
        this.tieneGPU = tieneGPU;
        return this;
    }

    public ComputadoraBuilder setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
        return this;
    }

    public Computadora build() {
        return new Computadora(procesador, ram, tieneGPU, almacenamiento);
    }
}