package com.chuquiagomarca.kardexchuquiago.Maya;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.chuquiagomarca.kardexchuquiago.Modelo.HandlerBasedeDatos;

/**
 * Created by Lyanna on 26/04/2018.
 */

public class Maya {
        private Context context ;
        private HandlerBasedeDatos manejaBD;
        private SQLiteDatabase nuestraBD;

        public Maya(Context context) {
            this.context = context;
        }

        public void Toast(String msm){
            Toast.makeText(context,msm,Toast.LENGTH_SHORT).show();
        }

    public String buscarNombreUsuario(){
        String[] columnasu = { "nombre_completo" };
        manejaBD = new HandlerBasedeDatos(context);
        nuestraBD = manejaBD.getWritableDatabase();
        Cursor cu = nuestraBD.query("usuario",columnasu,"1 = 1",null,null,null,null);
        //Log.d("sql",cu.getCount()+"");
        if(cu.getCount() == 1){

            int i_nombre  = cu.getColumnIndex("nombre_completo");
            cu.moveToFirst();
            Log.d("IdAcceso : ", cu.getString(i_nombre)+"" );

            return  cu.getString(i_nombre);

        }else{
            return  "";
        }
    }

    public String buscarId_User(){
        String[] columnasu = { "_id_usuario" };
        manejaBD = new HandlerBasedeDatos(context);
        nuestraBD = manejaBD.getWritableDatabase();
        Cursor cu = nuestraBD.query("usuario",columnasu,"1 = 1",null,null,null,null);
        //Log.d("sql",cu.getCount()+"");
        if(cu.getCount() == 1){

            int i_id_usuario  = cu.getColumnIndex("_id_usuario");
            cu.moveToFirst();
            Log.d("Id_Usuario : ", cu.getString(i_id_usuario)+"" );

            return  cu.getString(i_id_usuario);

        }else{
            return  "-1";
        }
    }

    public boolean usuarioLogeado(){
        String[] columnasu = { "nombre_completo" };
        manejaBD = new HandlerBasedeDatos(context);
        nuestraBD = manejaBD.getWritableDatabase();
        Cursor cu = nuestraBD.query("usuario",columnasu,"1 = 1",null,null,null,null);
        //Log.d("sql",cu.getCount()+"");
        if(cu.getCount() == 1){
            return  true;
        }else{
            return false;
        }
    }


    public int accesoInternet(){
            ConnectivityManager cm;
            NetworkInfo ni;
            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            ni = cm.getActiveNetworkInfo();
            boolean tipoConexion1 = false;
            boolean tipoConexion2 = false;
            int respuesta = -1;

            if (ni != null) {
                ConnectivityManager connManager1 = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mWifi = connManager1.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                ConnectivityManager connManager2 = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mMobile = connManager2.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if (mWifi.isConnected()) {
                    tipoConexion1 = true;
                }
                if (mMobile.isConnected()) {
                    tipoConexion2 = true;
                }

                if (tipoConexion1 == true || tipoConexion2 == true) {
                    respuesta = 1;/* Estas conectado a internet usando wifi o redes moviles, puedes enviar tus datos */
                }
            }
            else {
       /* No estas conectado a internet */
                respuesta = 0;
            }
            return  respuesta;
        }
}


