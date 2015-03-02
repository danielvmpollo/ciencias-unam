/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.unam.ciencias.model.Local;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

/**
 *
 * @author guillermorojas
 */

@ManagedBean
@SessionScoped
public class LocalController {
    
    private List<Local> locales;
    
    private Local local;
    
    
    @PostConstruct
    public void init(){
        locales=new ArrayList<>();
        this.local=new Local();
    }
    
    public void guardarLocal(){
        this.locales.add(local);
    }
    
    public void seleccion(PointSelectEvent event){
         LatLng latlng = event.getLatLng();
         this.local.setLatitud(latlng.getLat());
         this.local.setLongitud(latlng.getLng());
         
    }

    /***getter y setter **/
    
    public List<Local> getLocales() {
        return locales;
    }

    public void setLocales(List<Local> locales) {
        this.locales = locales;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    
    
}
