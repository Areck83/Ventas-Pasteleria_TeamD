package com.teamde.ventaspasteleria_td.Productos;

public class Producto {
    private String ID;
    private String nombre;
    private String precio;
    private Double cantidad;
    private String detalles;
    private String IDproveedor;

    public Producto() {
    }

    public Producto(String ID, String nombre, String precio, Double cantidad, String detalles, String IDproveedor) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.detalles = detalles;
        this.IDproveedor = IDproveedor;
    }
}
