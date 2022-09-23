package com.teamde.ventaspasteleria_td;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;

public class LanzadorSecciones extends BorderPane {
    Background fondoDashboard = new Background(new BackgroundFill(Color.valueOf("E6D5CE"), new CornerRadii(0), new Insets(0)));
    TilePane contenedorIconos = null;
    Font tipoLetraTitulo;
    Font tipoLetraDescripcion;

    Label etiProveedores;
    Label descProveedores;
    Label etiUsuarios;
    Label descUsuarios;
    Label etiIngrediente;
    Label descIngrediente;
    Label etiEstadisticas;
    Label descEstadisticas;
    Label etiBaseDatos;
    Label descBaseDatos;

    VBox contProveedores;
    VBox contUsuarios;
    VBox contIngredientes;
    VBox contEstadisticas;
    VBox contBD;

    ImageView imvProveedores;
    ImageView imvUsuarios;
    ImageView imvIngredientes;
    ImageView imvEstadisticas;
    ImageView imvBD;

    Button btnProveedores;
    Button btnUsuarios;
    Button btnIngredientes;
    Button btnEstadisticas;
    Button btnBD;

    TabPane tabPane;
    Tab tab;

    public LanzadorSecciones(){
        inicializarComponentes(tabPane, tab);
    }

    public LanzadorSecciones(TabPane tabPane, Tab tab){
        this.tabPane = tabPane;
        this.tab = tab;
        inicializarComponentes(tabPane, tab);
    }

    public void inicializarComponentes(TabPane tabPane, Tab tab){
        //Muestra del grid
        contenedorIconos = new TilePane();
        contenedorIconos.setVgap(12);
        contenedorIconos.setHgap(12);
        contenedorIconos.setPadding(new Insets(10));
        contenedorIconos.setPrefColumns(7);

        tipoLetraTitulo = Font.font("Helvetica", FontWeight.BOLD, 16);
        tipoLetraDescripcion = Font.font("Arial", 12);

        //Imagenes
        imvProveedores = new ImageView(new Image(getClass().getResource("proveedor.png").toExternalForm()));
        imvProveedores.setFitWidth(200);
        imvProveedores.setFitHeight(200);

        imvUsuarios = new ImageView(new Image(getClass().getResource("users.png").toExternalForm()));
        imvUsuarios.setFitWidth(200);
        imvUsuarios.setFitHeight(200);

        imvIngredientes = new ImageView(new Image(getClass().getResource("ingredientes.png").toExternalForm()));
        imvIngredientes.setFitWidth(200);
        imvIngredientes.setFitHeight(200);

        imvEstadisticas = new ImageView(new Image(getClass().getResource("estadisticas.png").toExternalForm()));
        imvEstadisticas.setFitWidth(200);
        imvEstadisticas.setFitHeight(200);

        imvBD = new ImageView(new Image(getClass().getResource("backup.png").toExternalForm()));
        imvBD.setFitWidth(200);
        imvBD.setFitHeight(200);

        //Etiquetas
        etiProveedores = new Label("Proveedores");
        descProveedores = new Label("Listado de proveedores");

        etiUsuarios=new Label("Usuarios");
        descUsuarios=new Label("Administracion de personal");

        etiIngrediente=new Label("Ingredientes");
        descIngrediente=new Label ("Inventario de recursos");

        etiEstadisticas=new Label("Estadisticas");
        descEstadisticas=new Label("Visualizar rendimiento y exportar");

        etiBaseDatos=new Label("Base de datos");
        descBaseDatos=new Label("Respaldar o restaurar");

        //Botones
        //Cada onAction debe de mandar al nuevo contenedor donde se encuentra el panel.
        btnProveedores = new Button("");
        btnProveedores.setGraphic(imvProveedores);
        btnProveedores.setMaxWidth(200);
        btnProveedores.setMaxWidth(200);
        btnProveedores.setOnAction(e ->{
            ContenedorProveedores panelProv = new ContenedorProveedores(tabPane, tab);
            tab.setContent(panelProv);
            tab.setText("Proveedores");
        });

        btnUsuarios = new Button("");
        btnUsuarios.setGraphic(imvUsuarios);
        btnUsuarios.setMaxWidth(200);
        btnUsuarios.setMinWidth(200);
        btnUsuarios.setOnAction(e ->{
            //ContenedorAdminUsuarios adminUsu = new ContenedorAdminUsuarios();
            //tab.setContent(adminUsu);
            //tab.setText("Usuarios");
        });

        btnIngredientes = new Button("");
        btnIngredientes.setGraphic(imvIngredientes);
        btnIngredientes.setMaxWidth(200);
        btnIngredientes.setMinWidth(200);
        btnIngredientes.setOnAction(e->{
            //ContenedorIngredientes panelIngred = new ContenedorIngredientes();
            //tab.setContent(panelIngred);
            //tab.setText("Ingredientes");
        });

        btnEstadisticas = new Button("");
        btnEstadisticas.setGraphic(imvEstadisticas);
        btnEstadisticas.setMaxWidth(200);
        btnEstadisticas.setMinWidth(200);
        btnEstadisticas.setOnAction(e->{
            ContenedorEstadisticas estadisticas = new ContenedorEstadisticas();
            tab.setContent(estadisticas);
            tab.setText("Estadisticas");
        });

        btnBD = new Button("");
        btnBD.setGraphic(imvBD);
        btnBD.setMinWidth(200);
        btnBD.setMaxWidth(200);
        btnBD.setOnAction(e->{
            //ContenedorBackup backup = new ContenedorBackup();
            //tab.setContent(backup);
            //tab.setText("Backup");
        });

        contProveedores = new VBox();
        contProveedores.setAlignment(Pos.TOP_CENTER);
        contProveedores.getChildren().addAll(btnProveedores, etiProveedores, descProveedores);

        contUsuarios = new VBox();
        contUsuarios.setAlignment(Pos.TOP_CENTER);
        contUsuarios.getChildren().addAll(btnUsuarios, etiUsuarios, descUsuarios);

        contIngredientes = new VBox();
        contIngredientes.setAlignment(Pos.TOP_CENTER);
        contIngredientes.getChildren().addAll(btnIngredientes, etiIngrediente, descIngrediente);

        contEstadisticas = new VBox();
        contEstadisticas.setAlignment(Pos.TOP_CENTER);
        contEstadisticas.getChildren().addAll(btnEstadisticas, etiEstadisticas, descEstadisticas);

        contBD = new VBox();
        contBD.setAlignment(Pos.TOP_CENTER);
        contBD.getChildren().addAll(btnBD, etiBaseDatos, descBaseDatos);

        contenedorIconos.getChildren().addAll(contProveedores, contUsuarios, contIngredientes,contEstadisticas, contBD);
        setBackground(fondoDashboard);
        setCenter(contenedorIconos);
    }
}
