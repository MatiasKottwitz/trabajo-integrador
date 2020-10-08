/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.OneToMany;

/**
 *
 * @author matias
 */
@Entity
public class Entidad {
    @Id
    private long cuit;
    private String nombre;
    private boolean tipo;
    @OneToMany
    private List<Persona> personas= new ArrayList<>();
    @OneToMany
    private List<Inscripcion> inscripciones = new ArrayList<>();

    
    //CONTRUCTOR
    public Entidad(){
        
    }

    public Entidad(long cuit, String nombre, boolean tipo) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.tipo = tipo;
    }

   
    
    
    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return "Entidad: "+this.nombre;
    }
    
    
}
