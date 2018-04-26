package com.chuquiagomarca.kardexchuquiago.Maya;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

        public int obtenerSesionID() {

            String[] columnas = { "_id","fk_user","estado" };
            manejaBD = new HandlerBasedeDatos(context);
            nuestraBD = manejaBD.getWritableDatabase();
            Cursor c = nuestraBD.query("adherents",columnas,"estado = 1",null,null,null,null);
            //Toast.makeText(context," Count de la Consulta "+ c.getCount() ,Toast.LENGTH_SHORT).show();
            if(c.getCount() == 1){
                int i_id     = c.getColumnIndex("_id");
                int i_estado = c.getColumnIndex("estado");

                int valor_id = -1;
                for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                    valor_id = c.getInt(i_id);
                    //valor_id = c.getInt(i_estado);
                }
                manejaBD.close();
                return valor_id;
            }else{
                manejaBD.close();
                return -1;
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


