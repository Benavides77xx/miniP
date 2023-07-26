/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesSteven;

/**
 *
 * @author Steven Zhicay
 */
public class Negocio {

    private String cod_negocio;
    private String tipo_negocio;
    private String descripcion;

    public Negocio() {
    }

    public Negocio(String cod_negocio, String tipo_negocio, String descripcion) {
        this.cod_negocio = cod_negocio;
        this.tipo_negocio = tipo_negocio;
        this.descripcion = descripcion;
    }

    public String getCod_negocio() {
        return cod_negocio;
    }

    public void setCod_negocio(String cod_negocio) {
        this.cod_negocio = cod_negocio;
    }

    public String getTipo_negocio() {
        return tipo_negocio;
    }

    public void setTipo_negocio(String tipo_negocio) {
        this.tipo_negocio = tipo_negocio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Negocio{" + "cod_negocio=" + cod_negocio + ", tipo_negocio=" + tipo_negocio + ", descripcion=" + descripcion + '}';
    }

}
