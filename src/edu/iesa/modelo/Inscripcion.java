/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.modelo;

/**
 *
 * @author matias
 */
public class Inscripcion {
    private long idinscripcion;
    private Persona persona;
    private boolean expositor;
    private boolean presencial;
    private Entidad entidad;
    private Edicion edicion;

    public Inscripcion() {
    }

    public Inscripcion(long idinscripcion, Persona persona, boolean expositor, boolean presencial, Entidad entidad, Edicion edicion) {
        this.idinscripcion = idinscripcion;
        this.persona = persona;
        this.expositor = expositor;
        this.presencial = presencial;
        this.entidad = entidad;
        this.edicion = edicion;
    }

    public long getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(long idinscripcion) {
        this.idinscripcion = idinscripcion;
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

