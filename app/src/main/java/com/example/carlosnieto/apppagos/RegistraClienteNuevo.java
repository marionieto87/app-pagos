package com.example.carlosnieto.apppagos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistraClienteNuevo extends AppCompatActivity {

    public EditText et_nombre, et_apellido, et_celular, et_direccion, et_documento;
    public TextView tv_resultado1;
    public Button bt_nuevo_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre       = (EditText)findViewById(R.id.txt_nombre);
        et_apellido     = (EditText)findViewById(R.id.txt_apellido);
        et_celular      = (EditText)findViewById(R.id.txt_telefono);
        et_direccion    = (EditText)findViewById(R.id.txt_direccion);
        et_documento    = (EditText)findViewById(R.id.txt_documento_cliente);
        tv_resultado1   = (TextView)findViewById(R.id.tv_resultado_guardar);
        bt_nuevo_cliente= (Button)findViewById(R.id.bt_guarda_cliente);
    }

    public void Guarda_Cliente_Nuevo(View view){

        switch (view.getId()){
            case R.id.bt_guarda_cliente:
                guardarPreferencias();
                break;
        }
        String nombre       = et_nombre.getText().toString();
        String apellido     = et_apellido.getText().toString();
        String celular      = et_celular.getText().toString();
        String direccion    = et_direccion.getText().toString();

        Toast.makeText(this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
        //tv_resultado1.setText("Usuario Guardado: " + nombre + apellido);

    }

    private void guardarPreferencias() {
    }
       SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);

       String nombre       = et_nombre.getText().toString();
       String apellido     = et_apellido.getText().toString();

       SharedPreferences.Editor editor= preferences.edit();
       editor.putString("user",nombre);



}
