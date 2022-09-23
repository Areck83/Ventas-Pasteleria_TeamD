package com.teamde.ventaspasteleria_td;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class ContenedorProveedores extends GridPane{
    TabPane tabPane;
    Tab tab;
    Button btnVolver;

    Label etiCod;
    Label etiNom;
    Label etiTel;
    Label etiCorr;
    TextField txtNom;
    TextField txtTel;
    TextField txtCorr;
    Button btnElim;
    Button btnAdd;
    ImageView imgEliminar;
    ImageView imgConfirmar;

    public ContenedorProveedores(TabPane tabPane, Tab tab){
        this.tabPane = tabPane;
        this.tab = tab;

        inicializarComponentes();

    }
    private void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        etiCod = new Label("Código: ");

        etiNom = new Label("Nombre: ");
        txtNom = new TextField();

        etiCorr = new Label("Correo Electrónico: ");
        txtCorr = new TextField();

        etiTel = new Label("Telefono: ");
        txtTel = new TextField();

        imgEliminar = new ImageView(new Image(getClass().getResource("contenedor-de-basura.png").toExternalForm()));
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnElim = new Button();
        btnElim.setGraphic(imgEliminar);
        btnElim.setTooltip(new Tooltip("Eliminar proveedor"));

        imgConfirmar = new ImageView(new Image(getClass().getResource("correcto.png").toExternalForm()));
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAdd = new Button();
        btnAdd.setShape(new Circle(1.0));
        btnAdd.setGraphic(imgConfirmar);
        btnAdd.setTooltip(new Tooltip("Agregar proveedor"));

        //btnVolver.setOnAction(e->{
          //  LanzadorSecciones pantallaAnterior = new LanzadorSecciones(tabPane, tab);
           // tab.setContent(pantallaAnterior);
        //});

        this.add(etiCod, 2,0);

        this.add(etiNom, 1,1);
        this.add(txtNom, 2, 1);

        this.add(etiCorr,1,2);
        this.add(txtCorr, 2, 2);

        this.add(etiTel, 1, 3);
        this.add(txtTel, 2, 3);

        this.add(btnElim, 1, 4);
        this.add(btnAdd, 3, 4);

        //this.add(btnVolver, 6, 6);

    }
}
