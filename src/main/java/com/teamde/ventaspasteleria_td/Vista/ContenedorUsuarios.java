package com.teamde.ventaspasteleria_td.Vista;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

public class ContenedorUsuarios extends GridPane {
    Label etiCod;
    Label etiNom;
    Label etiTel;
    Label etiContra;
    TextField txtNom;
    TextField txtTel;
    TextField txtContra;
    Button btnElim;
    Button btnAdd;
    ImageView imgEliminar;
    ImageView imgConfirmar;
    public ContenedorUsuarios(){
        inicializarComponentes();
    }

    private void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        etiCod = new Label("Código");

        etiNom = new Label("Nombre: ");
        txtNom = new TextField();

        etiContra = new Label("Contraseña: ");
        txtContra = new TextField();

        etiTel = new Label("Telefono: ");
        txtTel = new TextField();

        imgEliminar = new ImageView("contenedor-de-basura.png");
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnElim = new Button();
        btnElim.setGraphic(imgEliminar);
        btnElim.setTooltip(new Tooltip("Eliminar usuario"));
        btnElim.getStyleClass().add("cssBoton");

        imgConfirmar = new ImageView("correcto.png");
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAdd = new Button();
        btnAdd.setShape(new Circle(1.0));
        btnAdd.setGraphic(imgConfirmar);
        btnAdd.setTooltip(new Tooltip("Agregar usuario"));

        this.add(etiCod, 2,0);

        this.add(etiNom, 1,1);
        this.add(txtNom, 2, 1);

        this.add(etiContra,1,2);
        this.add(txtContra, 2, 2);

        this.add(etiTel, 1, 3);
        this.add(txtTel, 2, 3);

        this.add(btnElim, 1, 4);
        this.add(btnAdd, 3, 4);
    }
}
