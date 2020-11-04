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
public class Conferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUnico;
    private String denominacion;
    @OneToMany //Relacion Una conferencia para muchas ediciones.
    private List<Edicion> ediciones = new ArrayList<>();

    public Conferencia() {
    }

    public Conferencia(String denominacion) {
        this.denominacion = denominacion;
    }

    public long getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(long idUnico) {
        this.idUnico = idUnico;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(List<Edicion> ediciones) {
        this.ediciones = ediciones;
    }
    
    
    
}
