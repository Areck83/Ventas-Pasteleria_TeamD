package com.teamde.ventaspasteleria_td.Modelo;

public class Trabajador {
    private int id;
    private String codigo;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String contr;

    public Trabajador(){
        this.id=0;
        this.codigo="";
        this.nombre="";
        this.primerApellido ="";
        this.segundoApellido="";
        this.telefono="";
        this.contr="";
    }

    public Trabajador(int id, String codigo, String nombre, String primerApellido, String segundoApellido, String telefono, String contr) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.contr = contr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContr() {
        return contr;
    }

    public void setContr(String contr) {
        this.contr = contr;
    }
}
