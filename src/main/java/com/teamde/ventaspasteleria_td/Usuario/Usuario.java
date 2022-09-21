package com.teamde.ventaspasteleria_td.Usuario;

public class Usuario {
    private String nombre;
    private String usuario;
    private String contrasenia;
        //Cambiar luego por el modelo JPA
    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    

}
