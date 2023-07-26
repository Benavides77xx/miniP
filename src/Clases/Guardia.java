/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Guardia extends Persona {

    private String id_guardia;
    private int años_expreriencia;
    private boolean disponibilidad;
    private String cod_especialidad;

    public Guardia(String id_guardia, int años_expreriencia, boolean disponibilidad, String cod_especialidad, String cedula_per, String nombre_per, String Apellido, int edad_per, String genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_guardia = id_guardia;
        this.años_expreriencia = años_expreriencia;
        this.disponibilidad = disponibilidad;
        this.cod_especialidad = cod_especialidad;
    }

    public Guardia(String id_guardia, int años_expreriencia, boolean disponibilidad, String cod_especialidad) {
        this.id_guardia = id_guardia;
        this.años_expreriencia = años_expreriencia;
        this.disponibilidad = disponibilidad;
        this.cod_especialidad = cod_especialidad;
    }

    public Guardia() {
    }

    public String getId_guardia() {
        return id_guardia;
    }

    public void setId_guardia(String id_guardia) {
        this.id_guardia = id_guardia;
    }

    public int getAños_expreriencia() {
        return años_expreriencia;
    }

    public void setAños_expreriencia(int años_expreriencia) {
        this.años_expreriencia = años_expreriencia;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getCod_especialidad() {
        return cod_especialidad;
    }

    public void setCod_especialidad(String cod_especialidad) {
        this.cod_especialidad = cod_especialidad;
    }

    @Override
    public String toString() {
        return "Guardia{" + "id_guardia=" + id_guardia + ", a\u00f1os_expreriencia=" + años_expreriencia + ", disponibilidad=" + disponibilidad + ", cod_especialidad=" + cod_especialidad + '}';
    }
 

}
