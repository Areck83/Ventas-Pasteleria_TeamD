package com.teamde.ventaspasteleria_td.Modelo;

import javafx.scene.control.Button;

public class Proveedor {
    private Integer codigo;
    private String nombre;
    private String correo;
    private Integer telefono;

    public Proveedor() {

    }

    public Proveedor(Integer codigo, String nombre, String contrasenia, Integer telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}
