package com.mycompany.trabajopracticopoo;

public class Gato extends Mascota {
    private String colorPelaje;

    public Gato(String nombre, int edad, String colorPelaje) {
        super(nombre, edad);
        this.colorPelaje = colorPelaje;
    }

    public String getColorPelaje() { return colorPelaje; }

    @Override
    public String hacerSonido() { return "¡Miau Miau!"; }

    @Override
    public void mostrarDatos() {
        System.out.println("    [Gato]   " + getNombre()
                + " | Pelaje: " + colorPelaje
                + " | Edad: "   + getEdad() + " años"
                + " | "         + hacerSonido());
    }
}