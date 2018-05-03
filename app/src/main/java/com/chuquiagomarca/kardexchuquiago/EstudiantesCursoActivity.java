package com.chuquiagomarca.kardexchuquiago;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.chuquiagomarca.kardexchuquiago.Objetos.Cursos;

import org.json.JSONObject;

public class EstudiantesCursoActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private Cursos itenCursos;
    private TextView _tvCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_curso);
        itenCursos = (Cursos) getIntent().getSerializableExtra("objectCurso");
        _tvCurso   = findViewById(R.id.tv_curso);
        _tvCurso.setText(itenCursos.getMateria()+" - "+itenCursos.getGrado());
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
