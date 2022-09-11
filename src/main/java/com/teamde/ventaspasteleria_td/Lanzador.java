package com.teamde.ventaspasteleria_td;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Este programa debe de redireccionar correctamente al panel correspondiente al tipo de usuario
//Para cuestiones de prueba aun no contiene usuarios asignados
public class Lanzador extends Application {
    @Override
    public void start(Stage stage){
        Parent root = new ContenedorGeneral();
        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("Prueba primera iteracion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}