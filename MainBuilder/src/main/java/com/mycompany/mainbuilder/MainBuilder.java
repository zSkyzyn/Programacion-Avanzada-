
package com.mycompany.mainbuilder;

public class MainBuilder {
    public static void main(String[] args) {
        Computadora gamerPC = new ComputadoraBuilder()
                .setProcesador("AMD Ryzen 9")
                .setRam(64)
                .setTieneGPU(true)
                .setAlmacenamiento(2000)
                .build();
        
        System.out.println(gamerPC);
    }
}