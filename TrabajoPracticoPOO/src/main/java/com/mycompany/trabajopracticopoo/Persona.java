package com.mycompany.trabajopracticopoo;

public abstract class Persona {
    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre()   { return nombre; }
    public String getTelefono() { return telefono; }

    public void setNombre(String nombre)     { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public abstract void mostrarInfo();
}