package com.example.carlosnieto.apppagos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosnieto.apppagos.utilidades.Utilidades;

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
        //registrarUsuarios();
        registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {
        ConexionSQliteHelper conn=new ConexionSQliteHelper(this,"bd_usuarios", null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id_cedula,nombre,apellido,direccion) values (42159168, Adriana, Soto, Los Molinos mz 31 cs 9)

        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO
                +" ( "
                +Utilidades.CAMPO_ID_CEDULA+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_DIRECCION+")" +
                " VALUES ("+et_documento.getText().toString()+", '"+et_nombre.getText().toString()+"','"+et_apellido.getText().toString()+"','"+et_direccion.getText().toString()+"')";

        db.execSQL(insert);

        db.close();
    }

    private void registrarUsuarios() {
        ConexionSQliteHelper conn=new ConexionSQliteHelper(this,"bd_usuarios", null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID_CEDULA,et_documento.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,et_nombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,et_apellido.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION,et_direccion.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID_CEDULA,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();

    }

}
