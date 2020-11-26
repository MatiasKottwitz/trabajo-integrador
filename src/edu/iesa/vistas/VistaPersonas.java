/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.vistas;

import edu.iesa.modelo.Entidad;
import edu.iesa.modelo.Entidad_;
import edu.iesa.modelo.Persona;
import edu.iesa.servicio.Servicio;
import edu.iesa.repositorio.Repositorio;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author matias
 */
public class VistaPersonas implements Vista{

    private Servicio servicios;
    private Repositorio repo;
    private Persona personaSeleccionada;
    private Entidad entidadElegida;
    //private ObservableList <Entidad> entidades = FXCollections.observableArrayList();
    
    public VistaPersonas(Servicio servicio) {
        this.servicios = servicio;
    }
    
    @Override
    public Parent obtenerVista() {
        //definicion de los componentes de la interfaz.
     
        Label tituloLabel = new Label("Administracion de Personas");
        tituloLabel.setFont(Font.font("Arial",18));
        Label nombreLabel=new Label ("Nombre");
        TextField nombreTextField = new TextField();
        Label apellidoLabel=new Label ("Apellido");
        TextField apellidoTextField = new TextField();
        Label documentoLabel=new Label ("Documento");
        TextField documentoTextField = new TextField();
        Label entidadLabel=new Label ("Entidad");
        ComboBox comboentidades = new ComboBox();
        comboentidades.setValue("Seleccionar Entidad");
        Button nuevoButton = new Button("Nuevo");
        Button guardarButton = new Button("Guardar");
        Button eliminarButton = new Button("Eliminar");
        Label personaLabel=new Label ("Personas: ");
        ListView<Persona> personasListView = new ListView();
        personasListView.setPrefHeight(100);
        Separator separador = new Separator(Orientation.HORIZONTAL);
        
        
        //Dibujo de los elementos de la interfaz.
        GridPane contenedorDatos = new GridPane();
        contenedorDatos.setHgap(10);
        contenedorDatos.setVgap(10);
        
        contenedorDatos.add(tituloLabel, 2, 0);
        
        contenedorDatos.add(nombreLabel, 1, 1, 1, 1);
        contenedorDatos.add(nombreTextField,2,1,1,1);
        
        contenedorDatos.add(apellidoLabel, 1, 2, 1, 1);
        contenedorDatos.add(apellidoTextField,2,2,1,1);
        
        contenedorDatos.add(documentoLabel, 1, 3, 1, 1);
        contenedorDatos.add(documentoTextField,2,3,1,1);
        
        contenedorDatos.add(entidadLabel,1,4,1,1);
        contenedorDatos.add(comboentidades,2,4);
        
        //GridPane.setMargin(nuevoButton, new Insets(0,0,0,0));
        contenedorDatos.add(nuevoButton, 2, 5);
        GridPane.setMargin(guardarButton, new Insets(0,0,0,-160));
        contenedorDatos.add(guardarButton,3,5);
        GridPane.setMargin(eliminarButton, new Insets(0,0,0,-90));
        contenedorDatos.add(eliminarButton, 4, 5);
        
        contenedorDatos.add(separador, 1, 6,10,1);
        
        contenedorDatos.add(personaLabel,1,7);
        contenedorDatos.add(personasListView,1,8,10,15);
        
        contenedorDatos.setPadding(new Insets(16));
        HBox contenedor = new HBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(contenedorDatos);
        personasListView.getSelectionModel().select(null);
        limpiar(personasListView);
        nuevoButton.setOnAction((ActionEvent eh) -> {
            // dejo sin seleccionar items de la lista
            personasListView.getSelectionModel().select(null);
        });
        //Accion del boton guardar.
        guardarButton.setOnAction((var eh) -> {
            Long entrada;
            try {
                entrada = Long.parseLong(documentoTextField.getText());
            } catch (NumberFormatException e) {
                // Mostramos un alerta por error en convertir un String en int
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("EL CUIT INGRESADO DEBE SER UN NUMERO");
                a.setTitle("Formato Incorrecto!");
                a.show();
            }
            // modificar
            this.entidadElegida = (Entidad) comboentidades.getSelectionModel().getSelectedItem();
            if (personasListView.getSelectionModel().getSelectedItem() != null) {
                this.servicios.editarPersona(this.personaSeleccionada,
                        nombreTextField.getText(),apellidoTextField.getText(),
                        Long.parseLong(documentoTextField.getText()),this.entidadElegida);               
            } else {
                // agregar
                this.servicios.agregarPersona(nombreTextField.getText(),
                        apellidoTextField.getText(),
                        Long.parseLong(documentoTextField.getText()),this.entidadElegida);                
            }
           limpiar(personasListView);
        });
        
        //Accion de la lista.
        personasListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Persona> ov, Persona old_val, Persona new_val) -> {
            // obtiene la entidad seleccionada
            this.personaSeleccionada = personasListView.getSelectionModel().getSelectedItem();
            // si no apunta a null
            if (this.personaSeleccionada!= null) {
                // cargo los campos
                nombreTextField.setText(this.personaSeleccionada.getNombres());
                apellidoTextField.setText(this.personaSeleccionada.getApellidos());
                documentoTextField.setText(String.valueOf(this.personaSeleccionada.getDocumento()));
            } else {
                nombreTextField.setText("");
                nombreTextField.setDisable(false);
                apellidoTextField.setText("");
                apellidoTextField.setDisable(false);
                documentoTextField.setText("");
                documentoTextField.setDisable(false);
                comboentidades.setValue("Seleccionar Entidad");
                
            }
        });
        
        eliminarButton.setOnAction((ActionEvent eh) -> {
            try {
                this.servicios.eliminarPersona(this.personaSeleccionada.getIdPersona());
                limpiar(personasListView);
            } catch (NumberFormatException e) {
                // Mostramos un alerta por error en convertir un String en int
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("ID incorrecto");
                a.setTitle("Error al eliminar");
                a.show();
            }
        });
        comboentidades.setOnMouseClicked((eh)->{
            comboentidades.getItems().clear();
            comboentidades.getItems().addAll(this.servicios.listarEntidades());
            comboentidades.getSelectionModel().selectFirst();
        });
        
        
        return contenedor;
    }
    private void limpiar(ListView l) {
        // dejo sin elemento seleccionado
        l.getSelectionModel().select(null);
        // vacio la lista
        l.getItems().clear();
        // cargo la lista con objetos de tipo Personaobtenidos por el servicio
        l.getItems().addAll(this.servicios.listarPersonas());
        
        // si hay elementos recuperados del repositorio en la lista
        if (l.getItems().size() > 0) {            
            // selecciono el primer elemento del ListView
            l.getSelectionModel().selectFirst();
        }
    }
    
}
