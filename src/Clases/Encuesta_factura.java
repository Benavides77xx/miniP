/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Encuesta_factura {
    private String Codigo_enc_fact;
    private Date Fecha;
    private double total;
    private String id_cliente;

    public Encuesta_factura() {
    }

    public Encuesta_factura(String Codigo_enc_fact, Date Fecha, double total, String id_cliente) {
        this.Codigo_enc_fact = Codigo_enc_fact;
        this.Fecha = Fecha;
        this.total = total;
        this.id_cliente = id_cliente;
    }

    public String getCodigo_enc_fact() {
        return Codigo_enc_fact;
    }

    public void setCodigo_enc_fact(String Codigo_enc_fact) {
        this.Codigo_enc_fact = Codigo_enc_fact;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Encuesta_factura{" + "Codigo_enc_fact=" + Codigo_enc_fact + ", Fecha=" + Fecha + ", total=" + total + ", id_cliente=" + id_cliente + '}';
    }


    
}
