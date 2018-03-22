package com.chuquiagomarca.kardexchuquiago.Objetos;

/**
 * Created by Lyanna on 22/03/2018.
 */

public class Estudiantes {

    private int id_rude;
    private String nombre, paterno, materno, sexo, fecha_nac, domicilio;
    private int id_estado, id_user;

    public Estudiantes(int id_rude, String nombre, String paterno, String materno, String sexo, String fecha_nac, String domicilio, int id_estado, int id_user) {
        this.id_rude = id_rude;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.domicilio = domicilio;
        this.id_estado = id_estado;
        this.id_user = id_user;
    }

    public int getId_rude() {
        return id_rude;
    }

    public void setId_rude(int id_rude) {
        this.id_rude = id_rude;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
