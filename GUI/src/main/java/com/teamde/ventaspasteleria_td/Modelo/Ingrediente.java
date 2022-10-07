package com.teamde.ventaspasteleria_td.Modelo;

public class Ingrediente {
    private String ID;
    private String nombre;
    private String precio;
    private Double cantidad;
    private String detalles;
    private String IDproveedor;

    public Ingrediente() {
    }

    public Ingrediente(String ID, String nombre, String precio, Double cantidad, String detalles, String IDproveedor) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.detalles = detalles;
        this.IDproveedor = IDproveedor;
    }
}
