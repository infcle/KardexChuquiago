package com.chuquiagomarca.kardexchuquiago.Objetos;

import java.io.Serializable;

/**
 * Created by Lyanna on 27/04/2018.
 */

public class Cursos implements Serializable {
    private int id_curso;
    private String curso, materia, grado;

    public Cursos(int id_curso, String curso, String materia, String grado) {
        this.id_curso = id_curso;
        this.curso = curso;
        this.materia = materia;
        this.grado = grado;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
