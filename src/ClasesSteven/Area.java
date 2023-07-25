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
public class Area {

    private String cod_area;
    private String nombre;
    private String tamaño;
    private int capacidad;
    private boolean disponibilida;
    private String descripcion;
    private String id_guardia;
    private String cod_puesto;

    public Area() {
    }

    public Area(String cod_area, String nombre, String tamaño, int capacidad, boolean disponibilida, String descripcion, String id_guardia, String cod_puesto) {
        this.cod_area = cod_area;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.capacidad = capacidad;
        this.disponibilida = disponibilida;
        this.descripcion = descripcion;
        this.id_guardia = id_guardia;
        this.cod_puesto = cod_puesto;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponibilida() {
        return disponibilida;
    }

    public void setDisponibilida(boolean disponibilida) {
        this.disponibilida = disponibilida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_guardia() {
        return id_guardia;
    }

    public void setId_guardia(String id_guardia) {
        this.id_guardia = id_guardia;
    }

    public String getCod_puesto() {
        return cod_puesto;
    }

    public void setCod_puesto(String cod_puesto) {
        this.cod_puesto = cod_puesto;
    }

    @Override
    public String toString() {
        return "Area{" + "cod_area=" + cod_area + ", nombre=" + nombre + ", tama\u00f1o=" + tamaño + ", capacidad=" + capacidad + ", disponibilida=" + disponibilida + ", descripcion=" + descripcion + ", id_guardia=" + id_guardia + ", cod_puesto=" + cod_puesto + '}';
    }

}
