package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.chuquiagomarca.kardexchuquiago.Maya.Maya;
import com.chuquiagomarca.kardexchuquiago.Modelo.HandlerBasedeDatos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

    private Button    _btnIngresar;
    private EditText  _etUsuario, _etContrasenia;
    private Maya      maya;
    private String    Contrasenia;
    //Intancias para la Web Service
    private RequestQueue request;
    private JsonObjectRequest jsonObjectRequest;
    //Instancias para el manejo de la BD
    private HandlerBasedeDatos manejaBD;
    private SQLiteDatabase nuestraBD;
    private String nombreconexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // -->Poner la pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // -->Poner Pantalla Completa
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _etUsuario     = findViewById(R.id.et_user);
        _etContrasenia = findViewById(R.id.et_password);
        _btnIngresar   = findViewById(R.id.btn_Ingresar);
        _btnIngresar.setOnClickListener(this);
        maya = new Maya(this);
        request = Volley.newRequestQueue(this);

    }


    @Override
    public void onClick(View view) {
        Contrasenia =  _etContrasenia.getText().toString();
        if(maya.accesoInternet() == 1){
            consultarWebServiceLogin(_etUsuario.getText().toString(), _etContrasenia.getText().toString());
        }else{
            maya.Toast("Debe estar conectado a una Red 4G o WiFi para poder continuar");
        }

    }

    private void consultarWebServiceLogin(String login, String contrasenia) {

        String URL ;
        URL = "http://192.168.1.10/ChuquiagoApp/app/models/login/ws_login.php?user="+login+"&password="+contrasenia;
        Log.d("URL LOGIN", URL);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("URI LOGIN ERROR", error+"");
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("usuario");
        JSONObject jsonObject= null;
        try {
            jsonObject = json.getJSONObject(0);
            if(jsonObject.optString("id_user").isEmpty() && jsonObject != null){
                maya.Toast("Revise el Login y Contraseña");
            }else{
                if(!jsonObject.optString("id_user").isEmpty()){
                    Intent m;
                    switch (Integer.parseInt(jsonObject.optString("id_rol"))){
                        case 2:
                           // maya.Toast("Bienvenido Docente: "+jsonObject.optString("nombre"));
                            guardarUsuario(Integer.parseInt(jsonObject.optString("id_user")),Integer.parseInt(jsonObject.optString("id_rol")),jsonObject.optString("rol"),jsonObject.optString("nombre")+" "+jsonObject.optString("ap_paterno")+" "+jsonObject.optString("ap_materno"),Integer.parseInt(jsonObject.optString("id_docente")));
                            m = new Intent(this,MenuDocenteActivity.class);
                            startActivity(m);
                            break;
                        case 3:
                            maya.Toast("Bienvenido : "+jsonObject.optString("nombre")+" Modulo Responsable no Implementado");
                            m = new Intent(this,MenuActivity.class);
                            startActivity(m);
                            break;
                        case 4:
                            maya.Toast("Bienvenido : "+jsonObject.optString("nombre")+" Modulo Estudiante no Implementado");
                            m = new Intent(this,MenuActivity.class);
                            startActivity(m);
                            break;
                        default:
                            break;
                    }
                    finish();
                }else{
                    maya.Toast("Contactese con el Administrador su Usuario tiene problemas de estado");
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
            maya.Toast("Revise el WS");
        }
    }

    private void guardarUsuario(int _id_usuario, int id_rol, String rol_nombre, String nombre_completo, int id_docente) {
        manejaBD =  new HandlerBasedeDatos(this);
        try{
            manejaBD.addUsuario(_id_usuario, id_rol, rol_nombre, nombre_completo, id_docente);
        }catch (Exception e){

            Log.d("CREATE","Error");
            e.printStackTrace();
        }finally {
            maya.Toast("Bienvenido...");
        }
    }
}
