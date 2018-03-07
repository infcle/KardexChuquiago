package com.chuquiagomarca.kardexchuquiago;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chuquiagomarca.kardexchuquiago.Adaptadores.SliderAdaptador;

public class SlideActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager _vpCaracteristicas;
    private LinearLayout _lyAcciones;
    private SliderAdaptador sliderAdaptador;
    private TextView[] acciones;
    private Button _btnIngresar;

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
        setContentView(R.layout.activity_slide);
        _vpCaracteristicas = findViewById(R.id.vp_caracteristicas);
        _lyAcciones        = findViewById(R.id.ly_acciones);
        sliderAdaptador = new SliderAdaptador(this);
        _vpCaracteristicas.setAdapter(sliderAdaptador);
        addAccionesIndicator(0);
        _vpCaracteristicas.addOnPageChangeListener(viewListener);
        _btnIngresar = findViewById(R.id.btnIngresar);
        _btnIngresar.setOnClickListener(this);
    }

    public void addAccionesIndicator(int position){
        acciones = new TextView[3];
        _lyAcciones.removeAllViews();
        for (int i = 0; i < acciones.length ; i++){
            acciones[i] = new TextView(this);
            acciones[i].setText(Html.fromHtml("&#8226;"));
            acciones[i].setTextSize(35);
            acciones[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            _lyAcciones.addView(acciones[i]);
        }

        if (acciones.length > 0){
            acciones[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addAccionesIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,InicioActivity.class);
        startActivity(i);
        finish();
    }
}
