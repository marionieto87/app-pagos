package com.example.carlosnieto.apppagos;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener,
        FragmentRegistraClienteNuevo.OnFragmentInteractionListener,
        FragmentListaClientes.OnFragmentInteractionListener,
        FragmentNuevoPrestamo.OnFragmentInteractionListener,
        FragmentBuscaCliente.OnFragmentInteractionListener {

    FragmentMenu fragmentMenu;
    FragmentRegistraClienteNuevo fragmentRegistraClienteNuevo;
    FragmentListaClientes fragmentListaClientes;
    FragmentNuevoPrestamo fragmentNuevoPrestamo;
    FragmentBuscaCliente fragmentBuscaCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentMenu=new FragmentMenu();
        fragmentRegistraClienteNuevo=new FragmentRegistraClienteNuevo();
        fragmentListaClientes=new FragmentListaClientes();
        fragmentNuevoPrestamo=new FragmentNuevoPrestamo();
        fragmentBuscaCliente=new FragmentBuscaCliente();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,fragmentMenu).commit();

        //ConexionSQliteHelper conn=new ConexionSQliteHelper(this,"bd_usuarios", null,1);
    }

    public void onClick (View view)
    {
        android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

            switch (view.getId()){
                case R.id.btnNuevoCliente:
                    transaction.replace(R.id.contenedorFragment,fragmentRegistraClienteNuevo).addToBackStack(null);
                    break;
                case R.id.btnEstadisticas:
                    break;
                case R.id.btnBuscaCliente:
                    transaction.replace(R.id.contenedorFragment,fragmentBuscaCliente).addToBackStack(null);
                    break;
                case R.id.btnPrestamo:
                    transaction.replace(R.id.contenedorFragment,fragmentNuevoPrestamo).addToBackStack(null);
                    break;
                case R.id.btnListaClientes:
                    transaction.replace(R.id.contenedorFragment,fragmentListaClientes).addToBackStack(null);
                    break;
            }
        transaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Falta el de consultar creditos para poner en el menu
}

