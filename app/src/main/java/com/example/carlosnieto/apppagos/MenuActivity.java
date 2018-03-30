package com.example.carlosnieto.apppagos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.carlosnieto.apppagos.Fragments.FragmentRegistraClienteNuevo;

public class MenuActivity extends AppCompatActivity {

    Button bt_guarda_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConexionSQliteHelper conn=new ConexionSQliteHelper(this,"bd_usuarios", null,1);
    }

    public void nuevo_cliente (View view)
    {
        Intent obj  = new Intent(MenuActivity.this,FragmentRegistraClienteNuevo.class);
        startActivity(obj);
    }

    public void ver_creditos (View view)
    {
        Intent credit  = new Intent(MenuActivity.this,ConsultarClientesActivity.class);
        startActivity(credit);
    }

    public void nuevo_prestamo (View view)
    {
        Intent credit  = new Intent(MenuActivity.this,NuevoPrestamo.class);
        startActivity(credit);
    }

    public void ver_ganancias(View view) {
        Intent credit  = new Intent(MenuActivity.this,ConsultarCreditos.class);
        startActivity(credit);
    }

    //Falta el de consultar creditos para poner en el menu
}

