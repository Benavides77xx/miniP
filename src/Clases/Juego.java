/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author jose
 */
public class Juego {
    
    private String codigo_juego;
    private String descripcion;
    private String nombre_juego;
    private Date año_creacion;
    private int capacidad;
    private double duracion;
    private String id_dueño;

    public Juego(String codigo_juego, String descripcion, String nombre_juego, Date año_creacion, int capacidad, double duracion, String id_dueño) {
        this.codigo_juego = codigo_juego;
        this.descripcion = descripcion;
        this.nombre_juego = nombre_juego;
        this.año_creacion = año_creacion;
        this.capacidad = capacidad;
        this.duracion = duracion;
        this.id_dueño = id_dueño;
    }

    public Juego() {
    }

    public String getCodigo_juego() {
        return codigo_juego;
    }

    public void setCodigo_juego(String codigo_juego) {
        this.codigo_juego = codigo_juego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_juego() {
        return nombre_juego;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego = nombre_juego;
    }

    public Date getAño_creacion() {
        return año_creacion;
    }

    public void setAño_creacion(Date año_creacion) {
        this.año_creacion = año_creacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(String id_dueño) {
        this.id_dueño = id_dueño;
    }

    @Override
    public String toString() {
        return "Juego{" + "codigo_juego=" + codigo_juego + ", descripcion=" + descripcion + ", nombre_juego=" + nombre_juego + ", a\u00f1o_creacion=" + año_creacion + ", capacidad=" + capacidad + ", duracion=" + duracion + ", id_due\u00f1o=" + id_dueño + '}';
    }

}
