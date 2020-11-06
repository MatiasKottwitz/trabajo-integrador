/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.servicio;

import edu.iesa.modelo.Conferencia;
import edu.iesa.modelo.Entidad;
import edu.iesa.repositorio.Repositorio;
import java.util.List;

/**
 *
 * @author matias
 */
public class Servicio {
    
    private Repositorio repositorio;
    
    public List listarEntidades(){
        return this.repositorio.buscarTodos(Entidad.class);
    }
    public List listarConferencia(){
        return this.repositorio.buscarTodos(Conferencia.class);
    }
}
