/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author matias
 */
@Entity
public class Edicion {
    @Id
    private long id_Edicion;
    private String lugar;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @ManyToOne //Relacion Muchas Ediciones para una Conferencia.
    private Conferencia conferencia;
    @OneToMany //Relacion Una Edicion para muchas Inscripciones.
    private List<Inscripcion> inscripciones= new ArrayList<>();

    public Edicion() {
    }

    public Edicion(String lugar, LocalDate fechaInicio, LocalDate fechaFin, Conferencia conferencia) {
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.conferencia = conferencia;
    }

    

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public long getId_Edicion() {
        return id_Edicion;
    }

    public void setId_Edicion(long id_Edicion) {
        this.id_Edicion = id_Edicion;
    }

    
    
    
}
