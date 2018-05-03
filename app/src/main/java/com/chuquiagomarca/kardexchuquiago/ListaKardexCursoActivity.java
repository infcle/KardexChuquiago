package com.chuquiagomarca.kardexchuquiago;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.chuquiagomarca.kardexchuquiago.Adaptadores.KardexCursosAdaptador;
import com.chuquiagomarca.kardexchuquiago.Maya.Maya;
import com.chuquiagomarca.kardexchuquiago.Objetos.Cursos;
import com.chuquiagomarca.kardexchuquiago.Objetos.Estudiantes;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListaKardexCursoActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private ListView _listKardexCursos;
    private KardexCursosAdaptador adapter;
    private Cursos itenCursos;
    private RequestQueue request;
    private JsonObjectRequest jsonObjectRequest;
    private Maya maya;
    private ProgressDialog progress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_kardex_curso);
        request = Volley.newRequestQueue(this);
        maya = new Maya(this);
        itenCursos = (Cursos) getIntent().getSerializableExtra("objectCurso");
        _listKardexCursos = findViewById(R.id.listkardesCursos);
        //adapter = new KardexCursosAdaptador(this,obtenerEstudiantes());
        //_listKardexCursos.setAdapter(adapter);
        obtenerEstudiantesCursos();
    }

    private void obtenerEstudiantesCursos() {
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
    private ArrayList<Estudiantes> obtenerEstudiantes(){
        ArrayList<Estudiantes> listEstudiante = new ArrayList<>();
        listEstudiante.add(new Estudiantes(6846341,"Luis Miguel","Mendoza","Ticona","varon","05/10/87","Z.Villa Victoria Calle Manuripi",1,0));
        listEstudiante.add(new Estudiantes(7894634,"Demi","Lovato","","mujer","05/10/87","Los Angeles",2,2));
        listEstudiante.add(new Estudiantes(3591678,"Luz Aimar","Ticona","Huanca","mujer","24/12/07","Villa Victoria",1,0));
        listEstudiante.add(new Estudiantes(7896431,"Carlos Daniel","Ticona","Huanca","varon","13/04/03","Z. Calle Manuripi",6,0));
        listEstudiante.add(new Estudiantes(1205486,"Milena","Quiñones","Vallejo","mujer","05/10/87","Irpavi",4,0));
        return  listEstudiante;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
