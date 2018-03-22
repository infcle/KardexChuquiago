package com.chuquiagomarca.kardexchuquiago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chuquiagomarca.kardexchuquiago.Adaptadores.KardexCursosAdaptador;
import com.chuquiagomarca.kardexchuquiago.Objetos.Estudiantes;

import java.util.ArrayList;

public class ListaKardexCursoActivity extends AppCompatActivity {

    private ListView _listKardexCursos;
    private KardexCursosAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_kardex_curso);

        _listKardexCursos = findViewById(R.id.listkardesCursos);
        adapter = new KardexCursosAdaptador(this,obtenerEstudiantes());
        _listKardexCursos.setAdapter(adapter);
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
}
