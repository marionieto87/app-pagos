package com.example.carlosnieto.apppagos.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carlosnieto.apppagos.ClientesDeudaVo;
import com.example.carlosnieto.apppagos.R;
import com.example.carlosnieto.apppagos.entidades.Usuario;

import java.util.ArrayList;

/**
 * Created by Mario on 8/03/2018.
 */

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Usuario> listaDatos;

    public AdapterDatos(ArrayList<Usuario> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.tvClienteCedula.setText(listaDatos.get(position).getId_cedula().toString());
        holder.tvClienteNombre.setText(listaDatos.get(position).getNombre());
        holder.tvClienteApellido.setText(listaDatos.get(position).getApellido());
        holder.tvClienteDireccion.setText(listaDatos.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
         return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tvClienteNombre,tvClienteApellido,tvClienteCedula,tvClienteDireccion;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            tvClienteCedula=(TextView) itemView.findViewById(R.id.tv_cliente_cedula);
            tvClienteNombre=(TextView) itemView.findViewById(R.id.tv_cliente_nombre);
            tvClienteApellido=(TextView) itemView.findViewById(R.id.tv_cliente_apellidos);
            tvClienteDireccion=(TextView) itemView.findViewById(R.id.tv_cliente_direccion);

        }

    }
}
