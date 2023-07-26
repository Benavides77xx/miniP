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
public class Especialidad {

    private String cod_especialidad;
    private String nombre_esp;
    private String descripcion;

    public Especialidad(String cod_especialidad, String nombre_esp, String descripcion) {
        this.cod_especialidad = cod_especialidad;
        this.nombre_esp = nombre_esp;
        this.descripcion = descripcion;
    }

    public Especialidad() {
    }

    public String getCod_especialidad() {
        return cod_especialidad;
    }

    public void setCod_especialidad(String cod_especialidad) {
        this.cod_especialidad = cod_especialidad;
    }

    public String getNombre_esp() {
        return nombre_esp;
    }

    public void setNombre_esp(String nombre_esp) {
        this.nombre_esp = nombre_esp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "cod_especialidad=" + cod_especialidad + ", nombre_esp=" + nombre_esp + ", descripcion=" + descripcion + '}';
    }
    
    

}
