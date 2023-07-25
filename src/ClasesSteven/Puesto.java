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
public class Puesto {

    private String cod_puesto;
    private String nombre;
    private String descripcion;
    private String tamaño;
    private String horario_laboral;
    private String id_comerciante;

    public Puesto() {
    }

    public Puesto(String cod_puesto, String nombre, String descripcion, String tamaño, String horario_laboral, String id_comerciante) {
        this.cod_puesto = cod_puesto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamaño = tamaño;
        this.horario_laboral = horario_laboral;
        this.id_comerciante = id_comerciante;
    }

    public String getCod_puesto() {
        return cod_puesto;
    }

    public void setCod_puesto(String cod_puesto) {
        this.cod_puesto = cod_puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getHorario_laboral() {
        return horario_laboral;
    }

    public void setHorario_laboral(String horario_laboral) {
        this.horario_laboral = horario_laboral;
    }

    public String getId_comerciante() {
        return id_comerciante;
    }

    public void setId_comerciante(String id_comerciante) {
        this.id_comerciante = id_comerciante;
    }

    @Override
    public String toString() {
        return "Puesto{" + "cod_puesto=" + cod_puesto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tama\u00f1o=" + tamaño + ", horario_laboral=" + horario_laboral + ", id_comerciante=" + id_comerciante + '}';
    }

}
