package com.example.carlosnieto.apppagos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultarCreditos extends AppCompatActivity {

    ArrayList<ClientesDeudaVo> listaDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_creditos);

        listaDatos=new ArrayList<ClientesDeudaVo>();

        recycler= (RecyclerView) findViewById(R.id.recyclerClientesDeuda);
        //recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this,1));

        llenarClienteDeuda();

        AdapterDatos adapter=new AdapterDatos(listaDatos);
        recycler.setAdapter(adapter);

}

    private void llenarClienteDeuda() {
        listaDatos.add(new ClientesDeudaVo("Nieto Juan","$550.000"));
        listaDatos.add(new ClientesDeudaVo("Nieto Santiago","$250.000"));
        listaDatos.add(new ClientesDeudaVo("Garcia Andres","$150.000"));
        listaDatos.add(new ClientesDeudaVo("Gomez Pepe","$400.000"));
        listaDatos.add(new ClientesDeudaVo("Carrillo Diego","$200.000"));
    }
}
