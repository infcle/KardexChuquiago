package com.chuquiagomarca.kardexchuquiago.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lyanna on 26/04/2018.
 */

public class HandlerBasedeDatos extends SQLiteOpenHelper {

    private final static String NombreBD = "Rion";
    private static final int VersionBD = 1;
    private SQLiteDatabase base_datos;
    private Context context;

    //Declaramos las tablas
    private String SQL_USUARIO = "CREATE TABLE if not exists usuario (_id_usuario INTEGER, id_rol INTEGER, rol_nombre TEXT, nombre_completo TEXT, id_docente INTEGER)";

    //Contructor
    public HandlerBasedeDatos(Context context) {
        super(context, NombreBD, null, VersionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS usuario;");

        onCreate(db);
    }

    public void cerrar(){
        this.close();
    }

    // Metodos de Inserion de Regitros a las tablas

    public void addUsuario(int _id_usuario, int id_rol, String rol_nombre, String nombre_completo, int id_docente){
        ContentValues valores = new ContentValues();
        valores.put("_id_usuario", _id_usuario);
        valores.put("id_rol", id_rol);
        valores.put("rol_nombre", rol_nombre);
        valores.put("nombre_completo", nombre_completo);
        valores.put("id_docente", id_docente);
        this.getWritableDatabase().insert("usuario", null,valores);
    }

}