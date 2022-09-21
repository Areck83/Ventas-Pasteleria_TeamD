package com.teamde.ventaspasteleria_td.Productos;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class PantallaAgregarProducto extends BorderPane {
    private Label lTitulo;
    private Label label;
    private Button bAgregarUsuario;
    private HBox barra;
   private TableView tablaUsuarios;
    //private ObservableList<Pastel> pasteles;

    public PantallaAgregarProducto() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.lTitulo = new Label("Usuarios");
        this.lTitulo.getStyleClass().add("label-titulo");
        this.lTitulo.setPrefHeight(70.0);
        //Pasteles listaHelper = new Pasteles();
        //listaHelper.crearLista();
        List<Producto> listaUsuarioHelper = new ArrayList<>();
        TablaProducto tablaUsuarioHelper = new TablaProducto(listaUsuarioHelper);
        this.tablaUsuarios = tablaUsuarioHelper.getTablaUsuario();

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
        this.label = new Label();
        this.bAgregarUsuario = new Button("Agregar Usuario");
        this.bAgregarUsuario.getStyleClass().add("cssBoton");
        this.bAgregarUsuario.setOnAction((evtm) -> {
           // this.crearPastel();
        });
        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(lTitulo, bAgregarUsuario);
        this.setTop(barra);
        this.setLeft(tablaUsuarios);
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