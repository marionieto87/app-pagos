package com.example.carlosnieto.apppagos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carlosnieto.apppagos.utilidades.Utilidades;

/**
 * Created by Mario on 24/03/2018.
 */

public class ConexionSQliteHelper extends SQLiteOpenHelper {


    public ConexionSQliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(Utilidades.CREAR_TABLA_USUARIO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAntigua, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(bd);
    }
}
