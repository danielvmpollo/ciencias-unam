/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.model;

/**
 *
 * @author guillermorojas
 */
public class Menu {
    
    
    private String categoria;
    
    private String nombre;
    
    private String descripcion;
    
     private Double rangoInferior;
     
     private Double rangoSuperior;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public Double getRangoInferior() {
        return rangoInferior;
    }

    public void setRangoInferior(Double rangoInferior) {
        this.rangoInferior = rangoInferior;
    }

    public Double getRangoSuperior() {
        return rangoSuperior;
    }

    public void setRangoSuperior(Double rangoSuperior) {
        this.rangoSuperior = rangoSuperior;
    }
     
     
     
    
}
