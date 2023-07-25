/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Tecnico extends Persona {
    
    private String id_tecnico;
    private String nivel_estudio_tec;
    private int a_experiencia_tec;
    private String referencias_tec;

    public Tecnico(String id_tecnico, String nivel_estudio_tec, int a_experiencia_tec, String referencias_tec, String cedula_per, String nombre_per, String Apellido, int edad_per, String genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_tecnico = id_tecnico;
        this.nivel_estudio_tec = nivel_estudio_tec;
        this.a_experiencia_tec = a_experiencia_tec;
        this.referencias_tec = referencias_tec;
    }

    public Tecnico() {
    }

    public String getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getNivel_estudio_tec() {
        return nivel_estudio_tec;
    }

    public void setNivel_estudio_tec(String nivel_estudio_tec) {
        this.nivel_estudio_tec = nivel_estudio_tec;
    }

    public int getA_experiencia_tec() {
        return a_experiencia_tec;
    }

    public void setA_experiencia_tec(int a_experiencia_tec) {
        this.a_experiencia_tec = a_experiencia_tec;
    }

    public String getReferencias_tec() {
        return referencias_tec;
    }

    public void setReferencias_tec(String referencias_tec) {
        this.referencias_tec = referencias_tec;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "id_tecnico=" + id_tecnico + ", nivel_estudio_tec=" + nivel_estudio_tec + ", a_experiencia_tec=" + a_experiencia_tec + ", referencias_tec=" + referencias_tec + '}';
    }

  
    
}
