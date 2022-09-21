package com.teamde.ventaspasteleria_td.Productos;

/*public class EditarUsuario extends GridPane {
    private Double precioPastel = 0.0;
    private Double precioTamano = 0.0;
    private Double precioTipoPan = 0.0;
    private Double precioForma = 0.0;
    private Double precioRelleno = 0.0;
    private Double precioRNoPisos = 0.0;
    private ComboBox<String> cbTamano;
    private ComboBox<String> cbRelleno;
    private ComboBox<String> cbTipoPan;
    private ComboBox<String> cbForma;
    private ComboBox<Integer> cbNoPisos;
    private ColorPicker color;
    private TextArea tDetalles;
    private Label Precio;
    private Label lAgregar;
    private Label lTamano;
    private Label lRelleno;
    private Label lTipo;
    private Label lColor;
    private Label lForma;
    private Label lDetalles;
    private Label lNoPisos;
    private ImageView imagenesPastel;
    private Stage stage1;
    private Button bModificar;
    private Pastel pastel;

    public EditarPastel(Stage stage, Pastel pastel, TablaPastelesEditar tablaPasteles, int seleccion) {
        this.pastel = pastel;
        this.stage1 = stage;
        this.bModificar = new Button("Modificar");
        this.inicializarComponentes(this.bModificar);
        this.llenarFormulario(pastel);
        this.precioPastel = pastel.getPrecio();
        this.bModificar.setOnAction((evtm) -> {
            Pastel pastel1 = this.crearPastel();
            tablaPasteles.agregarPastel(pastel1, seleccion);
            stage.close();
        });
    }

    private void llenarFormulario(Pastel pastel) {
        this.cbTamano.getSelectionModel().select(pastel.getTamano());
        this.cbRelleno.getSelectionModel().select(pastel.getRelleno());
        this.cbForma.getSelectionModel().select(pastel.getForma());
        this.cbNoPisos.getSelectionModel().select(pastel.getPisos() - 1);
        this.cbTipoPan.getSelectionModel().select(pastel.getTipoPan());
        this.tDetalles.setText(pastel.getDetalles());
        this.color.setValue(Color.web(pastel.getColor()));
        this.inicializarPrecios();
        this.Precio.setText("Precio: " + pastel.getPrecio());
    }

    private void inicializarPrecios() {
        int seleccion1 = this.cbTamano.getSelectionModel().getSelectedIndex();
        if (seleccion1 == 0) {
            this.precioTamano = 110.0;
        }

        if (seleccion1 == 1) {
            this.precioTamano = 120.0;
        }

        if (seleccion1 == 2) {
            this.precioTamano = 150.0;
        }

        int seleccion2 = this.cbTipoPan.getSelectionModel().getSelectedIndex();
        if (seleccion2 == 0) {
            this.precioTipoPan = 100.0;
        }

        if (seleccion2 == 1) {
            this.precioTipoPan = 120.0;
        }

        if (seleccion2 == 2) {
            this.precioTipoPan = 150.0;
        }

        int seleccion3 = this.cbRelleno.getSelectionModel().getSelectedIndex();
        if (seleccion3 == 0) {
            this.precioRelleno = 80.0;
        }

        if (seleccion3 == 1) {
            this.precioRelleno = 50.0;
        }

        if (seleccion3 == 2) {
            this.precioRelleno = 30.0;
        }

        int seleccion4 = this.cbNoPisos.getSelectionModel().getSelectedIndex();
        if (seleccion4 == 0) {
            this.precioRNoPisos = 100.0;
        }

        if (seleccion4 == 1) {
            this.precioRNoPisos = 150.0;
        }

        if (seleccion4 == 2) {
            this.precioRNoPisos = 310.0;
        }

        if (seleccion4 == 3) {
            this.precioRNoPisos = 450.0;
        }

        if (seleccion4 == 4) {
            this.precioRNoPisos = 600.0;
        }

    }

    private void inicializarComponentes(Button bModificar) {
        this.setStyle("-fx-background-color: #dfe6e9");
        this.lTipo = new Label("Tipo de Pan: ");
        this.cbTipoPan = new ComboBox();
        this.crearListaTipoPan(this.cbTipoPan);
        this.cbTipoPan.setPrefHeight(30.0);
        this.cbTipoPan.setPrefWidth(200.0);
        this.cbTipoPan.getStyleClass().add("combo-box-base");
        this.cbTipoPan.setOnAction((evt) -> {
            this.accionCBTipoPan();
        });
        this.lColor = new Label("Color del pastel:");
        this.color = new ColorPicker();
        this.color.setPrefHeight(39.0);
        this.color.setPrefWidth(200.0);
        this.lRelleno = new Label("Relleno del partel: ");
        this.cbRelleno = new ComboBox();
        this.cbRelleno.setPrefHeight(35.0);
        this.cbRelleno.setPrefWidth(200.0);
        this.crearListaRelleno(this.cbRelleno);
        this.cbRelleno.setOnAction((evt) -> {
            this.accionCBRelleno();
        });
        this.lNoPisos = new Label("Numero de pisos: ");
        this.cbNoPisos = new ComboBox();
        this.cbNoPisos.setPrefHeight(35.0);
        this.cbNoPisos.setPrefWidth(200.0);
        this.crearListaNoPisos(this.cbNoPisos);
        this.cbNoPisos.setOnAction((evt) -> {
            this.accionCBNoPisos();
        });
        this.lForma = new Label("Forma del pastel: ");
        this.cbForma = new ComboBox();
        this.cbForma.setPrefHeight(35.0);
        this.cbForma.setPrefWidth(200.0);
        this.crearListaFromas(this.cbForma);
        this.lTamano = new Label("Selecciona el tamaño: ");
        this.cbTamano = new ComboBox();
        this.cbTamano.setPrefWidth(200.0);
        this.crearListaTamanos(this.cbTamano);
        this.cbTamano.setOnAction((evt) -> {
            this.accionCBTamano();
        });
        this.lDetalles = new Label("Detalles del pastel: ");
        this.tDetalles = new TextArea();
        this.tDetalles.setMaxSize(300.0, 70.0);
        this.tDetalles.setPromptText("Ingresa los detalles del pastel");
        this.tDetalles.getStyleClass().add("ios-field");
        this.Precio = new Label("Precio del pastel: $" + this.precioPastel);
        this.add(this.lTipo, 3, 0);
        this.add(this.cbTipoPan, 4, 0);
        this.add(this.lColor, 3, 2);
        this.add(this.color, 4, 2);
        this.add(this.lRelleno, 3, 4);
        this.add(this.cbRelleno, 4, 4);
        this.add(this.lTamano, 3, 6);
        this.add(this.cbTamano, 4, 6);
        this.add(this.lForma, 3, 8);
        this.add(this.cbForma, 4, 8);
        this.add(this.lNoPisos, 3, 10);
        this.add(this.cbNoPisos, 4, 10);
        this.add(this.lDetalles, 3, 12);
        this.add(this.tDetalles, 4, 12);
        this.add(this.Precio, 3, 15);
        this.add(bModificar, 4, 15);
        bModificar.getStyleClass().add("cssBoton");
        bModificar.setAlignment(Pos.BOTTOM_LEFT);
        this.setHgap(7.0);
        this.setVgap(7.0);
        this.setAlignment(Pos.CENTER);
    }

    private void accionCBTamano() {
        int seleccion = this.cbTamano.getSelectionModel().getSelectedIndex();
        if (seleccion == 0) {
            this.precioTamano = 110.0;
        }

        if (seleccion == 1) {
            this.precioTamano = 120.0;
        }

        if (seleccion == 2) {
            this.precioTamano = 150.0;
        }

        this.precioPastel = this.precioTipoPan + this.precioForma + this.precioRelleno + this.precioRNoPisos + this.precioTamano;
        this.Precio.setText("Precio del pastel: $" + this.precioPastel);
    }

    private void accionCBTipoPan() {
        int seleccion = this.cbTipoPan.getSelectionModel().getSelectedIndex();
        if (seleccion == 0) {
            this.precioTipoPan = 100.0;
        }

        if (seleccion == 1) {
            this.precioTipoPan = 120.0;
        }

        if (seleccion == 2) {
            this.precioTipoPan = 150.0;
        }

        this.precioPastel = this.precioTipoPan + this.precioForma + this.precioRelleno + this.precioRNoPisos;
        this.Precio.setText("Precio del pastel: $" + this.precioPastel);
    }

    private void accionCBRelleno() {
        int seleccion = this.cbRelleno.getSelectionModel().getSelectedIndex();
        if (seleccion == 0) {
            this.precioRelleno = 80.0;
        }

        if (seleccion == 1) {
            this.precioRelleno = 50.0;
        }

        if (seleccion == 2) {
            this.precioRelleno = 30.0;
        }

        this.precioPastel = this.precioTipoPan + this.precioForma + this.precioRelleno + this.precioRNoPisos;
        this.Precio.setText("Precio del pastel: $" + this.precioPastel);
    }

    private void accionCBNoPisos() {
        int seleccion = this.cbNoPisos.getSelectionModel().getSelectedIndex();
        if (seleccion == 0) {
            this.precioRNoPisos = 100.0;
        }

        if (seleccion == 1) {
            this.precioRNoPisos = 150.0;
        }

        if (seleccion == 2) {
            this.precioRNoPisos = 310.0;
        }

        if (seleccion == 3) {
            this.precioRNoPisos = 450.0;
        }

        if (seleccion == 4) {
            this.precioRNoPisos = 600.0;
        }

        this.precioPastel = this.precioTipoPan + this.precioForma + this.precioRelleno + this.precioRNoPisos;
        this.Precio.setText("Precio del pastel: $" + this.precioPastel);
    }

    private void crearListaNoPisos(ComboBox<Integer> cbNoPisos) {
        cbNoPisos.getItems().addAll(new Integer[]{1, 2, 3, 4, 5});
    }

    private void crearListaRelleno(ComboBox cbRelleno) {
        cbRelleno.getItems().addAll(new Object[]{"Queso Crema", "Frutas", "Fresa"});
    }

    private void crearListaFromas(ComboBox imagenesForma) {
        String[] nombreTamanos = new String[]{"circulo.png", "cuadrado.png"};
        ImageView[] imagenes = new ImageView[nombreTamanos.length];
        int i = 0;
        String[] var5 = nombreTamanos;
        int var6 = nombreTamanos.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String nombreTamano = var5[var7];
            Image inombreTamano = new Image(this.getClass().getResourceAsStream(nombreTamano));
            imagenes[i] = new ImageView(inombreTamano);
            imagenes[i].setFitHeight(25.0);
            imagenes[i].setFitWidth(25.0);
            ++i;
        }

        imagenesForma.getItems().addAll(imagenes);
        imagenesForma.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    private Rectangle rectangulo;

                    {
                        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        this.rectangulo = new Rectangle(25.0, 25.0);
                    }

                    public void updateItem(ImageView item, boolean vacio) {
                        super.updateItem(item, vacio);
                        if (item != null && !vacio) {
                            this.rectangulo.setFill(new ImagePattern(item.getImage()));
                            this.setGraphic(this.rectangulo);
                        } else {
                            this.setGraphic((Node)null);
                        }

                    }
                };
            }
        });
    }

    private void crearListaTipoPan(ComboBox cbTipoPan) {
        cbTipoPan.getItems().addAll(new Object[]{"Chocolate", "3 Leches", "Moka"});
    }

    private void crearListaTamanos(ComboBox<String> cbTamano) {
        cbTamano.getItems().addAll(new String[]{"Chico", "Mediano", "Grande"});
    }

    public Pastel crearPastel() {
        String forma;
        if (this.cbForma.getSelectionModel().getSelectedIndex() == 0) {
            forma = "circulo";
        } else {
            forma = "cuadrado";
        }

        return new Pastel("1", (String)this.cbTipoPan.getValue(), (String)this.cbRelleno.getValue(), ((Color)this.color.getValue()).toString(), forma, (Integer)this.cbNoPisos.getValue(), (String)this.cbTamano.getValue(), this.precioPastel, this.tDetalles.getText());
    }
}*/
