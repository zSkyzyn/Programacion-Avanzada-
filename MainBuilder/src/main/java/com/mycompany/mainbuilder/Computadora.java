
package com.mycompany.mainbuilder;

public class Computadora {
    private String procesador;
    private int ram;
    private boolean tieneGPU;
    private int almacenamiento;

    // Constructor protegido para ser usado por el Builder
    protected Computadora(String procesador, int ram, boolean tieneGPU, int almacenamiento) {
        this.procesador = procesador;
        this.ram = ram;
        this.tieneGPU = tieneGPU;
        this.almacenamiento = almacenamiento;
    }

    @Override
    public String toString() {
        return "PC: [CPU: " + procesador + ", RAM: " + ram + "GB, GPU: " + tieneGPU + ", Disco: " + almacenamiento + "GB]";
    }
}