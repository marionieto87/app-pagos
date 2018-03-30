package com.example.carlosnieto.apppagos;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.carlosnieto.apppagos.Fragments.FragmentListaClientes;
import com.example.carlosnieto.apppagos.Fragments.FragmentMenu;
import com.example.carlosnieto.apppagos.Fragments.FragmentRegistraClienteNuevo;

public class MenuActivity extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener,
        FragmentRegistraClienteNuevo.OnFragmentInteractionListener,
        FragmentListaClientes.OnFragmentInteractionListener {

    FragmentMenu fragmentMenu;
    FragmentRegistraClienteNuevo fragmentRegistraClienteNuevo;
    FragmentListaClientes fragmentListaClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentMenu=new FragmentMenu();
        fragmentRegistraClienteNuevo=new FragmentRegistraClienteNuevo();
        fragmentListaClientes=new FragmentListaClientes();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,fragmentMenu).commit();

        //ConexionSQliteHelper conn=new ConexionSQliteHelper(this,"bd_usuarios", null,1);
    }

    public void onClick (View view)
    {
        android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

            switch (view.getId()){
                case R.id.btnNuevoCliente:
                    break;
                case R.id.btnEstadisticas:
                    break;
                case R.id.btnListaClientes:
                    break;
                case R.id.btnPrestamo:
            }
        transaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Falta el de consultar creditos para poner en el menu
}

