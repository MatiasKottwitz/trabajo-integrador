/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, cho,ose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa;
import edu.iesa.modelo.Persona;
import javax.persistence.Persistence;
import edu.iesa.modelo.Entidad;

/**
 *
 * @author matias
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("IntegradorPU");
        var em = emf.createEntityManager();
        /*var entidad1 = new Entidad();
        var persona1 = new Persona("Matias","Kottvitz",34447709,entidad1);
        em.getTransaction().begin();
        em.persist(persona1);
        em.getTransaction().commit();
        em.close();
        emf.close();*/
        
    }
    
}
