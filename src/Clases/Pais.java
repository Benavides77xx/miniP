/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jose
 */
public class Pais {
    
    private String codigo_pais;
    private String nombre_pais;
    private double poblacion;

    public Pais(String codigo_pais, String nombre_pais, double poblacion) {
        this.codigo_pais = codigo_pais;
        this.nombre_pais = nombre_pais;
        this.poblacion = poblacion;
    }

    public Pais() {
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public double getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(double poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Pais{" + "codigo_pais=" + codigo_pais + ", nombre_pais=" + nombre_pais + ", poblacion=" + poblacion + '}';
    }
    
    
}
