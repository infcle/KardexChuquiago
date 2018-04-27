package com.chuquiagomarca.kardexchuquiago.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.chuquiagomarca.kardexchuquiago.Objetos.Cursos;
import com.chuquiagomarca.kardexchuquiago.R;

import java.util.ArrayList;

/**
 * Created by Lyanna on 27/04/2018.
 */

public class CursosDocenteAdatador extends BaseAdapter {
    private Context context;
    private ArrayList<Cursos> listCursos;

    public CursosDocenteAdatador(Context context, ArrayList<Cursos> listCursos) {
        this.context = context;
        this.listCursos = listCursos;
    }

    @Override
    public int getCount() {
        return listCursos.size();
    }

    @Override
    public Object getItem(int i) {
        return listCursos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Cursos cursos = (Cursos) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_cursos_docente, null);
        ImageView _ivImagen  = view.findViewById(R.id.iv_Imagend);
        TextView  _tvCurso   = view.findViewById(R.id.tv_Cursod);
        TextView  _tvMateria = view.findViewById(R.id.tv_Materiad);
        _ivImagen.setImageResource(R.drawable.seniorita);
        _tvCurso.setText("Curso   : "+cursos.getCurso());
        _tvMateria.setText("Materia : "+cursos.getMateria());
        return view;
    }
}
