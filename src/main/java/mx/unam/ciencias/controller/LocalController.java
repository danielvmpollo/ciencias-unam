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
import mx.unam.ciencias.model.Menu;
import mx.unam.ciencias.service.LocalService;
import mx.unam.ciencias.service.impl.LocalServiceImpl;
import org.primefaces.event.map.OverlaySelectEvent;
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
    /********************Comunicacion con la capa de servicio*************/
    private LocalService localService;

    /******************Variables usadas en la vista ********************/
    private List<Local> locales;
    private Local local;
    private Menu menu;
    private MapModel simpleModel; // es usado en la vista del ver locales

    @PostConstruct
    public void init(){
        localService=LocalServiceImpl.getInstance();
        locales=localService.findAll();
        
        simpleModel = new DefaultMapModel(); 
        
        this.local=new Local();
        this.local.setId(this.local.hashCode());
        this.menu=new Menu();
        this.local.setMenu(new ArrayList<Menu>());//se agrega la lista del menu
    
        for(Local l:this.locales){
            LatLng coord = new LatLng(l.getLatitud(), l.getLongitud()); 
            simpleModel.addOverlay(new Marker(coord, l.getNombre()));
        }
    }
    
    public void guardarMenu(){
        this.local.getMenu().add(menu);
        this.menu=new Menu();
    }
    
    public void guardarLocal(){
        LatLng coord = new LatLng(local.getLatitud(), local.getLongitud()); 
        simpleModel.addOverlay(new Marker(coord, local.getNombre()));
    /*****Operacion con SERVICE**************/
        this.localService.guardaLocal(local);
        this.locales=localService.findAll();
    /***************************************/
        this.local=new Local();
        this.local.setId(this.local.hashCode());
        this.local.setMenu(new ArrayList<Menu>());//se agrega la lista del menu
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

  
    
}
