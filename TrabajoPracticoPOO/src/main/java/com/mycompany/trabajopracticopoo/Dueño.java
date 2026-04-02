package com.mycompany.trabajopracticopoo;

import java.util.ArrayList;

public class Dueño extends Persona {
    private String             dni;
    private ArrayList<Mascota> mascotas;

    public Dueño(String nombre, String telefono, String dni) {
        super(nombre, telefono);
        this.dni      = dni;
        this.mascotas = new ArrayList<>();
    }

    public String             getDni()      { return dni; }
    public ArrayList<Mascota> getMascotas() { return mascotas; }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
        System.out.println("Mascota: " + m.getNombre()
                + " registrada para: " + getNombre());
    }

    public void mostrarMascotas() {
        System.out.println("  Mascotas de: " + getNombre());
        if (mascotas.isEmpty()) {
            System.out.println("    (sin mascotas registradas)");
        } else {
            for (Mascota m : mascotas) m.mostrarDatos();
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Dueño: " + getNombre()
                + " | DNI: " + dni
                + " | Tel: " + getTelefono());
    }
}