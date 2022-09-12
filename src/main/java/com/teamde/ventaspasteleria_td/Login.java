package com.teamde.ventaspasteleria_td;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends BorderPane {
    GridPane formulario;
    BorderPane organizacion;
    TextField tUsuario;
    PasswordField password;
    Button iniciar;
    Label lUsuario;
    Label lContra;
    Stage stage;

    public Login(Stage stage) throws IOException {
        this.stage = stage;
        this.organizacion = new BorderPane();
        this.formulario = new GridPane();
        this.iniciar = new Button("Iniciar sesion");
        ImageView imagen = new ImageView("LogoP.png");
        imagen.setFitWidth(450.0);
        imagen.setFitHeight(500.0);
        imagen.setX(0.0);
        this.iniciar.getStyleClass().add("cssBoton");
        this.iniciar.setMaxWidth(171.0);
        this.iniciar.setMinWidth(170.0);
        this.iniciar.setMaxHeight(41.0);
        this.iniciar.setMinHeight(40.0);
        this.tUsuario = new TextField();
        this.tUsuario.getStyleClass().add("text-field");
        this.tUsuario.setPromptText("Ingresa el usuario");
        this.password = new PasswordField();
        this.password.getStyleClass().add("text-field");
        this.password.setPromptText("Ingresa la contraseña");
        this.lUsuario = new Label("Usuario: ");
        this.lUsuario.getStyleClass().add("label");
        this.lContra = new Label("Contraseña: ");
        this.lContra.getStyleClass().add("label");

        ImageView iuser = new ImageView("User.png");
        iuser.setFitWidth(150.0);
        iuser.setFitHeight(150.0);
        this.formulario.setVgap(5.0);
        this.formulario.setHgap(5.0);
        this.formulario.getStyleClass().add("root");
        this.formulario.add(this.lUsuario, 3, 5);
        this.formulario.add(this.tUsuario, 4, 5);
        this.formulario.add(this.lContra, 3, 20);
        this.formulario.add(this.password, 4, 20);
        Label test = new Label();
        test.setGraphic(iuser);
        test.setPrefHeight(175.0);
        this.organizacion.setTop(test);
        test.setTranslateX(175.0);
        test.setTranslateY(10.0);
        this.iniciar.setTranslateX(155.0);
        this.iniciar.setTranslateY(-70.0);
        this.organizacion.setCenter(this.formulario);
        this.organizacion.setBottom(this.iniciar);
        this.iniciar.setOnMouseClicked((evtm) -> {
            this.comprobar();
        });
        this.password.setOnAction((evt) -> {
            this.comprobar();
        });
        this.setLeft(imagen);
        this.setCenter(this.organizacion);
    }

    public void comprobar() {
        String user = this.tUsuario.getText();
        String pass = this.password.getText();
        if (user.equals("admin") && pass.equals("password")) {
            Stage stage1 = new Stage();
            Pane menu = new Menu();
            Scene scene = new Scene(menu, 900.0, 500.0);
            //scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
            stage1.setTitle("Login");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
            this.stage.close();
            System.out.println("Exito");
        }

    }
}