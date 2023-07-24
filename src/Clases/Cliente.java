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
public class Cliente extends Persona {

    private String id_cliente;
    private String Habilidades;
    private String Intereses_personales;

    public Cliente(String id_cliente, String Habilidades, String Intereses_personales, String cedula_per, String nombre_per, String Apellido, int edad_per, char genero, String celular_per, Date fecha_nac, String correo, String codigo_tipo_sangre, String codigo_pais) {
        super(cedula_per, nombre_per, Apellido, edad_per, genero, celular_per, fecha_nac, correo, codigo_tipo_sangre, codigo_pais);
        this.id_cliente = id_cliente;
        this.Habilidades = Habilidades;
        this.Intereses_personales = Intereses_personales;
    }

    public Cliente(String id_cliente, String Habilidades, String Intereses_personales) {
        this.id_cliente = id_cliente;
        this.Habilidades = Habilidades;
        this.Intereses_personales = Intereses_personales;
    }

    public Cliente() {
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(String Habilidades) {
        this.Habilidades = Habilidades;
    }

    public String getIntereses_personales() {
        return Intereses_personales;
    }

    public void setIntereses_personales(String Intereses_personales) {
        this.Intereses_personales = Intereses_personales;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", Habilidades=" + Habilidades + ", Intereses_personales=" + Intereses_personales + '}';
    }

}
