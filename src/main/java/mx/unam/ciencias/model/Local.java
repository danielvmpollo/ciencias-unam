/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author guillermorojas
 */
public class Local implements Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private Double latitud;
    
    private Double longitud;
     
    private Double rangoInferior;
     
    private Double rangoSuperior;
     
    private Menu recomendacion;
     
    private List<Menu> menu;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Menu getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Menu recomendacion) {
        this.recomendacion = recomendacion;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
     
     
     
    
}
