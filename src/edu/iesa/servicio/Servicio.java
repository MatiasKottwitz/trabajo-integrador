/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.servicio;

import edu.iesa.modelo.Conferencia;
import edu.iesa.modelo.Entidad;
import edu.iesa.modelo.Entidad_;
import edu.iesa.modelo.Persona;
import edu.iesa.modelo.Persona_;
import edu.iesa.repositorio.Repositorio;
import java.util.List;

/**
 *
 * @author matias
 */
public class Servicio {
    
    private  Repositorio repositorio;
    
    public Servicio(Repositorio p) {
        this.repositorio = p;
    }
    public void agregarEntidad(long cuit,String nombre,boolean tipo){
        this.repositorio.iniciarTransaccion();
        Entidad entidad = new Entidad(cuit,nombre,tipo);
        this.repositorio.insertar(entidad);
        this.repositorio.confirmarTransaccion();
    }
    
    public long eliminarEntidad(long cuit){
        this.repositorio.iniciarTransaccion();
        Entidad entidad = this.repositorio.buscar(Entidad.class, cuit);
        // si la entidad existe
        if (entidad != null) {
            this.repositorio.eliminar(entidad);
            this.repositorio.confirmarTransaccion();
            return 0;
        } else {
            this.repositorio.descartarTransaccion();
            return 1;
        }
    }
    
    public void editarEntidad(Entidad entidad1, long cuit,String nombre,boolean tipo){
        this.repositorio.iniciarTransaccion();
        Entidad entidad = this.repositorio.buscar(Entidad.class, entidad1.getCuit());
         if (entidad != null) {
            entidad.setCuit(cuit);
            entidad.setNombre(nombre.toUpperCase().trim());
            entidad.setTipo(tipo);
            this.repositorio.modificar(entidad);
            this.repositorio.confirmarTransaccion();
        } else {
            this.repositorio.descartarTransaccion();
        }
    }
    
    public List listarEntidades(){
        return this.repositorio.buscarTodosOrdenadosPor(Entidad.class,Entidad_.cuit);
    }
    
    public List listarEntidadesPorNombre(){
        return this.repositorio.buscarTodosOrdenadosPorNombre(Entidad.class,Entidad_.cuit);
    }
    
    public void editarPersona(Persona persona1, String nombre, String apellido, Long documento, Entidad entidad1 ){
        this.repositorio.iniciarTransaccion();
        Persona persona = this.repositorio.buscar(Persona.class, persona1.getIdPersona());
         if (persona != null) {
            persona.setNombres(nombre.toUpperCase().trim());
            persona.setApellidos(apellido.toUpperCase().trim());
            persona.setDocumento(documento);
            this.repositorio.modificar(persona);
            this.repositorio.confirmarTransaccion();
        } else {
            this.repositorio.descartarTransaccion();
        }
    }
    
    public void agregarPersona(String nombre, String apellido, long documento,Entidad entidad1){
        this.repositorio.iniciarTransaccion();
        Persona persona = new Persona(nombre,apellido,documento,entidad1);
        this.repositorio.insertar(persona);
        this.repositorio.confirmarTransaccion();
    }
    
    public long eliminarPersona(long idPersona){
        this.repositorio.iniciarTransaccion();
        Persona persona = this.repositorio.buscar(Persona.class, idPersona);
        // si la persona existe
        if (persona != null) {
            this.repositorio.eliminar(persona);
            this.repositorio.confirmarTransaccion();
            return 0;
        } else {
            this.repositorio.descartarTransaccion();
            return 1;
        }
    }
    public List listarPersonas(){
        return this.repositorio.buscarTodosOrdenadosPor(Persona.class,Persona_.idPersona);
    }
    
    public List listarConferencia(){
        return this.repositorio.buscarTodos(Conferencia.class);
    }
}
