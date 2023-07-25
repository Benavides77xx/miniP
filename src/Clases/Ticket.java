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
public class Ticket {
    
    private String codigo_ticket;
    private double precio_ticket;
    private String restrccion;
    private String codigo_tipo_ticket;
    private String id_taquillero;

    public Ticket(String codigo_ticket, double precio_ticket, String restrccion, String codigo_tipo_ticket, String id_taquillero) {
        this.codigo_ticket = codigo_ticket;
        this.precio_ticket = precio_ticket;
        this.restrccion = restrccion;
        this.codigo_tipo_ticket = codigo_tipo_ticket;
        this.id_taquillero = id_taquillero;
    }
 
    public Ticket() {
    }

    public String getCodigo_ticket() {
        return codigo_ticket;
    }

    public void setCodigo_ticket(String codigo_ticket) {
        this.codigo_ticket = codigo_ticket;
    }

    public double getPrecio_ticket() {
        return precio_ticket;
    }

    public void setPrecio_ticket(double precio_ticket) {
        this.precio_ticket = precio_ticket;
    }

    public String getRestrccion() {
        return restrccion;
    }

    public void setRestrccion(String restrccion) {
        this.restrccion = restrccion;
    }

    public String getCodigo_tipo_ticket() {
        return codigo_tipo_ticket;
    }

    public void setCodigo_tipo_ticket(String codigo_tipo_ticket) {
        this.codigo_tipo_ticket = codigo_tipo_ticket;
    }

    public String getId_taquillero() {
        return id_taquillero;
    }

    public void setId_taquillero(String id_taquillero) {
        this.id_taquillero = id_taquillero;
    }

    @Override
    public String toString() {
        return "Ticket{" + "codigo_ticket=" + codigo_ticket + ", precio_ticket=" + precio_ticket + ", restrccion=" + restrccion + ", codigo_tipo_ticket=" + codigo_tipo_ticket + ", id_taquillero=" + id_taquillero + '}';
    }

    
}
