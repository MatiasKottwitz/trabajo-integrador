/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matias
 */
public class Persona {
    private String nombres;
    private String apellidos;
    private long documento;
    private Entidad entidad;
    private List<Inscripcion> inscripciones= new ArrayList<>();

    
    //Cosntructor.
    public Persona(){
        
    }
    public Persona(String nombres, String apellidos, long documento, Entidad entidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.entidad = entidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    
}
