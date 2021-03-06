package com.example.carlosnieto.apppagos;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentNuevoPrestamo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentNuevoPrestamo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNuevoPrestamo extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText campoDocumento, campoNombre, campoMonto, campoFechaPrestamo, campoFechaRecoleccion;
    TextView searchNombre;
    private int  dia, mes, ano;
    Button btnBuscaClientePrestamo,btnFechaPrestamo, btnFechaRecoleccion, btnGuardaPrestamo;
    ProgressDialog progreso;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public FragmentNuevoPrestamo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNuevoPrestamo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNuevoPrestamo newInstance(String param1, String param2) {
        FragmentNuevoPrestamo fragment = new FragmentNuevoPrestamo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista=inflater.inflate(R.layout.fragment_nuevo_prestamo,container,false);
        campoDocumento      = (EditText) vista.findViewById(R.id.et_cedula_cliente);
        campoMonto          = (EditText) vista.findViewById(R.id.et_monto_prestamo);
        campoFechaPrestamo  = (EditText) vista.findViewById(R.id.et_fecha_prestamo);
        campoFechaRecoleccion = (EditText) vista.findViewById(R.id.et_fecha_recolectar);
        btnGuardaPrestamo   = (Button) vista.findViewById(R.id.btn_guarda_prestamo);
        btnFechaPrestamo    = (Button) vista.findViewById(R.id.btn_fecha_prestamo);
        btnFechaRecoleccion = (Button) vista.findViewById(R.id.btn_fecha_recolectar);

        request= Volley.newRequestQueue(getContext());

        btnGuardaPrestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();
            }
        });

        btnFechaPrestamo.setOnClickListener(this);
        btnFechaRecoleccion.setOnClickListener(this);

        return vista;


    }

    @Override
    public void onClick(View v) {
        if(v==btnFechaPrestamo){
            final Calendar c= Calendar.getInstance();
            dia  = c.get(Calendar.DAY_OF_MONTH);
            mes  = c.get(Calendar.MONTH);
            ano  = c.get(Calendar.YEAR);

            DatePickerDialog date = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    campoFechaPrestamo.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,ano,mes,dia);
            date.show();

        }
        if(v==btnFechaRecoleccion){
            final Calendar c= Calendar.getInstance();
            dia  = c.get(Calendar.DAY_OF_MONTH);
            mes  = c.get(Calendar.MONTH);
            ano  = c.get(Calendar.YEAR);

            DatePickerDialog date = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    campoFechaRecoleccion.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,ano,mes,dia);
            date.show();

        }

    }


    private void cargarWebService() {
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("Cargando...");
        progreso.show();

        String url="http://192.168.1.16/conexion-app-pagos/wsJSONGuardaPrestamo.php?id_documento="+campoDocumento.getText().toString()+
                "&monto="+campoMonto.getText().toString()+
                "&fecha_prestamo="+campoFechaPrestamo.getText().toString()+
                "&fecha_recoleccion="+campoFechaRecoleccion.getText().toString();

        url=url.replace(" ","%20");

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Se ha registrado exitosamente",Toast.LENGTH_SHORT).show();
        progreso.hide();
        campoDocumento.setText("");
        campoMonto.setText("");
        campoFechaPrestamo.setText("");
        campoFechaRecoleccion.setText("");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(getContext(),"No se puede registrar"+error.toString(), Toast.LENGTH_SHORT).show();
        Log.i("ERROR",error.toString());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
