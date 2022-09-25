package com.teamde.ventaspasteleria_td.Vista;

import com.teamde.ventaspasteleria_td.Modelo.Trabajador;
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

public class TablaTrabajador {
    private TableView<Trabajador> tablaUsuarios;
        private ObservableList<Trabajador> trabajadors = FXCollections.observableArrayList();
        //private Pastel pastel;

        // Agregar a los trabajadors desde la base de datos con ayuda del helper

        public TablaTrabajador(List<Trabajador> listaTrabajador) {
            this.trabajadors.addAll(listaTrabajador);
            this.tablaUsuarios = new TableView<>();
            this.tablaUsuarios.getStyleClass().add("table-cell");
            this.tablaUsuarios.setPrefWidth(700.0);
            this.crearTabla();
        }
        //crear la tabla con los atributos del usuario

        public void crearTabla() {
            //this.tablaPasteles.setItems(this.pasteles);
            //Cambiar de  <String, String > a <Trabajador, String> segun sea el caso
            //Corregir las tablas en caso de ser necesario
            TableColumn<Trabajador, String> colId = new TableColumn<Trabajador, String>("ID");
            TableColumn<Trabajador, String> colNombre = new TableColumn<Trabajador, String>("Nombre");
            TableColumn<Trabajador, String> colContr = new TableColumn<Trabajador, String>("Contrasenia");
            TableColumn<Trabajador, String> colCorreo = new TableColumn<Trabajador, String>("Correo");
            TableColumn<Trabajador, String> colTelefono = new TableColumn<Trabajador, String>("Telefono");
            TableColumn<Trabajador, Void> colEliminar = new TableColumn<Trabajador, Void>("Eliminar");

            colEliminar.setPrefWidth(130.0);
            colNombre.setPrefWidth(120.0);
            colContr.setPrefWidth(120.0);
            colCorreo.setPrefWidth(120.0);
            colTelefono .setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("nombre"));
            colContr.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("password"));
            colCorreo.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("correo"));
            colTelefono.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("telefono"));

            //crear y accionar el boton de aliminar
            Callback<TableColumn<Trabajador, Void>, TableCell<Trabajador, Void>> cellFactory1 = new Callback<TableColumn<Trabajador, Void>, TableCell<Trabajador, Void>>() {
                public TableCell<Trabajador, Void> call(TableColumn<Trabajador, Void> param) {
                    TableCell<Trabajador, Void> cell1 = new TableCell<Trabajador, Void>() {
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
        public TableView<Trabajador> getTablaUsuario() {
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
