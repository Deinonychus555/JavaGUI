/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo;

import javax.swing.ImageIcon;

/**
 *
 * @author Javier
 */
public class Alumno {
    
    ImageIcon imagen = new ImageIcon(getClass().getResource("/img/carnet_prueba.png"));
    String nombre;
    String apellidos;
    String telefono;
    String direccion;
    String observaciones = "No hay ninguna observación.";
    int[] fallos = new int[15];

    public Alumno(String nombre, String apellidos, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        for(int i = 0; i<15; i++){
            fallos[i] = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
     public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = new ImageIcon(getClass().getResource(imagen));
    }

    public int[] getFallos() {
        return fallos;
    }

    public void setFallos(int posicion, int fallos) {
        this.fallos[posicion] = fallos;
    }
}
