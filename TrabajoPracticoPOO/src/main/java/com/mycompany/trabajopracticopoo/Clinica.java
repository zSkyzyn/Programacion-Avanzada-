
package com.mycompany.trabajopracticopoo;

import java.util.ArrayList;
        
class Clinica {
 
    private String          nombre;
    private ArrayList<Dueño>    duenios;
    private ArrayList<Veterinario> vets;
    private ArrayList<Consulta>  consultas;
 
    public Clinica(String nombre) {
        this.nombre    = nombre;
        this.duenios   = new ArrayList<>();
        this.vets      = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }
 
    public void registrarDuenio(Dueño d) {
        duenios.add(d);
        System.out.println("Dueño registrado: " + d.getNombre());
    }
 
    public void registrarVeterinario(Veterinario v) {
        vets.add(v);
        System.out.println("Veterinario registrado: " + v.getNombre());
    }
 
    public void registrarConsulta(Consulta c, Veterinario v) {
        consultas.add(c);
        System.out.println("\n--- Nueva consulta ---");
        v.atenderConsulta(c);
    }
 
    public void mostrarResumen() {
        System.out.println("\n====================================");
        System.out.println("  CLÍNICA: " + nombre);
        System.out.println("====================================");
 
        System.out.println("\n-- Personal veterinario --");
        for (Veterinario v : vets) v.mostrarInfo();
 
        System.out.println("\n-- Dueños y mascotas --");
        for (Dueño d : duenios) {
            d.mostrarInfo();
            d.mostrarMascotas();
        }
 
        System.out.println("\n-- Historial de consultas --");
        if (consultas.isEmpty()) {
            System.out.println("  (sin consultas registradas)");
        } else {
            for (Consulta c : consultas) c.mostrarConsulta();
        }
        System.out.println("====================================\n");
    }
}
