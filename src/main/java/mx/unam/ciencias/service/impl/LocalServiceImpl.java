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

/**
 *
 * @author guillermorojas
 */
public class LocalServiceImpl implements LocalService{

    private static LocalService localService;
    
    private  LocalRepository localRepository;
    
    private LocalServiceImpl(){
        localRepository=LocalRepositoryImpl.getInstance();
    } 
    
    public static LocalService getInstance(){
        if(localService==null){
            localService=new LocalServiceImpl();
        }
        return localService;
    } 
    
    
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
    
}
