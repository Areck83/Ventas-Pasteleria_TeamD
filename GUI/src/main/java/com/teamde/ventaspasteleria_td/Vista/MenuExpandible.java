package com.teamde.ventaspasteleria_td.Vista;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;

public class MenuExpandible extends ToolBar {
    //Para acciones del boton principal
    private boolean compactado = false;

    //Constructor
    public MenuExpandible(){
        Background fondoNormal = new Background(new BackgroundFill(Color.valueOf("36241C"), new CornerRadii(0), new Insets(0)));
        Background fondoExpandido = new Background(new BackgroundFill(Color.valueOf("422C22"), new CornerRadii(0), new Insets(0)));
        //URL rimagenExpandir = getClass().getResource("menu.png");
        //URL rimagenExpandido = getClass().getResource("menu-close.png");

        ImageView iconoExpandir = new ImageView("menu.png");
        ImageView iconoExpandido = new ImageView("menu-close.png");
        //ImageView iconoExpandir = new ImageView(new Image(getClass().getResource("lines.png").toExternalForm()));
        iconoExpandir.setFitWidth(32);
        iconoExpandir.setFitHeight(32);
        iconoExpandido.setFitWidth(32);
        iconoExpandido.setFitHeight(32);

        ImageView iconoOpcionBloqueo = new ImageView("lock.png");
        ImageView iconoOpcionInfo = new ImageView("information.png");
        ImageView iconoOpcionError = new ImageView("error-base.png");
        ImageView iconoOpcionSalir = new ImageView("exit.png");

        String estiloBoton = "-fx-text-fill: white;  -fx-font-size: 12pt";

        //Opciones del boton bloqueo
        Button opcionBloqueo = new Button("BLOQ SYS");
        opcionBloqueo.setGraphic(iconoOpcionBloqueo);
        opcionBloqueo.setAlignment(Pos.CENTER_LEFT);
        opcionBloqueo.setGraphicTextGap(30);
        opcionBloqueo.setBackground(fondoNormal);
        opcionBloqueo.setStyle(estiloBoton);
        opcionBloqueo.setTooltip(new Tooltip("Evitar acceso no autorizado en mi ausencia"));

        opcionBloqueo.setOnMouseEntered(evt-> {
            opcionBloqueo.setBackground(fondoExpandido);
        });
        opcionBloqueo.setOnMouseExited(evt-> {
            opcionBloqueo.setBackground(fondoNormal);
        });

        Button opcionInformacion = new Button("INFO");
        opcionInformacion.setGraphic(iconoOpcionInfo);
        opcionInformacion.setAlignment(Pos.CENTER_LEFT);
        opcionInformacion.setGraphicTextGap(30);
        opcionInformacion.setBackground(fondoNormal);
        opcionInformacion.setStyle(estiloBoton);
        opcionInformacion.setTooltip(new Tooltip("Ver manual de usuario"));

        opcionInformacion.setOnMouseEntered(evt-> {
            opcionInformacion.setBackground(fondoExpandido);
        });
        opcionInformacion.setOnMouseExited(evt-> {
            opcionInformacion.setBackground(fondoNormal);
        });

        Button opcionError = new Button("ERRORES?");
        opcionError.setGraphic(iconoOpcionError);
        opcionError.setAlignment(Pos.CENTER_LEFT);
        opcionError.setGraphicTextGap(30);
        opcionError.setBackground(fondoNormal);
        opcionError.setStyle(estiloBoton);
        opcionError.setTooltip(new Tooltip("Informar de problemas"));

        opcionError.setOnMouseEntered(evt-> {
            opcionError.setBackground(fondoExpandido);
        });
        opcionError.setOnMouseExited(evt-> {
            opcionError.setBackground(fondoNormal);
        });

        Button opcionSalir = new Button("SALIR");
        opcionSalir.setGraphic(iconoOpcionSalir);
        opcionSalir.setAlignment(Pos.CENTER_LEFT);
        opcionSalir.setGraphicTextGap(30);
        opcionSalir.setBackground(fondoNormal);
        opcionSalir.setStyle(estiloBoton);
        opcionSalir.setTooltip(new Tooltip("Cerrar este sistema (Sirve para reinicio)"));

        opcionSalir.setOnMouseEntered(evt-> {
            opcionInformacion.setBackground(fondoExpandido);
        });
        opcionSalir.setOnMouseExited(evt-> {
            opcionInformacion.setBackground(fondoNormal);
        });

        //Boton de el menu hamburguesa
        Button botonH = new Button("");
        botonH.setGraphic(iconoExpandir);
        botonH.setBackground(fondoNormal);
        botonH.setStyle(estiloBoton);
        botonH.setOnAction(evt-> {
            if (!compactado) {
                botonH.setGraphic(iconoExpandir);
                setMaxWidth(52);
                botonH.setMaxWidth(40);
                botonH.setMinWidth(40);
                opcionBloqueo.setMaxWidth(52);
                opcionBloqueo.setMinWidth(52);
                opcionInformacion.setMaxWidth(52);
                opcionInformacion.setMinWidth(52);
                opcionError.setMaxWidth(52);
                opcionError.setMinWidth(52);
                opcionSalir.setMaxWidth(52);
                opcionSalir.setMinWidth(52);
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                tiempo.play();
                setMinWidth(52);

            } else {
                botonH.setGraphic(iconoExpandido);
                botonH.setMaxWidth(40);
                botonH.setMinWidth(40);
                setMaxWidth(52);
                //setMaxWidth(160);
                //
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 160, Interpolator.EASE_BOTH)));
                tiempo.play();
                tiempo.setOnFinished(evt2 -> {
                    setMaxWidth(160);
                    opcionBloqueo.setMaxWidth(150);
                    opcionBloqueo.setMinWidth(150);
                    opcionInformacion.setMaxWidth(150);
                    opcionInformacion.setMinWidth(150);
                    opcionError.setMaxWidth(150);
                    opcionError.setMinWidth(150);
                    opcionSalir.setMaxWidth(150);
                    opcionSalir.setMinWidth(150);
                });
            }
            compactado = !compactado;
        });
        setPadding(new Insets(0));

        opcionBloqueo.setMinWidth(150);
        opcionInformacion.setMinWidth(150);
        opcionError.setMinWidth(150);
        opcionSalir.setMinWidth(150);
        setMinWidth(160);
        setOrientation(Orientation.VERTICAL);
        setBackground(fondoNormal);
        getItems().addAll(botonH, new Label(""), opcionBloqueo, opcionInformacion, opcionError, opcionSalir);
    }
}
