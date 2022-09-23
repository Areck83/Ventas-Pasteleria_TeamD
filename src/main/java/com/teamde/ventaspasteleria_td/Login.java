package com.teamde.ventaspasteleria_td;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends BorderPane {
    GridPane gridForm;
    BorderPane borderOrganizacion;
    TextField txtUsuario;
    PasswordField txtPass;
    Button btnIniciar;
    Label lblUsuario;
    Label lblPass;
    Stage stage;

    public Login(Stage stage) throws IOException {
        //Inicialización de componentes
        this.stage = stage;
        this.borderOrganizacion = new BorderPane();
        this.gridForm = new GridPane();
        this.btnIniciar = new Button("Iniciar sesion");

        ImageView imagen = new ImageView("LogoP.png");
        imagen.setFitWidth(450.0);
        imagen.setFitHeight(500.0);
        imagen.setX(0.0);
        this.btnIniciar.getStyleClass().add("cssBoton"); //Despues debemos de modificar los estilos

        //Boton para iniciar sesion
        this.btnIniciar.setMaxWidth(171.0);
        this.btnIniciar.setMinWidth(170.0);
        this.btnIniciar.setMaxHeight(41.0);
        this.btnIniciar.setMinHeight(40.0);

        //Ingreso de datos del usuario
        this.txtUsuario = new TextField();
        this.txtUsuario.getStyleClass().add("text-field");
        this.txtUsuario.setPromptText("Ingresa el usuario");

        this.txtPass = new PasswordField();
        this.txtPass.getStyleClass().add("text-field");
        this.txtPass.setPromptText("Ingresa la contraseña");

        //Titulo de los campos en el programa
        this.lblUsuario = new Label("Usuario: ");
        this.lblUsuario.getStyleClass().add("label");

        this.lblPass = new Label("Contraseña: ");
        this.lblPass.getStyleClass().add("label");

        ImageView iuser = new ImageView("usuario_login.png");
        iuser.setFitWidth(150.0);
        iuser.setFitHeight(150.0);

        this.gridForm.setVgap(5.0);
        this.gridForm.setHgap(5.0);
        this.gridForm.getStyleClass().add("root");
        this.gridForm.add(this.lblUsuario, 3, 5);
        this.gridForm.add(this.txtUsuario, 4, 5);
        this.gridForm.add(this.lblPass, 3, 20);
        this.gridForm.add(this.txtPass, 4, 20);

        Label test = new Label();
        test.setGraphic(iuser);
        test.setPrefHeight(175.0);
        this.borderOrganizacion.setTop(test);
        test.setTranslateX(175.0);
        test.setTranslateY(10.0);

        this.btnIniciar.setTranslateX(155.0);
        this.btnIniciar.setTranslateY(-70.0);

        this.borderOrganizacion.setCenter(this.gridForm);
        this.borderOrganizacion.setBottom(this.btnIniciar);
        this.btnIniciar.setOnMouseClicked((evtm) -> {
            try {
                this.comprobar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        this.txtPass.setOnAction((evt) -> {
            try {
                this.comprobar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        this.setLeft(imagen);
        this.setCenter(this.borderOrganizacion);
    }

    public void comprobar() throws InterruptedException {
        //Esta configuración es temporal mientras que se hace conexión a la BD.
        String user = this.txtUsuario.getText();
        String pass = this.txtPass.getText();
        if (user.equals("admin") && pass.equals("txtPass")) {
            Stage stage1 = new Stage();
            Pane menu = new ContenedorGeneral();
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            Scene scene = new Scene(menu, screenBounds.getWidth(), screenBounds.getHeight());
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