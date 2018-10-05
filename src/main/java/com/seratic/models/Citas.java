
package com.seratic.models;


public class Citas {
    int id_cita;
    String ced_pa, nombreP, apellidoP, ced_D, nombreD, apellidoD, fecha, hora;

    public Citas() {
    }

    public Citas(int id_cita, String ced_pa, String nombreP, String apellidoP, String ced_D, String nombreD, String apellidoD, String fecha, String hora) {
        this.id_cita = id_cita;
        this.ced_pa = ced_pa;
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.ced_D = ced_D;
        this.nombreD = nombreD;
        this.apellidoD = apellidoD;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getCed_pa() {
        return ced_pa;
    }

    public void setCed_pa(String ced_pa) {
        this.ced_pa = ced_pa;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getCed_D() {
        return ced_D;
    }

    public void setCed_D(String ced_D) {
        this.ced_D = ced_D;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getApellidoD() {
        return apellidoD;
    }

    public void setApellidoD(String apellidoD) {
        this.apellidoD = apellidoD;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
