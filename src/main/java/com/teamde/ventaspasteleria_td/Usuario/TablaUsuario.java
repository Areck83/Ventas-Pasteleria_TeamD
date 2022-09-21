package com.teamde.ventaspasteleria_td.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.List;

public class TablaUsuario {
    private TableView<Usuario> tablaUsuarios;
        private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        //private Pastel pastel;

        // Agregar a los usuarios desde la base de datos con ayuda del helper

        public TablaUsuario(List<Usuario> listaUsuario) {
            this.usuarios.addAll(listaUsuario);
            this.tablaUsuarios = new TableView<>();
            this.tablaUsuarios.getStyleClass().add("table-cell");
            this.tablaUsuarios.setPrefWidth(700.0);
            this.crearTabla();
        }
        //crear la tabla con los atributos del usuario

        public void crearTabla() {
            //this.tablaPasteles.setItems(this.pasteles);
            //Cambiar de  <String, String > a <Usuario, String> segun sea el caso
            //Corregir las tablas en caso de ser necesario
            TableColumn<Usuario, String> colId = new TableColumn<Usuario, String>("ID");
            TableColumn<Usuario, String> colNombre = new TableColumn<Usuario, String>("Nombre");
            TableColumn<Usuario, String> colContr = new TableColumn<Usuario, String>("Contrasenia");
            TableColumn<Usuario, String> colCorreo = new TableColumn<Usuario, String>("Correo");
            TableColumn<Usuario, String> colTelefono = new TableColumn<Usuario, String>("Telefono");
            TableColumn<Usuario, Void> colEliminar = new TableColumn<Usuario, Void>("Eliminar");

            colEliminar.setPrefWidth(130.0);
            colNombre.setPrefWidth(120.0);
            colContr.setPrefWidth(120.0);
            colCorreo.setPrefWidth(120.0);
            colTelefono .setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
            colContr.setCellValueFactory(new PropertyValueFactory<Usuario, String>("password"));
            colCorreo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo"));
            colTelefono.setCellValueFactory(new PropertyValueFactory<Usuario, String>("telefono"));

            //crear y accionar el boton de aliminar
            Callback<TableColumn<Usuario, Void>, TableCell<Usuario, Void>> cellFactory1 = new Callback<TableColumn<Usuario, Void>, TableCell<Usuario, Void>>() {
                public TableCell<Usuario, Void> call(TableColumn<Usuario, Void> param) {
                    TableCell<Usuario, Void> cell1 = new TableCell<Usuario, Void>() {
                        final Button boton = new Button("Eliminar");

                        {
                            this.boton.setOnAction((evt) -> {
                                this.getTableView().getItems().remove(this.getIndex());
                            });
                            this.boton.setPrefWidth(80.0);
                            this.boton.setPrefHeight(10.0);
                        }

                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                this.setGraphic((Node)null);
                            } else {
                                this.setGraphic(this.boton);
                            }

                        }
                    };
                    return cell1;
                }
            };
            //Crea una imagen y la aniade a la tabla (puede ser util despues)
            /*Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>> cellFactory2 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
                public TableCell<Pastel, Void> call(TableColumn<Pastel, Void> param) {
                    TableCell<Pastel, Void> cell2 = new TableCell<Pastel, Void>() {
                        final Rectangle color = new Rectangle();

                        {
                            this.color.setWidth(80.0);
                            this.color.setHeight(10.0);
                        }

                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                this.setGraphic((Node)null);
                            } else {
                                String Scolor = ((Pastel)this.getTableView().getItems().get(this.getIndex())).getColor();
                                this.color.setFill(Color.web(Scolor));
                                this.color.setFill(Color.web(Scolor));
                                this.setGraphic(this.color);
                            }

                        }
                    };
                    return cell2;
                }
            };*/

            //colEliminar.setCellFactory(cellFactory1);
            //Agrega las columnas a la tabla
            this.tablaUsuarios.getColumns().addAll(colId, colNombre, colContr, colCorreo, colTelefono);
            this.tablaUsuarios.getColumns().add(colEliminar);
        }
        //Metodos de la tabla
        /*public void agregarPastel(Pastel pastel, int seleccion) {
            this.pasteles.remove(seleccion);
            this.pasteles.add(seleccion, pastel);
        }

        public void agregarPastel(Pastel pastel) {
            this.pasteles.add(pastel);
        }

        public void agregarPasteles(List<Pastel> listaPasteles) {
            for(int i = 0; i < listaPasteles.size(); ++i) {
                this.pasteles.add((Pastel)listaPasteles.get(i));
            }

        }*/
        //Retorna la tabla hacia la pantalla
        public TableView<Usuario> getTablaUsuario() {
            return this.tablaUsuarios;
        }
/*
        public int total() {
            int total = 0;

            for(int i = 0; i < this.pasteles.size(); ++i) {
                total = (int)((double)total + ((Pastel)this.pasteles.get(i)).getPrecio());
            }

            return total;
        }*/
    }
