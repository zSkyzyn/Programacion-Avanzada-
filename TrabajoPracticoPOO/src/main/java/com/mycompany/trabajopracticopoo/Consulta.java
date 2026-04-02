
package com.mycompany.trabajopracticopoo;

class Consulta {
 
    private String  fecha;
    private String  motivo;
    private Mascota mascota;
 
    public Consulta(String fecha, String motivo, Mascota mascota) {
        this.fecha   = fecha;
        this.motivo  = motivo;
        this.mascota = mascota;
    }
 
    public String  getFecha()   { return fecha;   }
    public String  getMotivo()  { return motivo;  }
    public Mascota getMascota() { return mascota; }
 
    public void mostrarConsulta() {
        System.out.println("  Consulta: " + fecha
                + " | Paciente: " + mascota.getNombre()
                + " | Motivo: "   + motivo);
    }
}
