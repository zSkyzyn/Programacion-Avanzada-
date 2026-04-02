package com.mycompany.trabajopracticopoo;

public class Perro extends Mascota {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public String getRaza() { return raza; }

    @Override
    public String hacerSonido() { return "¡Guau Guau!"; }

    @Override
    public void mostrarDatos() {
        System.out.println("    [Perro]  " + getNombre()
                + " | Raza: "  + raza
                + " | Edad: "  + getEdad() + " años"
                + " | "        + hacerSonido());
    }
}