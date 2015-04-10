/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.controller.rest;

import java.util.List;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author guillermorojas
 */
@Controller 
@RequestMapping(value="/locales")
public class LocalControllerRest {
    
    @Autowired
    private LocalService localService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET) 
    @ResponseBody
    public List<Local> findAll(){
        return  localService.findAll();
    }
    
    @RequestMapping(value = "/nombre={nombre}", method = RequestMethod.GET) 
    @ResponseBody
    public List<Local> findByNombre(@PathVariable String  nombre){
        return  localService.findByNombre(nombre);
    }
    
}
