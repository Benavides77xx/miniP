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
public class Comerciante {

    private String id_comerciante;
    private int años_exp;
    private int num_ventas;
    private String cedula_persona;

    public Comerciante() {
    }

    public Comerciante(String id_comerciante, int años_exp, int num_ventas, String cedula_persona) {
        this.id_comerciante = id_comerciante;
        this.años_exp = años_exp;
        this.num_ventas = num_ventas;
        this.cedula_persona = cedula_persona;
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

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
    }

    @Override
    public String toString() {
        return "Comerciante{" + "id_comerciante=" + id_comerciante + ", a\u00f1os_exp=" + años_exp + ", num_ventas=" + num_ventas + ", cedula_persona=" + cedula_persona + '}';
    }

}
