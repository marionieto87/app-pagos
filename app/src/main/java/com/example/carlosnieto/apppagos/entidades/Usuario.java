package com.example.carlosnieto.apppagos.entidades;

/**
 * Created by Mario on 24/03/2018.
 */

public class Usuario {
    private Integer id_cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private Integer id_estado;
    private Integer id_credito;
    private Integer id_tipousuario;
    private Integer id_tipotelefono;

    public Usuario() {
        this.id_cedula  = id_cedula;
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.direccion  = direccion;
    }

    public Integer getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(Integer id_cedula) {
        this.id_cedula = id_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
