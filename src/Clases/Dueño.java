/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Dueño extends Persona {
    
    private String id_dueño;
    private String Historial_propiedad;
    private int Años_experiencia;
    private String Habilidades_finacieras;

    public Dueño(String id_dueño, String Historial_propiedad, int Años_experiencia, String Habilidades_finacieras, String cedula_per, String nombre_per, String Apellido, int edad_per, char genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_dueño = id_dueño;
        this.Historial_propiedad = Historial_propiedad;
        this.Años_experiencia = Años_experiencia;
        this.Habilidades_finacieras = Habilidades_finacieras;
    }

    public Dueño(String id_dueño, String Historial_propiedad, int Años_experiencia, String Habilidades_finacieras) {
        this.id_dueño = id_dueño;
        this.Historial_propiedad = Historial_propiedad;
        this.Años_experiencia = Años_experiencia;
        this.Habilidades_finacieras = Habilidades_finacieras;
    }

    public Dueño() {
    }

    public String getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(String id_dueño) {
        this.id_dueño = id_dueño;
    }

    public String getHistorial_propiedad() {
        return Historial_propiedad;
    }

    public void setHistorial_propiedad(String Historial_propiedad) {
        this.Historial_propiedad = Historial_propiedad;
    }

    public int getAños_experiencia() {
        return Años_experiencia;
    }

    public void setAños_experiencia(int Años_experiencia) {
        this.Años_experiencia = Años_experiencia;
    }

    public String getHabilidades_finacieras() {
        return Habilidades_finacieras;
    }

    public void setHabilidades_finacieras(String Habilidades_finacieras) {
        this.Habilidades_finacieras = Habilidades_finacieras;
    }

    @Override
    public String toString() {
        return "Due\u00f1o{" + "id_due\u00f1o=" + id_dueño + ", Historial_propiedad=" + Historial_propiedad + ", A\u00f1os_experiencia=" + Años_experiencia + ", Habilidades_finacieras=" + Habilidades_finacieras + '}';
    }
            
  
    
}
