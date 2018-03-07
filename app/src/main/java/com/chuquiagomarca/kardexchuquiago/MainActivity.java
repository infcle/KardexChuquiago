package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView _ivLogo, _ivBolivia;
    Animation fromLogo, fromBolivia;
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
        setContentView(R.layout.activity_main);
        _ivLogo     = findViewById(R.id.iv_logo);
        _ivBolivia  = findViewById(R.id.iv_bolivia);
        fromLogo    = AnimationUtils.loadAnimation(this, R.anim.fromlogo);
        fromBolivia = AnimationUtils.loadAnimation(this, R.anim.frombolivia);
        _ivLogo.setAnimation(fromLogo);
        _ivBolivia.setAnimation(fromBolivia);

        //iniciamos el tiempo que le daremos a la animacion
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2500);
                }catch (InterruptedException er){
                    er.printStackTrace();
                }finally {
                    Intent i = new Intent(getApplicationContext(), InicioActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
