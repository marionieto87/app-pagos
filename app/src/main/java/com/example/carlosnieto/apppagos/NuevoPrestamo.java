package com.example.carlosnieto.apppagos;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosnieto.apppagos.utilidades.Utilidades;

import java.util.Calendar;

public class NuevoPrestamo extends AppCompatActivity implements View.OnClickListener {



    EditText     campoCedula, campoMonto, campoFechaPrestamo, campoNombre, campoFechaRecoleccion;
    TextView     cliente_nuevo_prestamo, tvresultado;
    Button       btncalculo;
    int          prestamo_total;
    double       porcent;
    private int  dia, mes, ano;

    ConexionSQliteHelper conn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_prestamo);

        campoCedula             = (EditText) findViewById(R.id.txt_cedula_cliente);
        campoNombre             = (EditText) findViewById(R.id.etNombreCLiente);
        campoMonto              = (EditText) findViewById(R.id.et_monto_prestamo);
        campoFechaPrestamo      = (EditText) findViewById(R.id.et_fecha_prestamo);
        campoFechaRecoleccion   = (EditText) findViewById(R.id.et_fecha_recolectar);
        tvresultado             = (TextView) findViewById(R.id.tv_resultado);

        campoFechaPrestamo.setOnClickListener(this);
        campoFechaRecoleccion.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==campoFechaPrestamo){
            final Calendar c= Calendar.getInstance();
            dia  = c.get(Calendar.DAY_OF_MONTH);
            mes  = c.get(Calendar.MONTH);
            ano  = c.get(Calendar.YEAR);

            DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    campoFechaPrestamo.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,ano,mes,dia);
            date.show();

        }
        if(v==campoFechaRecoleccion){
            final Calendar c= Calendar.getInstance();
            dia  = c.get(Calendar.DAY_OF_MONTH);
            mes  = c.get(Calendar.MONTH);
            ano  = c.get(Calendar.YEAR);

            DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    campoFechaRecoleccion.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,ano,mes,dia);
            date.show();


        }

    }


    public void calcularCuota(View view) {

        prestamo_total = Integer.parseInt(campoMonto.getText().toString());


        switch (view.getId())
        {
            case R.id.bt_calcula_prestamo: calcular();
                break;
            case R.id.bt_guarda_prestamo: guardar();
                break;
        }
    }

    private void calcular() {
        int valor       = Integer.parseInt(campoMonto.getText().toString());
        double porcent  =0.10;
        double porcentaje  =((valor*porcent)+valor);
        tvresultado.setText("El Monto total a pagar es de: " + porcentaje);
    }
    private void guardar() {
    }


    public void onClickSearch(View view) {
        switch (view.getId()){
            case R.id.btn_busca_cliente:
                consultar();
                break;
        }
    }

    private void consultar() {
        SQLiteDatabase db   = conn.getReadableDatabase();
        String[] parametros ={campoCedula.getText().toString()};
        String[] campos     ={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDO};

        try {
            Cursor cursor   =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID_CEDULA+"0?",parametros,null,null,null);
            cursor.moveToFirst();
            campoCedula.setText(cursor.getString(0));
            campoNombre.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }
    private void limpiar() {
        campoCedula.setText("");
        campoNombre.setText("");
    }



}
