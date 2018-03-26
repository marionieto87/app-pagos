package com.example.carlosnieto.apppagos.utilidades;

/**
 * Created by Mario on 24/03/2018.
 */

public class Utilidades {

    public static String TABLA_USUARIO     ="usuarios";
    public static String CAMPO_ID_CEDULA   ="id_cedula";
    public static String CAMPO_NOMBRE      ="nombre";
    public static String CAMPO_APELLIDO    ="apellido";
    public static String CAMPO_DIRECCION   ="direccion";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID_CEDULA+" INTEGER, "+CAMPO_NOMBRE+" STRING, "+CAMPO_APELLIDO+" STRING, "+CAMPO_DIRECCION+" STRING)";
}
