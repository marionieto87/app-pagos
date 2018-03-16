package com.example.carlosnieto.apppagos;

/**
 * Created by Mario on 11/03/2018.
 */

public class ClientesDeudaVo {

    private String nombre;
    private String monto_deuda;

    public ClientesDeudaVo(){

    }

    public ClientesDeudaVo(String nombre, String monto_deuda) {
        this.nombre = nombre;
        this.monto_deuda = monto_deuda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMonto_deuda() {
        return monto_deuda;
    }

    public void setMonto_deuda(String monto_deuda) {
        this.monto_deuda = monto_deuda;
    }
}
