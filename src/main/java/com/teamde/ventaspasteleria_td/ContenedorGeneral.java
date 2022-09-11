package com.teamde.ventaspasteleria_td;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

//Panel completo sin segmentar
public class ContenedorGeneral extends BorderPane {
    MenuExpandible menuExpandible = new MenuExpandible();
    TabPane tabPane = new TabPane();

    public ContenedorGeneral(){
        Tab tab = new Tab("Apps");
        StackPane layout = new StackPane();
        LanzadorSecciones aplicaciones = new LanzadorSecciones(tabPane, tab);
        layout.getChildren().add(aplicaciones);
        tab.setContent(layout);
        //tab.setClosable(false);
        tabPane.getTabs().add(tab);

        Tab newTab = new Tab("+");
        tabPane.getTabs().add(newTab);

        newTab.setOnSelectionChanged(e->{
            Tab nuevoTab = new Tab("Apps"+tabPane.getTabs().size());
            StackPane nuevoLayout = new StackPane();
            LanzadorSecciones nuevasAplicaciones = new LanzadorSecciones(tabPane, nuevoTab);
            nuevoTab.setContent(nuevasAplicaciones);
            tabPane.getTabs().add(tabPane.getTabs().size()-1, nuevoTab);
            tabPane.getSelectionModel().select(tabPane.getTabs().size()-2);
        });
        setLeft(menuExpandible);
        setCenter(tabPane);
    }

    private void manejoSalir(){
        Alert alertaSalir = new Alert(Alert.AlertType.CONFIRMATION);
        alertaSalir.setTitle("Advertencia");
        alertaSalir.setContentText("¿Esta seguro que quiere salir?");
        ButtonType respuesta = alertaSalir.showAndWait().orElse(ButtonType.OK);
        if (ButtonType.OK.equals(respuesta))
            System.exit(0);
    }
}
