package com.chuquiagomarca.kardexchuquiago.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lyanna on 26/04/2018.
 */

public class HandlerBasedeDatos extends SQLiteOpenHelper {

    private final static String NombreBD = "lia";
    private static final int VersionBD = 1;
    private SQLiteDatabase base_datos;
    private Context context;

    //Declaramos las tablas
    private String SQL_URLs         = "CREATE TABLE if not exists urls (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombreconexion TEXT, urlconexion TEXT, estado INTEGER, valor TEXT)";
    private String SQL_ADHERENTS    = "CREATE TABLE if not exists adherents (_id INTEGER PRIMARY KEY AUTOINCREMENT, fk_user INTEGER, login TEXT,contrasenia TEXT, nombre_completo TEXT, nombre_sucursal TEXT, id_sucursal TEXT,entity INTEGER, imei TEXT, estado INTEGER, id_acceso TEXT)";
    private String SQL_CARGAR_BD    = "CREATE TABLE if not exists cargarbd   (_id INTEGER PRIMARY KEY AUTOINCREMENT, detalle TEXT, estado TEXT, id_acceso TEXT)";
    private String SQL_PRODUCTOS    = "CREATE TABLE if not exists productos  (_id INTEGER PRIMARY KEY AUTOINCREMENT,fk_producto INTEGER, ref TEXT, ref_ext TEXT, label TEXT, price TEXT, balance TEXT, id_acceso TEXT)";
    private String SQL_PRODUCTOSNEO = "CREATE TABLE if not exists productosnuevos (_id INTEGER PRIMARY KEY, ref TEXT, ref_ext TEXT, label TEXT, price TEXT, balance TEXT,estado INTEGER, id_acceso TEXT)";
    private String SQL_PRODUCTOSACT = "CREATE TABLE if not exists productosactualizados (_id INTEGER PRIMARY KEY, ref TEXT, ref_ext TEXT, label TEXT, price TEXT, balance TEXT,estado INTEGER, id_acceso TEXT)";
    private String SQL_DETALLE_AUX  = "CREATE TABLE if not exists detalleaux (_id INTEGER PRIMARY KEY , ref TEXT, label TEXT, price TEXT, quantity INTEGER)";
    //private String SQL_DETALLE      = "CREATE TABLE if not exists detalle    (_id INTEGER PRIMARY KEY , ref TEXT, label TEXT, price TEXT, quantity INTEGER, id_pedido INTEGER)";
    private String SQL_DETALLE      = "CREATE TABLE if not exists detalle    (_id INTEGER , ref TEXT, label TEXT, price TEXT, quantity INTEGER, id_pedido INTEGER)";
    private String SQL_PEDIDOS      = "CREATE TABLE if not exists pedidos    (_id INTEGER PRIMARY KEY AUTOINCREMENT, fecha TEXT, id_usuario INTEGER, line INTEGER, send INTEGER, codigo INTEGER, id_acceso TEXT, fk_soc INTEGER)";
    //private String SQL_ACTUALIZAR   = "CREATE TABLE if not exists actualizacion (_id INTEGER PRIMARY KEY, fecha TEXT, nroactualizados TEXT, nronuevos TEXT)";
    private String SQL_ACTUALIZAR   = "CREATE TABLE if not exists actualizacion (_id INTEGER, fecha TEXT, nroactualizados TEXT, nronuevos TEXT)";
    private String SQL_SOCIETE      = "CREATE TABLE if not exists societe (_id INTEGER PRIMARY KEY AUTOINCREMENT, row_id INTEGER, code_client TEXT, code_fournisseur TEXT, nom TEXT, email TEXT, phone TEXT, nit TEXT,address TEXT, status INTEGER, id_acceso TEXT, fk_user INTEGER)";
    private String SQL_CARGAR_SOC   = "CREATE TABLE if not exists cargarsociete (_id INTEGER PRIMARY KEY AUTOINCREMENT, detalle TEXT, estado INTEGER, id_acceso TEXT)";
    //Contructor
    public HandlerBasedeDatos(Context context) {
        super(context, NombreBD, null, VersionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_URLs);
        db.execSQL(SQL_ADHERENTS);
        db.execSQL(SQL_CARGAR_BD);
        db.execSQL(SQL_PRODUCTOS);
        db.execSQL(SQL_PRODUCTOSNEO);
        db.execSQL(SQL_PRODUCTOSACT);
        db.execSQL(SQL_DETALLE_AUX);
        db.execSQL(SQL_DETALLE);
        db.execSQL(SQL_PEDIDOS);
        db.execSQL(SQL_ACTUALIZAR);
        db.execSQL(SQL_SOCIETE);
        db.execSQL(SQL_CARGAR_SOC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS urls;");
        db.execSQL("DROP TABLE IF EXISTS adherents;");
        db.execSQL("DROP TABLE IF EXISTS cargarbd;");
        db.execSQL("DROP TABLE IF EXISTS productos;");
        db.execSQL("DROP TABLE IF EXISTS productosnuevos;");
        db.execSQL("DROP TABLE IF EXISTS productosactualizados;");
        db.execSQL("DROP TABLE IF EXISTS detalleaux;");
        db.execSQL("DROP TABLE IF EXISTS pedidos;");
        db.execSQL("DROP TABLE IF EXISTS detalle;");
        db.execSQL("DROP TABLE IF EXISTS actualizacion;");
        db.execSQL("DROP TABLE IF EXISTS societe");
        db.execSQL("DROP TABLE IF EXISTS cargarsociete");
        onCreate(db);
    }

    public void cerrar(){
        this.close();
    }

    // Metodos de Inserion de Regitros a las tablas

    public void addUrls(String nombre_conexion, String url_conexion, int estado, String valor){
        ContentValues valores = new ContentValues();
        valores.put("nombreconexion",nombre_conexion);
        valores.put("urlconexion",url_conexion);
        valores.put("estado",estado);
        valores.put("valor",valor);
        this.getWritableDatabase().insert("urls", null,valores);
    }

    public void addUsuario(int id, String login, String contrasenia, String nombre_usuario, String nombre_sucursal, int id_sucursal, int entity, String imei, String id_acceso) {
        ContentValues valores = new ContentValues();
        valores.put("fk_user", id);
        valores.put("login", login);
        valores.put("contrasenia", contrasenia);
        valores.put("nombre_completo", nombre_usuario);
        valores.put("nombre_sucursal", nombre_sucursal);
        valores.put("id_sucursal", id_sucursal);
        valores.put("entity", entity);
        valores.put("imei", imei);
        valores.put("estado", 1);
        valores.put("id_acceso",id_acceso);
        this.getWritableDatabase().insert("adherents", null, valores);
    }

    public void addProducto(int _fk_producto, String _ref,String _ref_ext, String _label, String _price,int _balance, String _id_acceso){
        ContentValues valores = new ContentValues();
        valores.put("fk_producto",_fk_producto);
        valores.put("ref",_ref);
        valores.put("ref_ext",_ref_ext);
        valores.put("label",_label);
        valores.put("price",_price);
        valores.put("balance",_balance);
        valores.put("id_acceso",_id_acceso);
        this.getWritableDatabase().insert("productos",null, valores);
    }

    public void addCargaBD ( String _detalle ,String _estado, String _id_acceso){
        ContentValues valores = new ContentValues();
        valores.put("detalle", _detalle);
        valores.put("estado", _estado);
        valores.put("id_acceso", _id_acceso);
        this.getWritableDatabase().insert("cargarbd", null, valores);
    }

    public void addDetalleAux(int _id, String _ref, String _label, String _price,int _quantity){
        ContentValues valores = new ContentValues();
        valores.put("_id",_id);
        valores.put("ref",_ref);
        valores.put("label",_label);
        valores.put("price",_price);
        valores.put("quantity",_quantity);
        this.getWritableDatabase().insert("detalleaux",null, valores);
    }

    public void addDetalle(int _id, String _ref, String _label, String _price,int _quantity, int _id_pedido){
        ContentValues valores = new ContentValues();
        valores.put("_id",_id);
        valores.put("ref",_ref);
        valores.put("label",_label);
        valores.put("price",_price);
        valores.put("quantity",_quantity);
        valores.put("id_pedido",_id_pedido);
        this.getWritableDatabase().insert("detalle",null, valores);
    }

    public void addPedido(String _fecha, int _id_usuario, int _line, int _send, String _id_acceso, int fk_soc){
        ContentValues valores = new ContentValues();
        //valores.put("_id",_id);
        valores.put("fecha",_fecha);
        valores.put("id_usuario",_id_usuario);
        valores.put("line",_line);
        valores.put("send",_send);
        valores.put("codigo",-1);
        valores.put("id_acceso",_id_acceso);
        valores.put("fk_soc",fk_soc);
        this.getWritableDatabase().insert("pedidos",null, valores);
    }

    public void addProductoNuevos(int _id, String _ref,String _ref_ext, String _label, String _price,int _balance,int _estado){
        ContentValues valores = new ContentValues();
        valores.put("_id",_id);
        valores.put("ref",_ref);
        valores.put("ref_ext",_ref_ext);
        valores.put("label",_label);
        valores.put("price",_price);
        valores.put("balance",_balance);
        valores.put("estado",_estado);
        this.getWritableDatabase().insert("productosnuevos",null, valores);
    }

    public void addProductoActualizados    (int _id, String _ref,String _ref_ext, String _label, String _price,int _balance,int _estado){
        ContentValues valores = new ContentValues();
        valores.put("_id",_id);
        valores.put("ref",_ref);
        valores.put("ref_ext",_ref_ext);
        valores.put("label",_label);
        valores.put("price",_price);
        valores.put("balance",_balance);
        valores.put("estado",_estado);
        this.getWritableDatabase().insert("productosactualizados",null, valores);
    }
}