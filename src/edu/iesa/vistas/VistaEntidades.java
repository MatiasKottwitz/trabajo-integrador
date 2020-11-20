/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iesa.vistas;

import edu.iesa.modelo.Entidad;
import edu.iesa.modelo.Inscripcion;
import edu.iesa.modelo.Persona;
import edu.iesa.servicio.Servicio;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import static org.eclipse.persistence.expressions.ExpressionOperator.log;

/**
 *
 * @author user
 */
public class VistaEntidades implements Vista{
    private Servicio servicios;
    private Entidad entidadSeleccionada;
    private boolean tipo;
    
    
    public VistaEntidades(Servicio servicio) {
        this.servicios = servicio;
    }
    

    @Override
    public Parent obtenerVista() {
        Label tituloLabel = new Label("Administracion de Entidades");
        tituloLabel.setFont(Font.font("Arial",18));
        Label cuitLabel=new Label ("Cuit: ");
        TextField cuitTextField = new TextField();
        Label nombreLabel = new Label("Nombre:  ");
        TextField nombreTextField = new TextField();
        Label tipoLabel = new Label("Tipo:  ");
        ObservableList tiposDeEntidades= FXCollections.observableArrayList("Publica","Privada");
        ComboBox comboTipo = new ComboBox();
        comboTipo.setItems(tiposDeEntidades);
        comboTipo.getSelectionModel().select(0);
        Separator separador = new Separator(Orientation.HORIZONTAL);
        Label personaLabel=new Label ("Persona: ");
        ListView<Persona> personaListView = new ListView();
        personaListView.setPrefHeight(100);
        Separator separador2 = new Separator(Orientation.HORIZONTAL);
        Label inscripcionLabel = new Label("Inscripcion: ");
        ListView<Inscripcion> InscripcionListView = new ListView();
        InscripcionListView.setPrefHeight(100);
        Button nuevoButton = new Button("Nuevo");
        Button guardarButton = new Button("Guardar");
        Button eliminarButton = new Button("Eliminar");
        Label entiadesLabel = new Label("Entidades: ");
        ListView<Entidad> entidadesListView = new ListView<>();
        entidadesListView.setPrefHeight(100);
        
        //Dibujo de los elementos de la interfaz.
        GridPane contenedorDatos = new GridPane();
        contenedorDatos.setHgap(10);
        contenedorDatos.setVgap(10);
        contenedorDatos.add(tituloLabel, 2, 0);
        contenedorDatos.add(cuitLabel, 1, 1, 1, 1);
        contenedorDatos.add(cuitTextField, 2, 1, 1, 1);
        contenedorDatos.add(nombreLabel, 1, 2, 1, 1);
        contenedorDatos.add(nombreTextField, 2, 2, 1, 1);
        contenedorDatos.add(tipoLabel, 1, 3);
        contenedorDatos.add(comboTipo, 2, 3);
        GridPane.setMargin(nuevoButton, new Insets(0,0,0,-238));
        contenedorDatos.add(nuevoButton, 3, 4);
        GridPane.setMargin(guardarButton, new Insets(0,0,0,-175));
        contenedorDatos.add(guardarButton,4,4);
        GridPane.setMargin(eliminarButton, new Insets(0,0,0,-100));
        contenedorDatos.add(eliminarButton, 5, 4);
        contenedorDatos.add(separador, 1, 5,10,1);
        contenedorDatos.add(personaLabel, 1, 6);
        contenedorDatos.add(personaListView, 1, 7,10,6);
        contenedorDatos.add(separador2, 1, 13,10,1);
        contenedorDatos.add(inscripcionLabel, 1, 14);
        contenedorDatos.add(InscripcionListView, 1, 15,10,6);
        contenedorDatos.setPadding(new Insets(16));
        contenedorDatos.add(entiadesLabel, 1, 21);
        contenedorDatos.add(entidadesListView, 1, 22,10,6);
        HBox contenedor = new HBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(contenedorDatos);
        
        //Acciones de los botones
        nuevoButton.setOnAction((ActionEvent eh) -> {
            // dejo sin seleccionar items de la lista
            entidadesListView.getSelectionModel().select(null);
        });
        
        guardarButton.setOnAction((var eh) -> {
            Long entrada;
            try {
                entrada = Long.parseLong(cuitTextField.getText());
            } catch (NumberFormatException e) {
                // Mostramos un alerta por error en convertir un String en int
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("EL CUIT INGRESADO DEBE SER UN NUMERO");
                a.setTitle("Formato Incorrecto!");
                a.show();
            }
            String tipoelegido = (String) comboTipo.getValue();
            if("Publica".equals(tipoelegido)){
                this.tipo=true;
            }else{
                this.tipo=false;
            }
            // modificar
            if (entidadesListView.getSelectionModel().getSelectedItem() != null) {
                this.servicios.editarEntidad(this.entidadSeleccionada, Integer.parseInt(cuitTextField.getText()), nombreTextField.getText(),tipo);                
            } else {
                // agregar
                this.servicios.agregarEntidad(Integer.parseInt(cuitTextField.getText()), nombreTextField.getText(),tipo);                
            }
            
            System.out.println(tipoelegido);
                
            limpiar(entidadesListView);
        });
        
        
        //controla la entidad seleccionada en el listView
        entidadesListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Entidad> ov, Entidad old_val, Entidad new_val) -> {
            // obtiene la entidad seleccionada
            this.entidadSeleccionada = entidadesListView.getSelectionModel().getSelectedItem();
            // si no apunta a null
            if (this.entidadSeleccionada != null) {
                // cargo los campos
                cuitTextField.setText(String.valueOf(this.entidadSeleccionada.getCuit()));
                cuitTextField.setDisable(true);
                nombreTextField.setText(this.entidadSeleccionada.getNombre());
                nombreTextField.setDisable(false);
                comboTipo.setDisable(false);
                if(this.entidadSeleccionada.isTipo()==true){
                    comboTipo.getSelectionModel().select(0);
                }else{
                    comboTipo.getSelectionModel().select(1);
                }                
            } else {
                cuitTextField.setText("");
                cuitTextField.setDisable(false);
                nombreTextField.setText("");
                nombreTextField.setDisable(false);
                comboTipo.setDisable(false);
            }
        });
        
        eliminarButton.setOnAction((ActionEvent eh) -> {
            try {
                this.servicios.eliminarEntidad(Long.parseLong(cuitTextField.getText()));
                limpiar(entidadesListView);
            } catch (NumberFormatException e) {
                // Mostramos un alerta por error en convertir un String en int
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("ID incorrecto");
                a.setTitle("Error al eliminar");
                a.show();
            }
        });
        
        return contenedor;
    }
    
    private void limpiar(ListView l) {
        // dejo sin elemento seleccionado
        l.getSelectionModel().select(null);
        // vacio la lista
        l.getItems().clear();
        // cargo la lista con objetos de tipo Aula obtenidos por el servicio
        l.getItems().addAll(this.servicios.listarEntidades());
        
        // si hay elementos recuperados del repositorio en la lista
        if (l.getItems().size() > 0) {            
            // selecciono el primer elemento del ListView
            l.getSelectionModel().selectFirst();
        }
    }
}

