package com.teamde.ventaspasteleria_td;

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
        Background fondoNormal = new Background(new BackgroundFill(Color.valueOf("#ccd5ae"), new CornerRadii(0), new Insets(0)));
        Background fondoExpandido = new Background(new BackgroundFill(Color.valueOf("#e9edc9"), new CornerRadii(0), new Insets(0)));
        URL rimagenExpandir = getClass().getResource("lines.png");

        ImageView iconoExpandir = new ImageView(new Image(rimagenExpandir.toExternalForm()));
        //ImageView iconoExpandir = new ImageView(new Image(getClass().getResource("lines.png").toExternalForm()));
        iconoExpandir.setFitWidth(32);
        iconoExpandir.setFitHeight(32);

        ImageView iconoOpc1 = new ImageView(new Image(getClass().getResource("usuario.png").toExternalForm()));
        ImageView iconoOpc2 = new ImageView(new Image(getClass().getResource("usuario.png").toExternalForm()));
        ImageView iconoOpc3 = new ImageView(new Image(getClass().getResource("usuario.png").toExternalForm()));

        String estiloBoton = "-fx-text-fill: white;  -fx-font-size: 11pt";

        //Opciones del boton 1
        Button opcion1 = new Button("Agregar estudiante");
        opcion1.setGraphic(iconoOpc1);
        opcion1.setAlignment(Pos.CENTER_LEFT);
        opcion1.setGraphicTextGap(30);
        opcion1.setBackground(fondoNormal);
        opcion1.setStyle(estiloBoton);
        opcion1.setTooltip(new Tooltip("Agregar estudiante"));

        opcion1.setOnMouseEntered(evt-> {
            opcion1.setBackground(fondoExpandido);
        });
        opcion1.setOnMouseExited(evt-> {
            opcion1.setBackground(fondoNormal);
        });

        Button opcion2 = new Button("Agregar profesor");
        opcion2.setGraphic(iconoOpc2);
        opcion2.setAlignment(Pos.CENTER_LEFT);
        opcion2.setGraphicTextGap(30);
        opcion2.setBackground(fondoNormal);
        opcion2.setStyle(estiloBoton);
        opcion2.setTooltip(new Tooltip("Agregar profesor"));

        opcion2.setOnMouseEntered(evt-> {
            opcion2.setBackground(fondoExpandido);
        });
        opcion2.setOnMouseExited(evt-> {
            opcion2.setBackground(fondoNormal);
        });

        Button opcion3 = new Button("Agendar curso");
        opcion3.setGraphic(iconoOpc3);
        opcion3.setAlignment(Pos.CENTER_LEFT);
        opcion3.setGraphicTextGap(30);
        opcion3.setBackground(fondoNormal);
        opcion3.setStyle(estiloBoton);
        opcion3.setTooltip(new Tooltip("Agregar estudiante"));

        opcion3.setOnMouseEntered(evt-> {
            opcion3.setBackground(fondoExpandido);
        });
        opcion3.setOnMouseExited(evt-> {
            opcion3.setBackground(fondoNormal);
        });

        //Boton de el menu hamburguesa
        Button botonH = new Button("");
        botonH.setGraphic(iconoExpandir);
        botonH.setBackground(fondoNormal);
        botonH.setStyle(estiloBoton);
        botonH.setOnAction(evt-> {
            if (!compactado) {
                setMaxWidth(52);
                opcion1.setMaxWidth(52);
                opcion1.setMinWidth(52);
                opcion2.setMaxWidth(52);
                opcion2.setMinWidth(52);
                opcion3.setMaxWidth(52);
                opcion3.setMinWidth(52);
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                tiempo.play();
                setMinWidth(52);

            } else {
                //setMaxWidth(160);
                //
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 160, Interpolator.EASE_BOTH)));
                tiempo.play();
                tiempo.setOnFinished(evt2 -> {
                    setMaxWidth(160);
                    opcion1.setMaxWidth(150);
                    opcion1.setMinWidth(150);
                    opcion2.setMaxWidth(150);
                    opcion2.setMinWidth(150);
                    opcion3.setMaxWidth(150);
                    opcion3.setMinWidth(150);
                });
            }
            compactado = !compactado;
        });
        setPadding(new Insets(0));

        opcion1.setMinWidth(150);
        opcion2.setMinWidth(150);
        opcion3.setMinWidth(150);
        setMinWidth(160);
        setOrientation(Orientation.VERTICAL);
        setBackground(fondoNormal);
        getItems().addAll(botonH, new Label(""), opcion1, opcion2, opcion3);
    }
}
