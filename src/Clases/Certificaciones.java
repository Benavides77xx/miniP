/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Lenovo
 */
public class Certificaciones {
    
    private String cod_certificaciones;
    private String certificacion;
    private String descripcion;

    public Certificaciones(String cod_certificaciones, String certificacion, String descripcion) {
        this.cod_certificaciones = cod_certificaciones;
        this.certificacion = certificacion;
        this.descripcion = descripcion;
    }

    public Certificaciones() {
    }

    public String getCod_certificaciones() {
        return cod_certificaciones;
    }

    public void setCod_certificaciones(String cod_certificaciones) {
        this.cod_certificaciones = cod_certificaciones;
    }

    public String getCertifiacion() {
        return certificacion;
    }

    public void setCertifiacion(String certifiacion) {
        this.certificacion = certifiacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Certificaciones{" + "cod_certificaciones=" + cod_certificaciones + ", certifiacion=" + certificacion + ", descripcion=" + descripcion + '}';
    }

    
}
