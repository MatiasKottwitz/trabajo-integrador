/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.ManyToOne;

/**
 *
 * @author matiasÍ
 */
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInscripcion;
    @ManyToOne //Relacion Muchas inscripciones para Una Persona.
    private Persona persona;
    private boolean expositor;
    private boolean presencial;
    @ManyToOne //Relacion Muchas inscripciones para Una Entidad.
    private Entidad entidad;
    @ManyToOne //Relacion Muchas inscripciones para una edicion.
    private Edicion edicion;

    public Inscripcion() {
    }

    public Inscripcion(Persona persona, boolean expositor, boolean presencial, Entidad entidad, Edicion edicion) {
        this.persona = persona;
        this.expositor = expositor;
        this.presencial = presencial;
        this.entidad = entidad;
        this.edicion = edicion;
    }

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idinscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean isExpositor() {
        return expositor;
    }

    public void setExpositor(boolean expositor) {
        this.expositor = expositor;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }
}

