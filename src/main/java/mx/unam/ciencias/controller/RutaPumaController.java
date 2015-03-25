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
import mx.unam.ciencias.model.RutaPumaBus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author guillermorojas
 */
@Controller("rutaPumaController")
@Scope("session")
public class RutaPumaController implements Serializable{
    
    private RutaPumaBus  rutaPumaBus;
 
    private List<RutaPumaBus> rutas=new ArrayList<>();
    
    @PostConstruct
    public void init(){
        this.rutaPumaBus=new RutaPumaBus();
       
    }
    
    public void guardaRuta(){
       this.rutas.add(rutaPumaBus);
        this.rutaPumaBus=new RutaPumaBus();
    }

    public List<RutaPumaBus> getRutas() {
        return rutas;
    }

    public void setRutas(List<RutaPumaBus> rutas) {
        this.rutas = rutas;
    }

    public RutaPumaBus getRutaPumaBus() {
        return rutaPumaBus;
    }

    public void setRutaPumaBus(RutaPumaBus rutaPumaBus) {
        this.rutaPumaBus = rutaPumaBus;
    }
    
    
}
