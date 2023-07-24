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
public class Mantenimiento {
    
    private String codigo_mantenimiento;
    private String descripcion_mantenimiento;
    private Date Fecha_mantenimiento;
    private String id_tecnico;
    private String codigo_juego;

    public Mantenimiento(String codigo_mantenimiento, String descripcion_mantenimiento, Date Fecha_mantenimiento, String id_tecnico, String codigo_juego) {
        this.codigo_mantenimiento = codigo_mantenimiento;
        this.descripcion_mantenimiento = descripcion_mantenimiento;
        this.Fecha_mantenimiento = Fecha_mantenimiento;
        this.id_tecnico = id_tecnico;
        this.codigo_juego = codigo_juego;
    }

    public Mantenimiento() {
    }

    public String getCodigo_mantenimiento() {
        return codigo_mantenimiento;
    }

    public void setCodigo_mantenimiento(String codigo_mantenimiento) {
        this.codigo_mantenimiento = codigo_mantenimiento;
    }

    public String getDescripcion_mantenimiento() {
        return descripcion_mantenimiento;
    }

    public void setDescripcion_mantenimiento(String descripcion_mantenimiento) {
        this.descripcion_mantenimiento = descripcion_mantenimiento;
    }

    public Date getFecha_mantenimiento() {
        return Fecha_mantenimiento;
    }

    public void setFecha_mantenimiento(Date Fecha_mantenimiento) {
        this.Fecha_mantenimiento = Fecha_mantenimiento;
    }

    public String getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getCodigo_juego() {
        return codigo_juego;
    }

    public void setCodigo_juego(String codigo_juego) {
        this.codigo_juego = codigo_juego;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "codigo_mantenimiento=" + codigo_mantenimiento + ", descripcion_mantenimiento=" + descripcion_mantenimiento + ", Fecha_mantenimiento=" + Fecha_mantenimiento + ", id_tecnico=" + id_tecnico + ", codigo_juego=" + codigo_juego + '}';
    }
    
    
}
