/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.controller;

import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author guillermorojas
 */
@Controller
@Scope("request")
public class ConsultaLocalUrl {
    
    @Autowired
    private LocalService localService;
    
    public Local getLocal(Integer id){
        return  localService.findById(id);
    }
    
}
