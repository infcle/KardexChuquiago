package com.chuquiagomarca.kardexchuquiago.Adaptadores;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chuquiagomarca.kardexchuquiago.R;

/**
 * Created by Lyanna on 07/03/2018.
 */

public class SliderAdaptador extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public int [] slide_imagen     = {R.drawable.slideuno,R.drawable.slidedos,R.drawable.slidetres};
    public String [] slide_titulos = {"CONSULTA DE KARDEX","CITACIONES","ACTIVIDADES DEL COLEGIO"};
    public String [] slide_textos  = {"Aqui va una descripcion de lo que se hara en kardex","Caracteristicas de las citaciones que tendra el padre de fanilia","Actividades que tendra el colegio o curso dependiendo del visto bueno del director o profesor"};

    public SliderAdaptador(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return slide_titulos.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImage = view.findViewById(R.id.slide_imagen);
        TextView slideTitulo  = view.findViewById(R.id.slide_titulo);
        TextView slideTexto  = view.findViewById(R.id.slide_texto);

        slideImage.setImageResource(slide_imagen[position]);
        slideTitulo.setText(slide_titulos[position]);
        slideTexto.setText(slide_textos[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
