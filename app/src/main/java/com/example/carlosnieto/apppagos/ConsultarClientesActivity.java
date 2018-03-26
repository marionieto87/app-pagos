package com.example.carlosnieto.apppagos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosnieto.apppagos.utilidades.Utilidades;

public class ConsultarClientesActivity extends AppCompatActivity {

    EditText campoCedula, campoNombres, campoApellidos, campoDireccion;

    ConexionSQliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);
        
        conn=new ConexionSQliteHelper(getApplicationContext(),"bd_usuarios",null,1);

        campoCedula     = (EditText) findViewById(R.id.search_cedula);
        campoNombres    = (EditText) findViewById(R.id.search_nombre);
        campoApellidos  = (EditText) findViewById(R.id.search_apellido);
        campoDireccion  = (EditText) findViewById(R.id.search_direccion);

    }


    public void onClickSearch(View view) {

        switch (view.getId()){
            case R.id.btn_busca_cliente:
                consultar();
                break;
        }
    }

    private void consultar() {
        SQLiteDatabase db   =conn.getReadableDatabase();
        String[] parametros ={campoCedula.getText().toString()};
        String[] campos     ={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDO,Utilidades.CAMPO_DIRECCION};

        try {
            Cursor cursor   =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID_CEDULA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombres.setText(cursor.getString(0));
            campoApellidos.setText(cursor.getString(1));
            campoDireccion.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_SHORT).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNombres.setText("");
        campoApellidos.setText("");
        campoDireccion.setText("");
    }
}
