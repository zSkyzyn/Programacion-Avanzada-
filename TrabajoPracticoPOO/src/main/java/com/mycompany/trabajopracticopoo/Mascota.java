package com.mycompany.trabajopracticopoo;

public abstract class Mascota {
    private String nombre;
    private int    edad;

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad   = edad;
    }

    public String getNombre() { return nombre; }
    public int    getEdad()   { return edad; }

    public abstract String hacerSonido();

    public void mostrarDatos() {
        System.out.println("  Mascota: " + nombre
                + " | Edad: " + edad + " años"
                + " | Sonido: " + hacerSonido());
    }
}