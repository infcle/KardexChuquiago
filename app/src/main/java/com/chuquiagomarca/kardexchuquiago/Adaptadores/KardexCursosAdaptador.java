package com.chuquiagomarca.kardexchuquiago.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chuquiagomarca.kardexchuquiago.Objetos.Estudiantes;
import com.chuquiagomarca.kardexchuquiago.R;

import java.util.ArrayList;

/**
 * Created by Lyanna on 22/03/2018.
 */

public class KardexCursosAdaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Estudiantes> listEstudiantes;

    public KardexCursosAdaptador(Context context, ArrayList<Estudiantes> listEstudiantes) {
        this.context = context;
        this.listEstudiantes = listEstudiantes;
    }

    @Override
    public int getCount() {
        return listEstudiantes.size();
    }

    @Override
    public Object getItem(int i) {
        return listEstudiantes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Estudiantes estudiantes = (Estudiantes) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_kardex_curso, null);
        ImageView _ivFoto = view.findViewById(R.id.iv_foto);
        TextView  _tvNombreCompleto = view.findViewById(R.id.tv_NombreCompleto);
        TextView  _tvCurso = view.findViewById(R.id.tv_Curso);

        if(estudiantes.getSexo().equals("varon")){
            _ivFoto.setImageResource(R.drawable.joven);
        }else if(estudiantes.getSexo().equals("mujer")){
            _ivFoto.setImageResource(R.drawable.seniorita);
        }

        _tvNombreCompleto.setText(estudiantes.getNombre()+" "+estudiantes.getPaterno()+" "+estudiantes.getMaterno());
        _tvCurso.setText("Curso : "+estudiantes.getId_rude());


        return view;
    }
}
