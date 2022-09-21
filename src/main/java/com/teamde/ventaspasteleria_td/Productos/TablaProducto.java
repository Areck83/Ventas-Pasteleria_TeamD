package com.teamde.ventaspasteleria_td.Productos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.List;

public class TablaProducto {
    private TableView<Producto> tablaUsuarios;
        private ObservableList<Producto> usuarios = FXCollections.observableArrayList();
        //private Pastel pastel;

        // Agregar a los usuarios desde la base de datos con ayuda del helper

        public TablaProducto(List<Producto> listaUsuario) {
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
            TableColumn<Producto, String> colId = new TableColumn<Producto, String>("ID");
            TableColumn<Producto, String> colNombre = new TableColumn<Producto, String>("Nombre");
            TableColumn<Producto, String> colContr = new TableColumn<Producto, String>("Contrasenia");
            TableColumn<Producto, String> colCorreo = new TableColumn<Producto, String>("Correo");
            TableColumn<Producto, String> colTelefono = new TableColumn<Producto, String>("Telefono");
            TableColumn<Producto, Void> colEliminar = new TableColumn<Producto, Void>("Eliminar");

            colEliminar.setPrefWidth(130.0);
            colNombre.setPrefWidth(120.0);
            colContr.setPrefWidth(120.0);
            colCorreo.setPrefWidth(120.0);
            colTelefono .setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
            colContr.setCellValueFactory(new PropertyValueFactory<Producto, String>("password"));
            colCorreo.setCellValueFactory(new PropertyValueFactory<Producto, String>("correo"));
            colTelefono.setCellValueFactory(new PropertyValueFactory<Producto, String>("telefono"));

            //Boton de aliminar
            Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>> cellFactory1 = new Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>>() {
                public TableCell<Producto, Void> call(TableColumn<Producto, Void> param) {
                    TableCell<Producto, Void> cell1 = new TableCell<Producto, Void>() {
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

        public TableView<Producto> getTablaUsuario() {
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
