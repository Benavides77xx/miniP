/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;



/**
 *
 * @author Asus
 */
public class Detalle_factura {
    
 private String cod_det_fact;
 private int cantidad_ticket;
 private double sub_total;
 private String codigo_ticket;
 private String codigo_enc_fact;

    public Detalle_factura(String cod_det_fact, int cantidad_ticket, double sub_total, String codigo_ticket, String codigo_enc_fact) {
        this.cod_det_fact = cod_det_fact;
        this.cantidad_ticket = cantidad_ticket;
        this.sub_total = sub_total;
        this.codigo_ticket = codigo_ticket;
        this.codigo_enc_fact = codigo_enc_fact;
    }

    public Detalle_factura() {
    }

    public String getCod_det_fact() {
        return cod_det_fact;
    }

    public void setCod_det_fact(String cod_det_fact) {
        this.cod_det_fact = cod_det_fact;
    }

    public int getCantidad_ticket() {
        return cantidad_ticket;
    }

    public void setCantidad_ticket(int cantidad_ticket) {
        this.cantidad_ticket = cantidad_ticket;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public String getCodigo_ticket() {
        return codigo_ticket;
    }

    public void setCodigo_ticket(String codigo_ticket) {
        this.codigo_ticket = codigo_ticket;
    }

    public String getCodigo_enc_fact() {
        return codigo_enc_fact;
    }

    public void setCodigo_enc_fact(String codigo_enc_fact) {
        this.codigo_enc_fact = codigo_enc_fact;
    }

    @Override
    public String toString() {
        return "Detalle_factura{" + "cod_det_fact=" + cod_det_fact + ", cantidad_ticket=" + cantidad_ticket + ", sub_total=" + sub_total + ", codigo_ticket=" + codigo_ticket + ", codigo_enc_fact=" + codigo_enc_fact + '}';
    }

  


}
