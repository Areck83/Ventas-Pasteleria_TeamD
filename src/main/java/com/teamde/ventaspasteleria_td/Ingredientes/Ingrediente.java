package com.teamde.ventaspasteleria_td.Ingredientes;

import java.util.Date;

public class Ingrediente {
    private Integer codigo;
    private String nombre;
    private String tipo;
    private Float cantidad;
    private Date caducidad;

    public Ingrediente(Integer codigo, String nombre, String tipo, Float cantidad, Date caducidad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.caducidad = caducidad;
    }
}
