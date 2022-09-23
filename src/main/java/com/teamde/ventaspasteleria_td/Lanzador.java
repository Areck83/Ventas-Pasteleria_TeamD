package com.teamde.ventaspasteleria_td;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//Este programa debe de redireccionar correctamente al panel correspondiente al tipo de usuario
public class Lanzador extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = new Login(stage);
        Scene scene = new Scene(root, 900, 500);
        stage.setTitle("Prueba segunda iter");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}