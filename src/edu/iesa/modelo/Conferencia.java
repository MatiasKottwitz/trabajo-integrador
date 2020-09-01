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
public class Conferencia {
    private long idUnico;
    private String denominacion;
    private List<Edicion> ediciones = new ArrayList<>();

    public Conferencia() {
    }

    public Conferencia(long idUnico, String denominacion) {
        this.idUnico = idUnico;
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
