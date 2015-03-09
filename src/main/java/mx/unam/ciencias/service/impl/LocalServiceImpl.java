/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.service.impl;

import java.util.List;
import mx.unam.ciencias.dao.LocalRepository;
import mx.unam.ciencias.dao.dummy.LocalRepositoryImpl;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillermorojas
 */
@Service("localServiceImpl")
@Scope("singleton")
public class LocalServiceImpl implements LocalService{
    
    @Autowired
    private  LocalRepository localRepository;
    
    
    private String nombre;
        
    @Override
    public void guardaLocal(Local local) {
        localRepository.save(local);
    }

    @Override
    public void eliminarLocal(Local local) {
        localRepository.delete(local);
    }

    @Override
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    @Override
    public List<Local> findByNombre(String nombre) {
        return localRepository.findByNombre(nombre);
    }

    @Override
    public List<Local> findByCategoria(String categoria) {
       return localRepository.findByCategoria(categoria);
    }
    
     @Override
    public List<Local> findByMenu(String nombreMenu) {
       return localRepository.findByNombreMenu(nombreMenu);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
