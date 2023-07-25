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
public class Tipo_ticket {
    
    private String codigo_tipo_ticket;
    private String tipo_ticket;
    private int capacidad;

    public Tipo_ticket(String codigo_tipo_ticket, String tipo_ticket, int capacidad) {
        this.codigo_tipo_ticket = codigo_tipo_ticket;
        this.tipo_ticket = tipo_ticket;
        this.capacidad = capacidad;
    }

    public Tipo_ticket() {
    }

    public String getCodigo_tipo_ticket() {
        return codigo_tipo_ticket;
    }

    public void setCodigo_tipo_ticket(String codigo_tipo_ticket) {
        this.codigo_tipo_ticket = codigo_tipo_ticket;
    }

    public String getTipo_ticket() {
        return tipo_ticket;
    }

    public void setTipo_ticket(String tipo_ticket) {
        this.tipo_ticket = tipo_ticket;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Tipo_ticket{" + "codigo_tipo_ticket=" + codigo_tipo_ticket + ", tipo_ticket=" + tipo_ticket + ", capacidad=" + capacidad + '}';
    }
    
    
    
}
