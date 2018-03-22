package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button _btnIngresar;
    private EditText _etUsuario, _etContrasenia;
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

    }


    @Override
    public void onClick(View view) {
        Intent m = new Intent(this,MenuActivity.class);
        startActivity(m);
    }
}
