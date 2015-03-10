/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.model.Menu;
import mx.unam.ciencias.service.LocalService;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author guillermorojas
 */
@Controller("localController")
@Scope("session")
public class LocalController implements Serializable{
    /********************Comunicacion con la capa de servicio*************/
    @Autowired
    private LocalService localService;

    /******************Variables usadas en la vista ********************/
    private String terminoBusqueda;
    private List<Local> locales;
    private Local local;
    private Menu menu;
    private MapModel simpleModel; // es usado en la vista del ver locales

    @PostConstruct
    public void init(){
        locales=localService.findAll();
        
        simpleModel = new DefaultMapModel(); 
        
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
        this.local.setMenu(new ArrayList<Menu>());//se agrega la lista del menu
    }
    
    public void seleccion(PointSelectEvent event){
         LatLng latlng = event.getLatLng();
         this.local.setLatitud(latlng.getLat());
         this.local.setLongitud(latlng.getLng());
    }
    
    public void buscarPorNombre(){
        this.locales=localService.findByNombre(terminoBusqueda);
         simpleModel = new DefaultMapModel(); 
        for(Local l:this.locales){
            LatLng coord = new LatLng(l.getLatitud(), l.getLongitud()); 
            simpleModel.addOverlay(new Marker(coord, l.getNombre()));
        }
    }
    
     public void buscarPorCategoria(){
        this.locales=localService.findByCategoria(terminoBusqueda);
         simpleModel = new DefaultMapModel(); 
        for(Local l:this.locales){
            LatLng coord = new LatLng(l.getLatitud(), l.getLongitud()); 
            simpleModel.addOverlay(new Marker(coord, l.getNombre()));
        }
    }
     
      public void buscarPorNombreMenu(){
        this.locales=localService.findByMenu(terminoBusqueda);
         simpleModel = new DefaultMapModel(); 
        for(Local l:this.locales){
            LatLng coord = new LatLng(l.getLatitud(), l.getLongitud()); 
            simpleModel.addOverlay(new Marker(coord, l.getNombre()));
        }
    }
      
     public void borraLocal(Local loc){
         localService.eliminarLocal(loc);
         this.locales=localService.findAll();
          simpleModel = new DefaultMapModel(); 
        for(Local l:this.locales){
            LatLng coord = new LatLng(l.getLatitud(), l.getLongitud()); 
            simpleModel.addOverlay(new Marker(coord, l.getNombre()));
        }
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

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }
  
}
