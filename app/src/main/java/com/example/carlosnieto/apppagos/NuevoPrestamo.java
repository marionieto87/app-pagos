package com.example.carlosnieto.apppagos;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NuevoPrestamo extends AppCompatActivity {



    EditText     monto, fecha_prestamo;
    TextView     cliente_nuevo_prestamo, tvresultado;
    Button       btncalculo;
    int          prestamo_total;
    double       porcent;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_prestamo);

        cliente_nuevo_prestamo  = (TextView) findViewById(R.id.tv_nombre_cliente);
        monto                   = (EditText) findViewById(R.id.et_monto_prestamo);
        fecha_prestamo          = (EditText) findViewById(R.id.et_fecha_prestamo);
        tvresultado             = (TextView) findViewById(R.id.tv_resultado);
    }

   /* public void guardaPrestamo(View view) {
        switch (view.getId())
        {
            case R.id.bt_guarda_prestamo:
                String nombre=cliente_nuevo_prestamo.getText().toString();
                String deuda=monto.getText().toString();
                tvresultado.setText(nombre + " su crédito por $" + deuda + "/mcte fue aprobado");
                    break;
        }
    }*/


    public void calcularCuota(View view) {

        prestamo_total = Integer.parseInt(monto.getText().toString());


        switch (view.getId())
        {
            case R.id.bt_calcula_prestamo: calcular();
            break;
            case R.id.bt_guarda_prestamo: guardar();
                break;
        }
    }

    private void calcular() {
        int valor       = Integer.parseInt(monto.getText().toString());
        double porcent  =0.10;
        double porcentaje  =((valor*porcent)+valor);
        tvresultado.setText("El Monto total a pagar es de: " + porcentaje);
    }
    private void guardar() {
    }


}
