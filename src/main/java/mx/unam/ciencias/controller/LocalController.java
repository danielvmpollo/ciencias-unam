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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author guillermorojas
 */

@ManagedBean
@SessionScoped
public class LocalController {
    
    private List<Local> locales;
    
    private Local local;
    
    private MapModel simpleModel;//
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel(); //
        locales=new ArrayList<>();
        this.local=new Local();
    }
    
    public void guardarLocal(){
        
        LatLng coord = new LatLng(local.getLatitud(), local.getLongitud()); //
        
        simpleModel.addOverlay(new Marker(coord, local.getNombre()));//
        
        this.locales.add(local);
        this.local=new Local();
    }
    
    public void seleccion(PointSelectEvent event){
         LatLng latlng = event.getLatLng();
         this.local.setLatitud(latlng.getLat());
         this.local.setLongitud(latlng.getLng());
         
    }

    /***getter y setter
     * @return  **/
    
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

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }
    
    
    
}
