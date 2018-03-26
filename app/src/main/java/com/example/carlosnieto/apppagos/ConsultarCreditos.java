package com.example.carlosnieto.apppagos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.carlosnieto.apppagos.Adaptadores.AdapterDatos;
import com.example.carlosnieto.apppagos.entidades.Usuario;
import com.example.carlosnieto.apppagos.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarCreditos extends AppCompatActivity {

    ArrayList<Usuario> listaDatos;
    RecyclerView recyclerViewClientesDeuda;

    ConexionSQliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_creditos);

        conn=new ConexionSQliteHelper(getApplicationContext(),"bd_usuarios",null,1);

        listaDatos=new ArrayList<>();

        recyclerViewClientesDeuda= (RecyclerView) findViewById(R.id.recyclerClientesDeuda);
        recyclerViewClientesDeuda.setLayoutManager(new LinearLayoutManager(this));

        llenarClienteDeuda();

        AdapterDatos adapter=new AdapterDatos(listaDatos);
        recyclerViewClientesDeuda.setAdapter(adapter);

}

    private void llenarClienteDeuda() {
        SQLiteDatabase db= conn.getReadableDatabase();

        Usuario usuario=null;

        Cursor cursor=db.rawQuery("SELECT * FROM"+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId_cedula(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setDireccion(cursor.getString(3));

            listaDatos.add(usuario);
        }
    }
}
