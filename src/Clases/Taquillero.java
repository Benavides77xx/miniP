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
public class Taquillero extends Persona {

    private String id_taquillero;
    private String cod_certificaciones;
    private String estatus_empleo;
    private double salario;
    private Date fecha_contratacion;
    private String recomendaciones;

    public Taquillero(String id_taquillero, String cod_certificaciones, String estatus_empleo, double salario, Date fecha_contratacion, String recomendaciones, String cedula_per, String nombre_per, String Apellido, int edad_per, String genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_taquillero = id_taquillero;
        this.cod_certificaciones = cod_certificaciones;
        this.estatus_empleo = estatus_empleo;
        this.salario = salario;
        this.fecha_contratacion = fecha_contratacion;
        this.recomendaciones = recomendaciones;
    }

    public Taquillero(String id_taquillero, String cod_certificaciones, String estatus_empleo, double salario, Date fecha_contratacion, String recomendaciones) {
        this.id_taquillero = id_taquillero;
        this.cod_certificaciones = cod_certificaciones;
        this.estatus_empleo = estatus_empleo;
        this.salario = salario;
        this.fecha_contratacion = fecha_contratacion;
        this.recomendaciones = recomendaciones;
    }

   
  
    public Taquillero() {
    }

    

    public String getId_taquillero() {
        return id_taquillero;
    }

    public void setId_taquillero(String id_taquillero) {
        this.id_taquillero = id_taquillero;
    }

    public String getCertificaciones() {
        return cod_certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.cod_certificaciones = certificaciones;
    }

    public String getEstatus_empleo() {
        return estatus_empleo;
    }

    public void setEstatus_empleo(String estatus_empleo) {
        this.estatus_empleo = estatus_empleo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    @Override
    public String toString() {
        return "Taquillero{" + "id_taquillero=" + id_taquillero + ", certificaciones=" + cod_certificaciones + ", estatus_empleo=" + estatus_empleo + ", salario=" + salario + ", fecha_contratacion=" + fecha_contratacion + ", recomendaciones=" + recomendaciones + '}';
    }
    
    
    

}
