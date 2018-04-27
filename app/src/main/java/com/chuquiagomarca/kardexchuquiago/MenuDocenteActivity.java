package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chuquiagomarca.kardexchuquiago.Maya.Maya;

public class MenuDocenteActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView _tvNombreSesion;
    private Button   _btnCursos;
    private Maya     maya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_docente);
        _tvNombreSesion = findViewById(R.id.tv_nombreSesion);
        _btnCursos      = findViewById(R.id.btn_Cursos);
        _btnCursos.setOnClickListener(this);
        maya = new Maya(this);
        _tvNombreSesion.setText("Docente : "+maya.buscarNombreUsuario());
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_Cursos){
            Intent lc = new Intent(this, ListaCursosDocenteActivity.class);
            startActivity(lc);
            finish();
        }

    }
}
