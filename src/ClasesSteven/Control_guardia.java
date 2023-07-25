/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesSteven;

import java.util.Date;

/**
 *
 * @author Steven Zhicay
 */
public class Control_guardia {
    private String cod_control_guardia;
    private Date fecha;
    private String observaciones;
    private String id_guardia;
    private String cod_area;

    public Control_guardia() {
    }

    public Control_guardia(String cod_control_guardia, Date fecha, String observaciones, String id_guardia, String cod_area) {
        this.cod_control_guardia = cod_control_guardia;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.id_guardia = id_guardia;
        this.cod_area = cod_area;
    }

    public String getCod_control_guardia() {
        return cod_control_guardia;
    }

    public void setCod_control_guardia(String cod_control_guardia) {
        this.cod_control_guardia = cod_control_guardia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId_guardia() {
        return id_guardia;
    }

    public void setId_guardia(String id_guardia) {
        this.id_guardia = id_guardia;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    @Override
    public String toString() {
        return "Control_guardia{" + "cod_control_guardia=" + cod_control_guardia + ", fecha=" + fecha + ", observaciones=" + observaciones + ", id_guardia=" + id_guardia + ", cod_area=" + cod_area + '}';
    }
    
}
