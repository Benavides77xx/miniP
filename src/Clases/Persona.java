/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author jose
 */
public class Persona {
    
    private String cedula_per;
    private String nombre_per;
    private String Apellido;
    private int edad_per;
    private String genero;
    private String celular_per;
    private Date fecha_nac;
    private String correo;
    private String codigo_tipo_sangre;
    private String codigo_pais;

    public Persona(String cedula_per, String nombre_per, String Apellido, int edad_per, String genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        this.cedula_per = cedula_per;
        this.nombre_per = nombre_per;
        this.Apellido = Apellido;
        this.edad_per = edad_per;
        this.genero = genero;
        this.celular_per = celular_per;
        this.fecha_nac = fecha_nac;
        this.correo = correo;
        this.codigo_tipo_sangre = codigo_tipo_sangre;
        this.codigo_pais = codigo_pais;
    }

    public Persona() {
    }

    public String getCedula_per() {
        return cedula_per;
    }

    public void setCedula_per(String cedula_per) {
        this.cedula_per = cedula_per;
    }

    public String getNombre_per() {
        return nombre_per;
    }

    public void setNombre_per(String nombre_per) {
        this.nombre_per = nombre_per;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad_per() {
        return edad_per;
    }

    public void setEdad_per(int edad_per) {
        this.edad_per = edad_per;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular_per() {
        return celular_per;
    }

    public void setCelular_per(String celular_per) {
        this.celular_per = celular_per;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo_tipo_sangre() {
        return codigo_tipo_sangre;
    }

    public void setCodigo_tipo_sangre(String codigo_tipo_sangre) {
        this.codigo_tipo_sangre = codigo_tipo_sangre;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula_per=" + cedula_per + ", nombre_per=" + nombre_per + ", Apellido=" + Apellido + ", edad_per=" + edad_per + ", genero=" + genero + ", celular_per=" + celular_per + ", fecha_nac=" + fecha_nac + ", correo=" + correo + ", codigo_tipo_sangre=" + codigo_tipo_sangre + ", codigo_pais=" + codigo_pais + '}';
    }

    
    
    
    
}
