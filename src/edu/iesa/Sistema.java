/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa;

import javax.persistence.Persistence;

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
    }
    
}
