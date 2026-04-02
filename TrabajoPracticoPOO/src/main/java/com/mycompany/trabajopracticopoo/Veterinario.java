package com.mycompany.trabajopracticopoo;

public class Veterinario extends Persona {
    private String matricula;
    private String especialidad;

    public Veterinario(String nombre, String telefono,
                       String matricula, String especialidad) {
        super(nombre, telefono);
        this.matricula    = matricula;
        this.especialidad = especialidad;
    }

    public String getMatricula()    { return matricula; }
    public String getEspecialidad() { return especialidad; }

    public void atenderConsulta(Consulta c) {
        System.out.println("  Dr/a. " + getNombre()
                + " atiende a: " + c.getMascota().getNombre()
                + " — Motivo: "  + c.getMotivo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Veterinario: " + getNombre()
                + " | Matrícula: "    + matricula
                + " | Especialidad: " + especialidad);
    }
}
