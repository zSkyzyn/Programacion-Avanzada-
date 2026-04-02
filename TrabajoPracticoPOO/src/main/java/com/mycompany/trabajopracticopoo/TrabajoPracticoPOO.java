

package com.mycompany.trabajopracticopoo;

import java.util.ArrayList;


public class TrabajoPracticoPOO {
 
    public static void main(String[] args) {
 
        // 1. Crear la clínica
        Clinica clinica = new Clinica("VetPaws");
 
        // 2. Registrar veterinarios
        Veterinario vet1 = new Veterinario("Laura Gómez",  "011-1234", "MAT-001", "Clínica general");
        Veterinario vet2 = new Veterinario("Marcos Ruiz",  "011-5678", "MAT-002", "Cirugía");
        clinica.registrarVeterinario(vet1);
        clinica.registrarVeterinario(vet2);
 
        // 3. Crear mascotas
        Perro p1 = new Perro("Fido",    3, "Labrador");
        Perro p2 = new Perro("Rex",     5, "Pastor alemán");
        Gato  g1 = new Gato("Mishi",   2, "Naranja");
        Gato  g2 = new Gato("Sombra",  4, "Negro");
 
        // 4. Crear dueños y asignar mascotas
        Dueño d1 = new Dueño("Ana Torres",   "011-9999", "30111222");
        Dueño d2 = new Dueño("Carlos López", "011-8888", "28333444");
 
        clinica.registrarDuenio(d1);
        d1.agregarMascota(p1);
        d1.agregarMascota(g1);
 
        clinica.registrarDuenio(d2);
        d2.agregarMascota(p2);
        d2.agregarMascota(g2);
 
        // 5. Registrar consultas
        Consulta c1 = new Consulta("2025-06-01", "Control anual",   p1);
        Consulta c2 = new Consulta("2025-06-02", "Herida en pata",  g1);
        Consulta c3 = new Consulta("2025-06-03", "Castración",      p2);
 
        clinica.registrarConsulta(c1, vet1);
        clinica.registrarConsulta(c2, vet1);
        clinica.registrarConsulta(c3, vet2);
 
        // 6. Polimorfismo en acción: recorremos mascotas con tipo base
        System.out.println("\n-- Demostración de polimorfismo --");
        ArrayList<Mascota> todasLasMascotas = new ArrayList<>();
        todasLasMascotas.add(p1);
        todasLasMascotas.add(p2);
        todasLasMascotas.add(g1);
        todasLasMascotas.add(g2);
 
        for (Mascota m : todasLasMascotas) {
            // Cada objeto responde a su propia versión de hacerSonido()
            System.out.println("  " + m.getNombre() + " dice: " + m.hacerSonido());
        }
 
        // 7. Resumen general de la clínica
        clinica.mostrarResumen();
    }
}
