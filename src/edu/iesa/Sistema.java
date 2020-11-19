/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, cho,ose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa;
import edu.iesa.modelo.Persona;
import javax.persistence.Persistence;
import edu.iesa.modelo.Entidad;
import edu.iesa.repositorio.Repositorio;
import edu.iesa.servicio.Servicio;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import edu.iesa.vistas.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author matias
 */
public class Sistema extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }

     @Override
    public void start(Stage stage) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegradorPU"); //La base de datos se llama Integrador.
        Servicio servicio = new Servicio(new Repositorio(emf));
        
        //Creacion de Vistas
        VistaEntidades vistaEntidades = new VistaEntidades(servicio);
        
        //Botones para navegacion entre vistas
        Button entidadesButton = new Button("Entidades");
        Button personasButton = new Button("Personas");
        Button conferenciasButton = new Button("Conferencas");
        Button registroButton = new Button("Registro");
        
        // separadores
        Separator separador1 = new Separator(Orientation.HORIZONTAL);
        Separator separador2 = new Separator(Orientation.HORIZONTAL);
        Separator separador3 = new Separator(Orientation.HORIZONTAL);
        Separator separador4 = new Separator(Orientation.HORIZONTAL);
        
        // contenedor de botones y separadores
        VBox contenedorBotones = new VBox();
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setPadding(new Insets(10, 10, 10, 10));
        contenedorBotones.setSpacing(10);
        contenedorBotones.getChildren().addAll(entidadesButton, separador1, personasButton, separador2, conferenciasButton, separador3, registroButton);
        
        // contenedor de botones y separadores con cambiante
        HBox contenedorPrincipal = new HBox();
        Separator separador5 = new Separator(Orientation.VERTICAL);
        // cambiante
        Group cambiante = new Group();
        contenedorPrincipal.getChildren().addAll(contenedorBotones, separador5, cambiante);
        
        // que muestro inicialmente
        cambiante.getChildren().add(vistaEntidades.obtenerVista());
        
        // escena  principal
        Scene escena = new Scene(contenedorPrincipal);
        stage.setScene(escena);
        stage.setTitle("Entidades");
        stage.setResizable(false);
        stage.show();
        
    }
    
}
