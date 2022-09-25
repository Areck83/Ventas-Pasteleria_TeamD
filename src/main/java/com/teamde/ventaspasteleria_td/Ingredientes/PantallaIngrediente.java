package com.teamde.ventaspasteleria_td.Ingredientes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class PantallaIngrediente extends BorderPane {
    private Label lTitulo;
    private Button bAgregarProducto;
    private HBox barra;
   private TableView<Ingrediente> tablaProducto;
    //private ObservableList<Pastel> pasteles;

    public PantallaIngrediente() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.lTitulo = new Label("Ingredientes");
        this.lTitulo.getStyleClass().add("label-titulo");
        this.lTitulo.setPrefHeight(70.0);
        //Pasteles listaHelper = new Pasteles();
        //listaHelper.crearLista();
        List<Ingrediente> listaIngredienteHelper = new ArrayList<>();
        TablaIngrediente tablaIngrediente1 = new TablaIngrediente(listaIngredienteHelper);
        this.tablaProducto = tablaIngrediente1.getTablaProductos();

        //TableView tablaPasteles1 = this.tablaPasteles.getTablaPasteles();
        //TableView tablaPasteles1 = new TableView();
        //tablaPasteles1.setPrefWidth(1000.0);
        /*tablaPasteles1.setOnMouseClicked((evtm) -> {
            Pastel pastelSeleccionado = (Pastel)tablaPasteles1.getSelectionModel().getSelectedItem();
            if (evtm.getClickCount() == 2) {
                int seleccion = tablaPasteles1.getSelectionModel().getSelectedIndex();
                this.editarPastel(pastelSeleccionado, seleccion);
            }

        });*/

        this.bAgregarProducto = new Button("Agregar Ingrediente");
        this.bAgregarProducto.getStyleClass().add("cssBoton");
        this.bAgregarProducto.setOnAction((evtm) -> {
           // this.crearPastel();
        });
        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(lTitulo, bAgregarProducto);
        this.setTop(barra);
        this.setLeft(tablaProducto);
    }
    //private void editarPastel(Usuario usuario, int seleccion) {
    /*private void editarUsuario() {
        Stage stage = new Stage();
        EditarUsuario = new EditarUsuario(stage, pastel, this.tablaUsuarios);
        Scene scene = new Scene(menu, 700.0, 600.0);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Editar pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearPastel() {
        Stage stage = new Stage();
        AgregarPastel menu = new AgregarPastel(stage, this.tablaPasteles);
        Scene scene = new Scene(menu, 700.0, 600.0);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }*/
}