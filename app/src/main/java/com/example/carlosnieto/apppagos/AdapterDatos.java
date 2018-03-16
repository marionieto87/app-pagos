package com.example.carlosnieto.apppagos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mario on 8/03/2018.
 */

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<ClientesDeudaVo> listaDatos;

    public AdapterDatos(ArrayList<ClientesDeudaVo> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.tvClienteNombre.setText(listaDatos.get(position).getNombre());
        holder.tvClienteDeuda.setText(listaDatos.get(position).getMonto_deuda());
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tvClienteNombre,tvClienteDeuda;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            tvClienteNombre=(TextView) itemView.findViewById(R.id.tv_cliente_nombre);
            tvClienteDeuda=(TextView) itemView.findViewById(R.id.tv_cliente_deuda);
        }

    }
}
