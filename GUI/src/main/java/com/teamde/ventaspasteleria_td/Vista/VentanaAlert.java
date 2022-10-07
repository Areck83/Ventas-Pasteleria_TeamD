package com.teamde.ventaspasteleria_td.Vista;

import javafx.scene.control.Alert;

public class VentanaAlert{
    VentanaAlert(String mensaje, String titulo){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
