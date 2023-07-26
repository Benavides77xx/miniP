/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesSteven;

import Clases.Persona;
import java.util.Date;

/**
 *
 * @author Steven Zhicay
 */
public class Comerciante extends Persona {

    private String id_comerciante;
    private int años_exp;
    private int num_ventas;
    private String cod_negocio;

    public Comerciante() {
        super();
    }

    public Comerciante(String id_comerciante, int años_exp, int num_ventas, String cod_negocio, String cedula_per, String nombre_per, String Apellido, int edad_per, String genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_comerciante = id_comerciante;
        this.años_exp = años_exp;
        this.num_ventas = num_ventas;
        this.cod_negocio = cod_negocio;
    }

    public String getId_comerciante() {
        return id_comerciante;
    }

    public void setId_comerciante(String id_comerciante) {
        this.id_comerciante = id_comerciante;
    }

    public int getAños_exp() {
        return años_exp;
    }

    public void setAños_exp(int años_exp) {
        this.años_exp = años_exp;
    }

    public int getNum_ventas() {
        return num_ventas;
    }

    public void setNum_ventas(int num_ventas) {
        this.num_ventas = num_ventas;
    }

    public String getCod_negocio() {
        return cod_negocio;
    }

    public void setCod_negocio(String cod_negocio) {
        this.cod_negocio = cod_negocio;
    }

    @Override
    public String toString() {
        return "Comerciante{" + "id_comerciante=" + id_comerciante + ", a\u00f1os_exp=" + años_exp + ", num_ventas=" + num_ventas + ", cod_negocio=" + cod_negocio + '}';
    }


}
