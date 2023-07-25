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
public class Habilidades {
    private String cod_habilidades;
    private String habilidad;
    private String descripcion;

    public Habilidades(String cod_habilidades, String habilidad, String descripcion) {
        this.cod_habilidades = cod_habilidades;
        this.habilidad = habilidad;
        this.descripcion = descripcion;
    }

    public Habilidades() {
    }

    public String getCod_habilidades() {
        return cod_habilidades;
    }

    public void setCod_habilidades(String cod_habilidades) {
        this.cod_habilidades = cod_habilidades;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidades{" + "cod_habilidades=" + cod_habilidades + ", habilidad=" + habilidad + ", descripcion=" + descripcion + '}';
    }
    
}
