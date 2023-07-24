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
public class Tipo_sangre {
    
    private String codigo_tipo_sangre;
    private String tipo_sangre;
    private int porcentaje_personas;

    public Tipo_sangre(String codigo_tipo_sangre, String tipo_sangre, int porcentaje_personas) {
        this.codigo_tipo_sangre = codigo_tipo_sangre;
        this.tipo_sangre = tipo_sangre;
        this.porcentaje_personas = porcentaje_personas;
    }

    public Tipo_sangre() {
    }

    public String getCodigo_tipo_sangre() {
        return codigo_tipo_sangre;
    }

    public void setCodigo_tipo_sangre(String codigo_tipo_sangre) {
        this.codigo_tipo_sangre = codigo_tipo_sangre;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public int getPorcentaje_personas() {
        return porcentaje_personas;
    }

    public void setPorcentaje_personas(int porcentaje_personas) {
        this.porcentaje_personas = porcentaje_personas;
    }

    @Override
    public String toString() {
        return "Tipo_sangre{" + "codigo_tipo_sangre=" + codigo_tipo_sangre + ", tipo_sangre=" + tipo_sangre + ", porcentaje_personas=" + porcentaje_personas + '}';
    }


    
}
