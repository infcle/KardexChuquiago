package com.chuquiagomarca.kardexchuquiago;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.chuquiagomarca.kardexchuquiago.Adaptadores.CursosDocenteAdatador;
import com.chuquiagomarca.kardexchuquiago.Maya.Maya;
import com.chuquiagomarca.kardexchuquiago.Objetos.Cursos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaCursosDocenteActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private ListView _listCursos;
    public  ArrayList<Cursos> listCurso;// = new ArrayList<>();
    private CursosDocenteAdatador adapter;
    private RequestQueue request;
    private JsonObjectRequest jsonObjectRequest;
    private Maya maya;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursos_docente);
        request = Volley.newRequestQueue(this);
        maya = new Maya(this);
        _listCursos = findViewById(R.id.listCursosDocente);
        obtenerCursos();

    }

    private void obtenerCursos() {
        progress=new ProgressDialog(this);
        progress.setMessage("Consultando cursos...");
        progress.show();
        progress.setCancelable(false);

        String URL ;
        URL = "http://192.168.1.10/ChuquiagoApp/app/models/login/ws_cursos_asignados.php?id_user="+maya.buscarId_User();
        Log.d("URL Cursos", URL);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, this, this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("Url Cursos", ""+error);
        maya.Toast("Acceso no encontrado Comuniquese con el administrador...");
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("curso");
        listCurso = new ArrayList<>();
        try {
            for (int i = 0 ; i < json.length() ; i++){

                JSONObject jsonObject= null;
                jsonObject = json.getJSONObject(i);
                //maya.Toast(jsonObject.optString("grado"));
                listCurso.add(new Cursos(Integer.parseInt(jsonObject.optString("id_curso")),jsonObject.optString("grado")+" "+jsonObject.optString("paralelo"),jsonObject.optString("grado"),jsonObject.optString("grado")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            progress.hide();
            adapter = new CursosDocenteAdatador(this,listCurso);
            _listCursos.setAdapter(adapter);
            _listCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent ec = new Intent(ListaCursosDocenteActivity.this, EstudiantesCursoActivity.class);
                    ec.putExtra("objectCurso",listCurso.get(i));
                    startActivity(ec);
                }
            });
        }
    }
}
