package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button _btnKardexCursos, _btnConfiguraciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        _btnKardexCursos    = findViewById(R.id.btn_KardexCursos);
        _btnConfiguraciones = findViewById(R.id.btn_Configuraciones);
        _btnKardexCursos.setOnClickListener(this);
        _btnConfiguraciones.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_KardexCursos){
            Intent kc = new Intent(this, ListaKardexCursoActivity.class);
            startActivity(kc);
        }

        if(view.getId() == R.id.btn_Configuraciones){

        }
    }
}
